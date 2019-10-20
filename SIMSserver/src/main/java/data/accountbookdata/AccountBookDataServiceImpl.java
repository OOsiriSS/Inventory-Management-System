package data.accountbookdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBookType;
import dataservice.accountbookdataservice.AccountBookDataService;
import po.accountbookpo.AccountBookPO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ14ÈÕ
 */
public class AccountBookDataServiceImpl implements AccountBookDataService {

	private AccountBookData accountbook;

	public AccountBookDataServiceImpl() {
		accountbook = new AccountBookData();
	}

	@Override
	public ResultMessage insertAccountBook(AccountBookPO po) throws RemoteException {
		return accountbook.insert(po);
	}

	@Override
	public ResultMessage deleteAccountBook(String ID) throws RemoteException {
		return accountbook.delete(ID);
	}

	@Override
	public ResultMessage updateAccountBook(AccountBookPO po) throws RemoteException {
		return accountbook.update(po);
	}

	@Override
	public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) throws RemoteException {
		return accountbook.find(keyword, type);
	}

	@Override
	public ArrayList<AccountBookPO> showAccountBook() throws RemoteException {
		return accountbook.show();
	}

}
