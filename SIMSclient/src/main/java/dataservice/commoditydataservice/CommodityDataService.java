package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import po.commoditypo.CommodityPO;

public interface CommodityDataService extends Remote {

	public ResultMessage insertCommodity(CommodityPO po) throws RemoteException;

	public ResultMessage updateCommodity(CommodityPO po) throws RemoteException;

	public ResultMessage deleteCommodity(String id) throws RemoteException;

	public ArrayList<CommodityPO> showCommodity() throws RemoteException;

	public ArrayList<CommodityPO> findCommodity(String keywords, FindCommodityType type) throws RemoteException;

}
