package data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-2
 * 
 */
public class AccountDataServiceMySqlImpl implements AccountDataService {

	private AccountData account;

	public AccountDataServiceMySqlImpl() {
		account = new AccountData();
	}

	@Override
	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException {
		return account.find(keywords, type);
	}

	@Override
	public ArrayList<AccountPO> showAccount() throws RemoteException {
		return account.show();
	}

	@Override
	public ResultMessage insertAccount(AccountPO po) throws RemoteException {
		return account.insert(po);
	}

	@Override
	public ResultMessage deleteAccount(String id) throws RemoteException {
		return account.delete(id);
	}

	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		return account.update(po);
	}

}
