package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.purchasepo.PurchasePO;
import po.salespo.SalesPO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ15ÈÕ
 */
public interface CommonDataService extends Remote {

	public ArrayList<SalesPO> showSales() throws RemoteException;

	public ArrayList<PurchasePO> showPurchase() throws RemoteException;
}
