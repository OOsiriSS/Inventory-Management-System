package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import po.promotionpo.PromotionMemberPO;

public interface PromotionMemberDataService extends Remote {

	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException;

	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException;

	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException;

	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException;

	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException;

}
