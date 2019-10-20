package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.commoditydataservice.CommodityDataService;
import po.commoditypo.CommodityPO;

public class CommodityDataService_Stub implements CommodityDataService {

	@Override
	public ResultMessage insertCommodity(CommodityPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateCommodity(CommodityPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteCommodity(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CommodityPO> showCommodity() throws RemoteException {
		CommodityPO po = new CommodityPO("ºÚµÆ-0001", "ºÚÒ¹×·Ð×µÆ", "L", "ºÚµÆ", 200, 25, 29, 24, 28, 2000);
		ArrayList<CommodityPO> list = new ArrayList<>();
		list.add(po);
		return list;

	}

	@Override
	public ArrayList<CommodityPO> findCommodity(String keywords, FindCommodityType type) throws RemoteException {
		CommodityPO po = new CommodityPO("ºÚµÆ-0001", "ºÚÒ¹×·Ð×µÆ", "L", "ºÚµÆ", 200, 25, 29, 24, 28, 2000);
		ArrayList<CommodityPO> list = new ArrayList<>();
		list.add(po);
		return list;

	}

}
