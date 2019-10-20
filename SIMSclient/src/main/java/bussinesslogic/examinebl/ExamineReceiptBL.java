package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.ReceiptBillTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindAccountType;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.accountpo.AccountPO;
import po.financialbillpo.ReceiptBillPO;
import po.memberpo.MemberPO;
import po.messagepo.MessageBillPO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

/**
 * 审批收款单的业务逻辑层
 * 
 * @author 潘星宇
 * @date 2017-12-26
 */
public class ExamineReceiptBL implements ExamineBLService<ReceiptBillVO> {

	private ReceiptBillDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	private AccountDataService accountService;
	private MemberDataService memberService;
	ReceiptBillTransition tansition;

	public ExamineReceiptBL() {
		service = RemoteHelper.getInstance().getReceiptDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		accountService = RemoteHelper.getInstance().getAccountDataService();
		memberService = RemoteHelper.getInstance().getMemeberDataService();
		tansition = new ReceiptBillTransition();
	}

	@Override
	public ResultMessage updateBill(ReceiptBillVO vo) throws RemoteException {
		return service.updateReceiptBill(tansition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<ReceiptBillVO> vos) throws RemoteException {
		for (ReceiptBillVO vo : vos) {
			// 客户应收应付信息的修改
			MemberPO member = memberService.findMember(vo.getCustomerID(), FindMemberType.ID).get(0);
			member.setPayable(member.getPayable() - vo.getTotal());
			memberService.updateMember(member);
			// 账户信息的修改
			for (AccountListVO accountVO : vo.getAccountListVOs()) {
				String accountID = "";
				for (int i = 0; i < accountVO.getAccountID().length(); i++)
					if (accountVO.getAccountID().charAt(i) == ' ') {
						accountID = accountVO.getAccountID().substring(0, i);
						break;
					}
				AccountPO account = accountService.findAccount(accountID, FindAccountType.ID).get(0);
				account.setMoney(account.getMoney() + accountVO.getMoney());
				accountService.updateAccount(account);
			}

			vo.setState(BillState.SUCCESS);
			updateBill(vo);
			// 通知用户
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), LocalDateTime.now(), // 生成一个信息
					false, user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<ReceiptBillVO> vos) throws RemoteException {
		for (ReceiptBillVO vo : vos) {
			vo.setState(BillState.FAIL);
			updateBill(vo);
			// 通知用户
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), LocalDateTime.now(),
					false, user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.FAIL);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptBillVO> getCommitedBills() throws RemoteException {
		ArrayList<ReceiptBillVO> committed = new ArrayList<>();
		ArrayList<ReceiptBillPO> purchaseList = service.showReceiptBill();
		for (ReceiptBillPO po : purchaseList)
			if (po.getBillState() == BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<ReceiptBillVO> committed = new ArrayList<>();
		ArrayList<ReceiptBillPO> purchaseList = service.findReceiptBill(info, FindAccountBillType.getType(type.value));
		for (ReceiptBillPO po : purchaseList)
			if (po.getBillState() == BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

}
