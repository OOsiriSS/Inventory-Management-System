package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import bussinesslogic.accountbl.AccountController;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.financialbillpo.ReceiptBillPO;
import po.messagepo.MessageExaminePO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillBL implements ReceiptBillBLService {

	private ReceiptBillVO receiptBillVO;
	private ReceiptBillPO receiptBillPO;

	private ReceiptBillTransition receiptBillTransition;
	private ReceiptBillDataService receiptBillDataService;

	private AccountBLService accountBLService;
	private MemberBLService memberBLService;

	private UserDataService userDataService;
	private MessageDataService messageDataService;

	private String date;

	public ReceiptBillBL() {
		receiptBillTransition = new ReceiptBillTransition();
		receiptBillDataService = RemoteHelper.getInstance().getReceiptDataService();
		accountBLService = new AccountController();
		memberBLService = new MemberController();
		userDataService = RemoteHelper.getInstance().getUserDataService();
		messageDataService = RemoteHelper.getInstance().getMessageDataService();
	}

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		receiptBillPO = receiptBillTransition.VOtoPO(receiptBillVO);
		ArrayList<ReceiptBillPO> receiptBillPOs = null;
		try {
			receiptBillPOs = receiptBillDataService.findReceiptBill(receiptBillVO.getId(), FindAccountBillType.BILLID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (receiptBillPOs.isEmpty()) {

			try {
				String customerID = "";
				String customer = receiptBillVO.getCustomer();
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
				receiptBillVO.setCustomerID(customerID);
				return receiptBillDataService.insertReceiptBill(receiptBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		} else {
			try {
				return receiptBillDataService.updateReceiptBill(receiptBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		String id = receiptBillVO.getId();
		try {
			return receiptBillDataService.deleteReceiptBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		ArrayList<ReceiptBillVO> aBillVOs = new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs = receiptBillDataService.showReceiptBill();
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO = receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type) {
		ArrayList<ReceiptBillVO> aBillVOs = new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs = receiptBillDataService.findReceiptBill(info, type);
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO = receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
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
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		receiptBillVO.setState(BillState.COMMITED);
		receiptBillPO = receiptBillTransition.VOtoPO(receiptBillVO);
		try {
			ResultMessage resultMessage = receiptBillDataService.insertReceiptBill(receiptBillPO);
			if (resultMessage == ResultMessage.EXISTED || resultMessage == ResultMessage.SUCCESS) {
				ArrayList<UserPO> generalManagers = userDataService.findUser(UserRole.GENERAL_MANAGER.value,
						FindUserType.USERROLE);
				for (UserPO manager : generalManagers) {
					MessageExaminePO message = new MessageExaminePO(messageDataService.getMessageID(),
							LocalDateTime.now(), false, receiptBillPO.getDocID(), manager);
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
	public String getId() {
		ArrayList<ReceiptBillPO> list = null;
		try {
			list = receiptBillDataService.showReceiptBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (ReceiptBillPO po : list) {
			id = po.getDocID();
			String temp[] = id.split("-");

			if (temp[0].equals("SKD")) {
				IDList.add(Long.parseLong(temp[1] + temp[2]));
			}
		}
		Collections.sort(IDList);
		String day = getDate();
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
		StringBuilder s = new StringBuilder("SKD-");
		return s.append(day).append("-").append(id).toString();
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
		return this.date;
	}

}
