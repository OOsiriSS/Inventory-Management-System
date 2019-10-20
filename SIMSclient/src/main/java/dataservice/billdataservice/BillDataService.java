package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import po.inventorybillpo.InventoryBillPO;

public interface BillDataService extends Remote {

	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException;

	public ResultMessage deleteInventoryBill(String id) throws RemoteException;

	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException;

	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException;

	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException;// 这个是把全部的库存类单据都拿过来...

}
