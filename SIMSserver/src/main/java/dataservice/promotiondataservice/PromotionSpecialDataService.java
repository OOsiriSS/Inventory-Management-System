package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import po.promotionpo.PromotionPricePacksPO;

public interface PromotionSpecialDataService extends Remote {

	public ResultMessage insertPromotion(PromotionPricePacksPO po) throws RemoteException;

	public ResultMessage deleteSpecialPromotion(String ID) throws RemoteException;

	public ResultMessage updatePromotion(PromotionPricePacksPO po) throws RemoteException;

	public ArrayList<PromotionPricePacksPO> findSpecialPromotion(String keyword, FindPromotionType type)
			throws RemoteException;

	public ArrayList<PromotionPricePacksPO> showSpecialPromotion() throws RemoteException;

}
