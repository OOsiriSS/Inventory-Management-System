package data.purchasedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.purchasedataservice.PurchaseDataService;
import po.purchasepo.PurchasePO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ8ÈÕ
 */
public class PurchaseDataServiceImpl implements PurchaseDataService {

	private PurchaseData purchase;

	public PurchaseDataServiceImpl() {
		purchase = new PurchaseData();
	}

	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return purchase.insert(po);
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return purchase.delete(ID);
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return purchase.update(po);
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return purchase.show();
	}

	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return purchase.find(keyword, type);
	}

}
