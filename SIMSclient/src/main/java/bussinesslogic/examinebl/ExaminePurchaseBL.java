package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import bussinesslogic.purchasebl.PurchaseTransition;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.userdataservice.UserDataService;
import po.commoditypo.CommodityPO;
import po.memberpo.MemberPO;
import po.messagepo.MessageBillPO;
import po.purchasepo.PurchasePO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

/**
 * 审批进货单的业务逻辑层
 *
 * @author 潘星宇
 * @date 2017-12-25
 */
public class ExaminePurchaseBL implements ExamineBLService<PurchaseVO> {

	private PurchaseDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	private CommodityDataService commodityService;
	private MemberDataService memberService;
	private UtilityBLService utilityService;

	public ExaminePurchaseBL() {
		service = RemoteHelper.getInstance().getPurchaseDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		commodityService = RemoteHelper.getInstance().getCommodityDataService();
		memberService = RemoteHelper.getInstance().getMemeberDataService();
		utilityService = new UtilityBL();
	}

	@Override
	public ResultMessage updateBill(PurchaseVO vo) throws RemoteException {
		return service.updatePurchase(PurchaseTransition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<PurchaseVO> vos) throws RemoteException {

		for (PurchaseVO vo : vos) {
			// 客户应收应付信息的修改
			String memberID = "";
			for (int i = 0; i < vo.getSupplier().length(); i++)
				if (vo.getSupplier().charAt(i) == '(') {
					memberID = vo.getSupplier().substring(i + 1, i + 7);
					System.out.println(memberID);
					break;
				}
			MemberPO member = memberService.findMember(memberID, FindMemberType.ID).get(0);
			if (vo.getType() == BillType.PURCHASEBACKBILL)
				member.setReceivable(member.getReceivable() + vo.getSum());
			else
				member.setPayable(member.getPayable() + vo.getSum());
			// 商品信息的修改
			for (CommodityItemVO item : vo.getCommodities()) {
				String commodityName = "";
				for (int i = 0; i < item.getName().length(); i++)
					if (item.getName().charAt(i) == '(') {
						commodityName = item.getName().substring(0, i);
						break;
					}

				CommodityPO commodity = commodityService.findCommodity(commodityName, FindCommodityType.NAME).get(0);
				if (vo.getType() == BillType.PURCHASEBACKBILL) {
					commodity.setNumner(commodity.getNumber() - item.getNumber());
					utilityService.warningMessage(commodity);
				} else
					commodity.setNumner(commodity.getNumber() + item.getNumber());
				commodityService.updateCommodity(commodity);
			}

			vo.setState(BillState.SUCCESS);
			updateBill(vo);
			// 通知用户
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), LocalDateTime.now(),
					false, user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PurchaseVO> vos) throws RemoteException {
		for (PurchaseVO vo : vos) {
			vo.setState(BillState.FAIL);
			updateBill(vo);
			// 通知用户
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), LocalDateTime.now(),
					false, user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.FAIL);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PurchaseVO> getCommitedBills() throws RemoteException {
		ArrayList<PurchaseVO> committed = new ArrayList<>();
		ArrayList<PurchasePO> purchaseList = service.showPurchase();
		for (PurchasePO po : purchaseList)
			if (po.getState() == BillState.COMMITED)
				committed.add(PurchaseTransition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<PurchaseVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<PurchaseVO> committed = new ArrayList<>();
		ArrayList<PurchasePO> purchaseList = service.findPurchase(info, FindSalesType.getType(type.value));
		for (PurchasePO po : purchaseList)
			if (po.getState() == BillState.COMMITED)
				committed.add(PurchaseTransition.POtoVO(po));
		return committed;
	}

}
