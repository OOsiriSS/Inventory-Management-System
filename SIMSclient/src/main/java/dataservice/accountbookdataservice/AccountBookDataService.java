package dataservice.accountbookdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBookType;
import po.accountbookpo.AccountBookPO;

/**
 * 
 * @ClassName: SetUpAccountDataService
 * @Description: 期初建账 ,只有增加，查看和显示
 * @author lijie
 * @date 2017年12月3日 上午11:10:47
 *
 */
public interface AccountBookDataService extends Remote {
	public ResultMessage insertAccountBook(AccountBookPO po) throws RemoteException;

	public ResultMessage deleteAccountBook(String ID) throws RemoteException;

	public ResultMessage updateAccountBook(AccountBookPO po) throws RemoteException;

	public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) throws RemoteException;

	public ArrayList<AccountBookPO> showAccountBook() throws RemoteException;
}
