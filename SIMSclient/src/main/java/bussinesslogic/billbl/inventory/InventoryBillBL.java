package bussinesslogic.billbl.inventory;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindInventoryBillType;
import dataenum.findtype.FindUserType;
import dataservice.billdataservice.BillDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import javafx.util.converter.LocalDateStringConverter;
import po.inventorybillpo.InventoryBillPO;
import po.messagepo.MessageExaminePO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class InventoryBillBL implements InventoryBillBLService {

	private BillDataService billDataService;
	private InventoryTransition inventoryTransition;
	private InventoryBillPO inventoryBillPO;

	private UserDataService userDataService;
	private MessageDataService messageDataService;

	private CommodityDataService commodityDataService;

	public InventoryBillBL() {
		billDataService = RemoteHelper.getInstance().getBilldataService();
		inventoryTransition = new InventoryTransition();
		userDataService = RemoteHelper.getInstance().getUserDataService();
		messageDataService = RemoteHelper.getInstance().getMessageDataService();
		commodityDataService = RemoteHelper.getInstance().getCommodityDataService();
	}

	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		ArrayList<InventoryBillVO> inventoryBillVOs = new ArrayList<>();
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs = billDataService.findInventoryBill(text, type);
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				inventoryBillVOs.add(inventoryTransition.POtoVO(inventoryBillPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inventoryBillVOs;
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		ArrayList<InventoryBillVO> inventoryBillVOs = new ArrayList<>();
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs = billDataService.showInventoryBill();
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				inventoryBillVOs.add(inventoryTransition.POtoVO(inventoryBillPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inventoryBillVOs;
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		if (clickedItem.getType() == BillType.INVENTORYLOSSBILL
				|| clickedItem.getType() == BillType.INVENTORYGIFTBILL) {
			for (GiftVO commodity : clickedItem.getGifts()) {
				try {
					if (commodityDataService.findCommodity(getTrueName(commodity.getName()), FindCommodityType.NAME)
							.get(0).getNumber() < commodity.getNumber())
						return ResultMessage.LOWNUMBER;
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		clickedItem.setState(BillState.COMMITED);
		inventoryBillPO = inventoryTransition.VOtoPO(clickedItem);
		try {

			ResultMessage resultMessage = billDataService.insertInventoryBill(inventoryBillPO);
			if (resultMessage == ResultMessage.EXISTED || resultMessage == ResultMessage.SUCCESS) {
				ArrayList<UserPO> generalManagers = userDataService.findUser(UserRole.GENERAL_MANAGER.value,
						FindUserType.USERROLE);
				for (UserPO manager : generalManagers) {
					MessageExaminePO message = new MessageExaminePO(messageDataService.getMessageID(),
							LocalDateTime.now(), false, inventoryBillPO.getId(), manager);
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
	public void delete(InventoryBillVO clickedItem) {
		String id = clickedItem.getId();
		try {
			billDataService.deleteInventoryBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		inventoryBillPO = inventoryTransition.VOtoPO(vo);
		ArrayList<InventoryBillPO> inventoryBillPOs = null;
		try {
			inventoryBillPOs = billDataService.findInventoryBill(inventoryBillPO.getId(), FindInventoryBillType.ID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (inventoryBillPOs.isEmpty()) {
			try {
				return billDataService.insertInventoryBill(inventoryBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} else {
			try {
				return billDataService.updateInventoryBill(inventoryBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public String getId(BillType type) {

		LocalDate l = null;
		l = LocalDate.now();
		int count = 0;
		String[] date = l.toString().split("-");
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs = billDataService.showInventoryBill();
			if (inventoryBillPOs == null) {
				return type.prefix + "-" + date[0] + date[1] + date[2] + "-00001";
			}
			if (inventoryBillPOs.size() == 0) {
				return type.prefix + "-" + date[0] + date[1] + date[2] + "-00001";
			} else {
				String lastBillId = inventoryBillPOs.get(inventoryBillPOs.size() - 1).getId();
				lastBillId = lastBillId.split("-")[2];
				while (lastBillId.charAt(0) == '0') {
					lastBillId = lastBillId.substring(1);
				}
				count = Integer.valueOf(lastBillId);
				count++;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		String id = "";
		// 格式化
		String number = Integer.toString(count);
		while (5 > number.length()) {
			number = "0" + number;
		}

		id = type.prefix + "-" + date[0] + date[1] + date[2] + "-" + number;
		return id;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	/**
	 * 商品名的过滤
	 * 
	 * @param name
	 *            显示在单据上的商品名
	 * @return 真实的商品名
	 */
	public String getTrueName(String name) {
		String newName = "";
		for (int m = 0; m < name.length(); m++) {
			if (name.charAt(m) == '(') {
				newName = name.substring(0, m);
				break;
			}
		}
		return newName;
	}
}
