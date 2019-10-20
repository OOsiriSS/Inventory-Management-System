package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.commoditypo.GiftPO;
import po.inventorybillpo.InventoryBillPO;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

/**
 * 
 * @author Lijie
 * @date 2018ƒÍ1‘¬10»’
 */
public class BillDataService_Stub implements BillDataService {

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		GiftPO gift1 = new GiftPO("’’√˜µ∆", 12);
		GiftPO gift2 = new GiftPO("ÃΩ’’µ∆", 23);
		ArrayList<GiftPO> giftList = new ArrayList<>();
		giftList.add(gift1);
		giftList.add(gift2);
		InventoryBillPO po1 = new InventoryBillPO("00001", giftList, "¿ÓΩ‹", BillType.INVENTORYGIFTBILL, BillState.FAIL,
				"cid");
		ArrayList<InventoryBillPO> list = new ArrayList<>();
		list.add(po1);
		return list;
	}

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		GiftPO gift1 = new GiftPO("’’√˜µ∆", 12);
		GiftPO gift2 = new GiftPO("ÃΩ’’µ∆", 23);
		ArrayList<GiftPO> giftList = new ArrayList<>();
		giftList.add(gift1);
		giftList.add(gift2);
		InventoryBillPO po1 = new InventoryBillPO("00001", giftList, "¿ÓΩ‹", BillType.INVENTORYGIFTBILL, BillState.FAIL,
				"cid");
		ArrayList<InventoryBillPO> list = new ArrayList<>();
		list.add(po1);
		return list;
	}

}
