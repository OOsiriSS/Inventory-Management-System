package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

//import bussinesslogic.billbl.inventory.Gift.GiftBillController;
//import bussinesslogic.billbl.inventory.Loss.LossBillController;
//import bussinesslogic.billbl.inventory.Revenue.RevenueBillController;
//import bussinesslogic.billbl.inventory.Warn.WarnBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillController implements InventoryBillBLService {

	InventoryBillBL inventoryBillBL = new InventoryBillBL();

	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		return inventoryBillBL.find(text, type);
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		return inventoryBillBL.show();
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		return inventoryBillBL.submit(clickedItem);
	}

	@Override
	public void delete(InventoryBillVO clickedItem) {
		inventoryBillBL.delete(clickedItem);
	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		return inventoryBillBL.save(vo);
	}

	@Override
	public String getId(BillType type) {// 得到新建单据的Id
		return inventoryBillBL.getId(type);
	}

}
