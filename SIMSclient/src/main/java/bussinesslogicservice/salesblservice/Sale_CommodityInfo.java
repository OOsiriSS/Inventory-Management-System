package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;

import dataenum.BillType;

/**
 * 
 * @author Lijie
 * @date 2017年12月11日
 */
public interface Sale_CommodityInfo {

	public boolean checkNumber(String id, int i) throws RemoteException; // 审批的时候，检查现在商品的数量是否够

	public void setDelete(String id, boolean canDelete) throws RemoteException; // 设置成是否可以删除

	public String getName(String id) throws RemoteException;

	public String getModel(String id) throws RemoteException;

	public void changeCommodityInfo(String id, int number, double price, BillType billType) throws RemoteException;

}
