package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import po.promotionpo.PromotionTotalPO;

public interface PromotionSumDataService extends Remote {

	public ResultMessage insertPromotion(PromotionTotalPO po) throws RemoteException;

	public ResultMessage deleteSumPromotion(String ID) throws RemoteException;

	public ResultMessage updatePromotion(PromotionTotalPO po) throws RemoteException;

	public ArrayList<PromotionTotalPO> findSumPromotion(String keyword, FindPromotionType type) throws RemoteException;

	public ArrayList<PromotionTotalPO> showSumPromotion() throws RemoteException;

}
