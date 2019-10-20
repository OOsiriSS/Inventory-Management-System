package bussinesslogic.accountbookbl;

import java.util.ArrayList;

import bussinesslogicservice.accountbookblservice.AccountBookBLService;
import dataenum.ResultMessage;
import vo.accountbookvo.AccountBookVO;

public class AccountBookController implements AccountBookBLService {
	AccountBookBL accountBookBL = new AccountBookBL();

	@Override
	public ResultMessage newBuild(AccountBookVO accountBookVO) {
		return accountBookBL.newBuild(accountBookVO);
	}

	@Override
	public ArrayList<AccountBookVO> show() {
		return accountBookBL.show();
	}

	@Override
	public AccountBookVO choseByYear(int date) {
		return accountBookBL.choseByYear(date);
	}

}
