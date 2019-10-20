package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class InventoryBillBLService_Stub implements InventoryBillBLService {

	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		GiftVO gift1 = new GiftVO("’’√˜µ∆", 12);
		GiftVO gift2 = new GiftVO("ÃΩ’’µ∆", 23);
		ArrayList<GiftVO> giftList = new ArrayList<>();
		giftList.add(gift1);
		giftList.add(gift2);
		InventoryBillVO vo1 = new InventoryBillVO("00001", giftList, "¿ÓΩ‹", BillType.INVENTORYGIFTBILL, BillState.FAIL,
				"cid");
		ArrayList<InventoryBillVO> list = new ArrayList<>();
		list.add(vo1);
		return list;
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		GiftVO gift1 = new GiftVO("’’√˜µ∆", 12);
		GiftVO gift2 = new GiftVO("ÃΩ’’µ∆", 23);
		ArrayList<GiftVO> giftList = new ArrayList<>();
		giftList.add(gift1);
		giftList.add(gift2);
		InventoryBillVO vo1 = new InventoryBillVO("00001", giftList, "¿ÓΩ‹", BillType.INVENTORYGIFTBILL, BillState.FAIL,
				"cid");
		ArrayList<InventoryBillVO> list = new ArrayList<>();
		list.add(vo1);
		return list;
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(InventoryBillVO clickedItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getId(BillType type) {
		// TODO Auto-generated method stub
		return "000001";
	}

}
