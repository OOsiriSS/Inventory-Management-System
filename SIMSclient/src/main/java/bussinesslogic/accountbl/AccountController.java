package bussinesslogic.accountbl;

import java.util.ArrayList;

import bussinesslogicservice.accountblservice.AccountBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import vo.accountvo.AccountVO;

/**
 *
 * @author Íõ²Ó²Ó
 * @version 2017-12-2
 *
 *          AccountBLÄ£¿éµÄcontroller
 *
 */
public class AccountController implements AccountBLService {

	AccountBL accountBL = new AccountBL();

	@Override
	public ArrayList<AccountVO> find(String message, FindAccountType findType) {
		return accountBL.find(message, findType);
	}

	@Override
	public ResultMessage judgeLegal(AccountVO accountVO) {
		return accountBL.judgeLegal(accountVO);
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		return accountBL.getAccountList();
	}

	@Override
	public ResultMessage add(AccountVO accountVO) {
		return accountBL.add(accountVO);
	}

	@Override
	public ResultMessage modify(AccountVO accountVO) {
		return accountBL.modify(accountVO);
	}

	@Override
	public void delete(AccountVO accountVO) {
		accountBL.delete(accountVO);
	}

}
