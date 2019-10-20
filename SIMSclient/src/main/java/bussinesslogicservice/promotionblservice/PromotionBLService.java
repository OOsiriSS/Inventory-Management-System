package bussinesslogicservice.promotionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.promotionvo.PromotionVO;

public interface PromotionBLService<P extends PromotionVO> {

	public ResultMessage insert(P vo) throws RemoteException;

	public ResultMessage delete(P vo) throws RemoteException;

	public ResultMessage update(P vo) throws RemoteException;

	public ArrayList<P> getPromotionList() throws RemoteException;

	public String getID() throws RemoteException;

	public ArrayList<P> find(String info, FindPromotionType findType) throws RemoteException;

}
