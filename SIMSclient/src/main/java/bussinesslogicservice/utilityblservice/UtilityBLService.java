package bussinesslogicservice.utilityblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.commoditypo.CommodityPO;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);

	/**
	 * 通过用户信息得到该用户的最新信息
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<MessageVO> getMessage(UserVO user);

	/**
	 * 判断给用户是否拥有最新信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean hasMessage(UserVO user);

	/**
	 * 当商品减少的时候需判断一下是否达到警戒值
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void warningMessage(CommodityPO po) throws RemoteException;

	public void saveMessage(MessageVO message) throws RemoteException;

}
