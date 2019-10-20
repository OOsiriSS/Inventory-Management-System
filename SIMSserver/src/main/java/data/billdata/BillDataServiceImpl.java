package data.billdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.inventorybillpo.InventoryBillPO;

/**
 *
 * @author ≈À–«”Ó
 * @version 2018-1-1
 */

public class BillDataServiceImpl implements BillDataService {

	BillData billdata;

	public BillDataServiceImpl() {
		billdata = new BillData();
	}

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		return billdata.insertInventoryBill(inventoryBillPO);
	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return billdata.deleteInventoryBill(id);
	}

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		return billdata.updateInventoryBill(inventoryBillPO);
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return billdata.findInventoryBill(keyword, type);
	}

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		// TODO Auto-generated method stub
		return billdata.showInventoryBill();
	}

}
