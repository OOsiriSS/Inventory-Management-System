package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import po.accountpo.AccountPO;

/**
 * 
 * @author 王灿灿
 * @version 2017-12-1
 */
/**
 * 
 * @ClassName: AccountDataService
 * @author lijie
 * @date 2017年12月3日 上午10:03:44
 *
 */
public interface AccountDataService extends Remote {

	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException;

	public ArrayList<AccountPO> showAccount() throws RemoteException;

	public ResultMessage insertAccount(AccountPO po) throws RemoteException;

	public ResultMessage updateAccount(AccountPO po) throws RemoteException;

	public ResultMessage deleteAccount(String id) throws RemoteException;
}
