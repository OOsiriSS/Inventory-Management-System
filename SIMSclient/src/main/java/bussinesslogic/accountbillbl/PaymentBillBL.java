package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import bussinesslogic.accountbl.AccountController;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.financialbillpo.PaymentBillPO;
import po.messagepo.MessageExaminePO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.PaymentBillVO;

public class PaymentBillBL implements PaymentBillBLService {

	private PaymentBillPO paymentBillPO;
	private PaymentBillVO paymentBillVO;

	private PaymentBillTransition paymentBillTransition;
	private PaymentBillDataService paymentBillDataService;

	private AccountBLService accountBLService;
	private MemberBLService memberBLService;
	private UserDataService userDataService;
	private MessageDataService messageDataService;

	private String date;

	public PaymentBillBL() {
		paymentBillTransition = new PaymentBillTransition();
		paymentBillDataService = RemoteHelper.getInstance().getPaymentDataService();
		accountBLService = new AccountController();
		memberBLService = new MemberController();
		userDataService = RemoteHelper.getInstance().getUserDataService();
		messageDataService = RemoteHelper.getInstance().getMessageDataService();
	}

	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		paymentBillPO = paymentBillTransition.VOtoPO(paymentBillVO);
		ArrayList<PaymentBillPO> paymentBillPOs = null;
		try {
			paymentBillPOs = paymentBillDataService.findPaymentBill(paymentBillVO.getId(), FindAccountBillType.BILLID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (paymentBillPOs.isEmpty()) {// 找不到，新建
			try {
				String customerID = "";
				String customer = paymentBillVO.getCustomer();
				for (int i = 0; i < customer.length(); i++) {
					if ('(' == customer.charAt(i)) {
						for (int j = i + 1; j < customer.length(); j++) {
							if (')' != customer.charAt(j)) {
								customerID += customer.charAt(j);
							} else {
								break;
							}
						}
						break;
					}
				}
				paymentBillPO.setCustomerID(customerID);
				return paymentBillDataService.insertPaymentBill(paymentBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} else {// 找到，修改
			try {
				return paymentBillDataService.updatePaymentBill(paymentBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		String id = paymentBillVO.getId();
		try {
			return paymentBillDataService.deletePaymentBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 仅仅用于手动创建单据时判断，不能用于红冲和红冲并复制
	 */
	@Override
	public ResultMessage judgeLegal(String money) {
		Double m = Double.valueOf(money);
		if (0 > m) {
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		paymentBillVO.setState(BillState.COMMITED);
		paymentBillPO = paymentBillTransition.VOtoPO(paymentBillVO);
		try {
			ResultMessage resultMessage = paymentBillDataService.insertPaymentBill(paymentBillPO);
			if (resultMessage == ResultMessage.SUCCESS || resultMessage == ResultMessage.EXISTED) {
				ArrayList<UserPO> generalManagers = userDataService.findUser(UserRole.GENERAL_MANAGER.value,
						FindUserType.USERROLE);
				for (UserPO manager : generalManagers) {
					MessageExaminePO message = new MessageExaminePO(messageDataService.getMessageID(),
							LocalDateTime.now(), false, paymentBillVO.getId(), manager);
					messageDataService.save(message);
				}
			}
			return resultMessage;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PaymentBillVO> show() {
		ArrayList<PaymentBillVO> aBillVOs = new ArrayList<>();
		try {
			ArrayList<PaymentBillPO> aBillPOs = paymentBillDataService.showPaymentBill();
			for (int i = 0; i < aBillPOs.size(); i++) {
				paymentBillVO = paymentBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(paymentBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindAccountBillType type) {
		ArrayList<PaymentBillVO> aBillVOs = new ArrayList<>();
		try {
			ArrayList<PaymentBillPO> aBillPOs = paymentBillDataService.findPaymentBill(info, type);
			for (int i = 0; i < aBillPOs.size(); i++) {
				paymentBillVO = paymentBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(paymentBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<String> getAccountList() {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<AccountVO> accountVOs = accountBLService.getAccountList();
		String a = "";
		for (int i = 0; i < accountVOs.size(); i++) {
			a = accountVOs.get(i).getId() + " " + accountVOs.get(i).getName();
			list.add(a);
		}
		return list;
	}

	@Override
	public ArrayList<String> getCustomerList() {
		ArrayList<String> list = null;
		try {
			list = memberBLService.getIDandName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getId() {
		ArrayList<PaymentBillPO> list = null;
		try {
			list = paymentBillDataService.showPaymentBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (PaymentBillPO po : list) {
			id = po.getDocID();
			String temp[] = id.split("-");

			if (temp[0].equals("XJFYD")) {
				IDList.add(Long.parseLong(temp[1] + temp[2]));
			}
		}
		Collections.sort(IDList);
		String day = getDate();
		// Collections.reverse(IDList);
		String num = null;
		if (IDList.size() == 0)
			num = getDate() + "00000";
		else
			num = String.valueOf(IDList.get(IDList.size() - 1));
		if (day.equals(String.valueOf(num.substring(0, 8)))) {
			String index = num.substring(8, num.length());
			index = String.valueOf(Integer.parseInt(index) + 1);
			StringBuilder sb = new StringBuilder(index);
			int len = index.length();
			for (int i = 0; i < 5 - len; i++) {
				sb.insert(0, "0");
			}
			id = sb.toString();
		} else {
			id = "00001";
		}
		StringBuilder s = new StringBuilder("XJFYD-");
		return s.append(day).append("-").append(id).toString();
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
		return this.date;
	}

}
