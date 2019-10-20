package dataservice.salesdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import po.salespo.SalesPO;

public interface SalesDataService extends Remote {

	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException;

	public ResultMessage insertSale(SalesPO po) throws RemoteException;

	public ResultMessage deleteSale(String ID) throws RemoteException;

	public ResultMessage updateSale(SalesPO po) throws RemoteException;

	public ArrayList<SalesPO> showSale() throws RemoteException;

	public String getSaleID() throws RemoteException;

	public String getSaleBackID() throws RemoteException;

}
