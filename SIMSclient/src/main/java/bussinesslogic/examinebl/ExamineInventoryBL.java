package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillBL;
import bussinesslogic.billbl.inventory.InventoryTransition;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindInventoryBillType;
import dataenum.findtype.FindUserType;
import dataservice.billdataservice.BillDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.commoditypo.CommodityPO;
import po.messagepo.MessageBillPO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

/**
 * 审批库存单据的业务逻辑层
 * 
 * @author 潘星宇
 * @date 2017-12-26
 */
public class ExamineInventoryBL implements ExamineBLService<InventoryBillVO> {

	private InventoryBillBLService service;
	private BillDataService dataService;
	private MessageDataService messageService;
	private UserDataService userService;
	private CommodityDataService commodityService;
	private UtilityBLService utilityService;
	InventoryTransition transition;

	public ExamineInventoryBL() {
		service = new InventoryBillBL();
		dataService = RemoteHelper.getInstance().getBilldataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		commodityService = RemoteHelper.getInstance().getCommodityDataService();
		utilityService = new UtilityBL();
		transition = new InventoryTransition();
	}

	@Override
	public ResultMessage updateBill(InventoryBillVO vo) throws RemoteException {
		return dataService.updateInventoryBill(transition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<InventoryBillVO> vos) throws RemoteException {
		for (InventoryBillVO vo : vos) {

			for (GiftVO gift : vo.getGifts()) {
				String name = "";
				for (int i = 0; i < gift.getName().length(); i++)
					if (gift.getName().charAt(i) == '(') {
						name = gift.getName().substring(i + 1, gift.getName().length() - 1);
						break;
					}
				// 对商品数据的修改
				CommodityPO commodity = commodityService.findCommodity(name, FindCommodityType.ID).get(0);

				switch (vo.getType()) {
				case INVENTORYGIFTBILL:
					commodity.setNumner(commodity.getNumber() - gift.getNumber());
					utilityService.warningMessage(commodity);
					break;
				case INVENTORYLOSSBILL:
					commodity.setNumner(commodity.getNumber() - gift.getNumber());
					utilityService.warningMessage(commodity);
					break;
				case INVENTORYREVENUEBILL:
					commodity.setNumner(commodity.getNumber() + gift.getNumber());
					break;
				case INVENTORYWARNINGBILL:
					commodity.setWarningValue(gift.getNumber());
					utilityService.warningMessage(commodity);
					break;
				default:
					break;
				}
				commodityService.updateCommodity(commodity);
			}

			vo.setState(BillState.SUCCESS);
			updateBill(vo);
			// 通知用户
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), LocalDateTime.now(),
					false, user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.SUCCESS);
			System.out.println(message.getInfo());
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<InventoryBillVO> vos) throws RemoteException {

		for (InventoryBillVO vo : vos) {
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
	public ArrayList<InventoryBillVO> getCommitedBills() throws RemoteException {
		ArrayList<InventoryBillVO> committed = new ArrayList<>();
		ArrayList<InventoryBillVO> list = service.show();
		for (InventoryBillVO vo : list)
			if (vo.getState() == BillState.COMMITED)
				committed.add(vo);
		return committed;
	}

	@Override
	public ArrayList<InventoryBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<InventoryBillVO> committed = new ArrayList<>();
		ArrayList<InventoryBillVO> list = service.find(info, FindInventoryBillType.getType(type.value));
		for (InventoryBillVO vo : list)
			if (vo.getState() == BillState.COMMITED)
				committed.add(vo);
		return committed;
	}

}
