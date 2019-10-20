package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import po.commoditypo.GiftPO;
import po.inventorybillpo.InventoryBillPO;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class InventoryTransition {
	InventoryBillPO inventoryBillPO;
	InventoryBillVO inventoryBillVO;

	public InventoryBillPO VOtoPO(InventoryBillVO inventoryBillVO) {
		String id = inventoryBillVO.getId();
		ArrayList<GiftVO> giftVOs = inventoryBillVO.getGifts();
		GiftPO giftPO = new GiftPO("", 0);
		ArrayList<GiftPO> giftPOs = new ArrayList<>();
		for (int i = 0; i < giftVOs.size(); i++) {
			giftPO.setName(giftVOs.get(i).getName());
			giftPO.setNumber(giftVOs.get(i).getNumber());
			giftPOs.add(giftPO);
		}
		String note = inventoryBillVO.getNote();
		String operator = inventoryBillVO.getOperator();
		BillState billState = inventoryBillVO.getState();
		BillType billType = inventoryBillVO.getType();
		inventoryBillPO = new InventoryBillPO(id, giftPOs, operator, billType, billState, note);
		return inventoryBillPO;
	}

	public InventoryBillVO POtoVO(InventoryBillPO inventoryBillPO) {
		String id = inventoryBillPO.getId();
		ArrayList<GiftPO> giftPOs = inventoryBillPO.getGifts();
		GiftVO giftVO = new GiftVO("", 0);
		ArrayList<GiftVO> giftVOs = new ArrayList<>();
		for (int i = 0; i < giftPOs.size(); i++) {
			giftVO.setName(giftPOs.get(i).getName());
			giftVO.setNumber(giftPOs.get(i).getNumber());
			giftVOs.add(giftVO);
		}
		String note = inventoryBillPO.getNote();
		String operator = inventoryBillPO.getOperator();
		BillState billState = inventoryBillPO.getBillState();
		BillType billType = inventoryBillPO.getBillType();
		inventoryBillVO = new InventoryBillVO(id, giftVOs, operator, billType, billState, note);
		return inventoryBillVO;
	}
}
