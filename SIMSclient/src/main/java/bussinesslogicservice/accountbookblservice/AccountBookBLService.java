package bussinesslogicservice.accountbookblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.accountbookvo.AccountBookVO;

public interface AccountBookBLService {

	public ResultMessage newBuild(AccountBookVO accountBookVO);// ÐÂ½¨

	public ArrayList<AccountBookVO> show();

	public AccountBookVO choseByYear(int date);

}
