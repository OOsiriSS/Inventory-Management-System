package bussinesslogic.accountbookbl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbl.AccountBL;
import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbookblservice.AccountBookBLService;
import dataenum.ResultMessage;
import dataservice.accountbookdataservice.AccountBookDataService;
import po.accountbookpo.AccountBookPO;
import rmi.RemoteHelper;
import vo.accountbookvo.AccountBookVO;

public class AccountBookBL implements AccountBookBLService {

	private AccountBookVO accountBookVO;
	private AccountBookPO accountBookPO;

	private AccountBookTransition accountBookTransition;
	private AccountBookDataService accountBookDataService;

	private MemberController memberService;
	private CommodityBL commodityService;
	private AccountBL accountService;

	public AccountBookBL() {
		accountBookTransition = new AccountBookTransition();
		accountBookDataService = RemoteHelper.getInstance().getSetUpAccountDataService();
		memberService = new MemberController();
		commodityService = new CommodityBL();
		accountService = new AccountBL();
	}

	@Override
	public ResultMessage newBuild(AccountBookVO accountBookVO) {
		String date = accountBookVO.getDate();
		ArrayList<AccountBookVO> accountBookVOs = show();
		for (int i = 0; i < accountBookVOs.size(); i++) {
			if (date.equals(accountBookVOs.get(i).getDate())) {
				return ResultMessage.FAIL;
			}
		}
		accountBookPO = accountBookTransition.VOtoPO(accountBookVO);

		try {
			return accountBookDataService.insertAccountBook(accountBookPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<AccountBookVO> show() {

		ArrayList<AccountBookVO> accountBookVOs = new ArrayList<>();
		try {
			ArrayList<AccountBookPO> accountBookPOs = accountBookDataService.showAccountBook();
			for (int i = 0; i < accountBookPOs.size(); i++) {
				accountBookVOs.add(accountBookTransition.POtoVO(accountBookPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return accountBookVOs;
	}

	@Override
	public AccountBookVO choseByYear(int date) {
		String d = Integer.toString(date);
		ArrayList<AccountBookVO> accountBookVOs = show();
		for (int i = 0; i < accountBookVOs.size(); i++) {
			if (d.equals(accountBookVOs.get(i).getDate())) {
				accountBookVO = accountBookVOs.get(i);
				break;
			}
		}
		if (date == LocalDate.now().getYear() && accountBookVO == null) {
			try {
				accountBookVO = new AccountBookVO(String.valueOf(date), null, commodityService.show(),
						memberService.show(), accountService.getAccountList());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return accountBookVO;
	}

}
