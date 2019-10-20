package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.commoditydataservice.CommodityDataService;
import po.commoditypo.CommodityPO;

public class CommodityDataServiceMySqlImpl implements CommodityDataService {

	private CommodityData commodity;

	public CommodityDataServiceMySqlImpl() {
		commodity = new CommodityData();
	}

	@Override
	public ResultMessage insertCommodity(CommodityPO po) throws RemoteException {
		return commodity.insert(po);
	}

	@Override
	public ResultMessage updateCommodity(CommodityPO po) throws RemoteException {
		return commodity.update(po);
	}

	@Override
	public ResultMessage deleteCommodity(String id) throws RemoteException {
		return commodity.delete(id);
	}

	@Override
	public ArrayList<CommodityPO> showCommodity() throws RemoteException {
		return commodity.show();
	}

	@Override
	public ArrayList<CommodityPO> findCommodity(String keywords, FindCommodityType type) throws RemoteException {
		return commodity.find(keywords, type);
	}

}
