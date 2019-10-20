package dataservice.purchasedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import po.purchasepo.PurchasePO;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年10月22日
 */
public interface PurchaseDataService extends Remote {

	public static final String NAME = "PurchaseData";

	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException;

	public ResultMessage deletePurchase(String ID) throws RemoteException;

	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException;

	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException;

	public ArrayList<PurchasePO> showPurchase() throws RemoteException;
}
