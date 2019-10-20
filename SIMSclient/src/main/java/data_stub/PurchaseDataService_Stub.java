package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataservice.purchasedataservice.PurchaseDataService;
import po.commoditypo.CommodityItemPO;
import po.purchasepo.PurchasePO;

/**
 * 
 * @author Lijie
 * @date 2018ƒÍ1‘¬10»’
 */
public class PurchaseDataService_Stub implements PurchaseDataService {

	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		CommodityItemPO i = new CommodityItemPO("00001", "5201314", "44", 50, 20, "55");
		ArrayList<CommodityItemPO> list = new ArrayList<>();
		list.add(i);
		PurchasePO po = new PurchasePO("JHTHD-20171231-00001", "000001", "≈À–«”Ó", Warehouse.WAREHOUSE1, "11", list, "2",
				100, BillType.PURCHASEBACKBILL, BillState.COMMITED);
		ArrayList<PurchasePO> result = new ArrayList<>();
		result.add(po);
		return result;
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		CommodityItemPO i = new CommodityItemPO("00001", "5201314", "44", 50, 20, "55");
		ArrayList<CommodityItemPO> list = new ArrayList<>();
		list.add(i);
		PurchasePO po = new PurchasePO("JHTHD-20171231-00001", "000001", "≈À–«”Ó", Warehouse.WAREHOUSE1, "11", list, "2",
				100, BillType.PURCHASEBACKBILL, BillState.COMMITED);
		ArrayList<PurchasePO> result = new ArrayList<>();
		result.add(po);
		return result;
	}

}
