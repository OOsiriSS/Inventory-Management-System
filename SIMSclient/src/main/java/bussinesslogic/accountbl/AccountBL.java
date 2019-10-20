package bussinesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.accountblservice.AccountBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import rmi.RemoteHelper;
import vo.accountvo.AccountVO;

/**
 *
 * @author 王灿灿
 * @version 2017-12-10
 */
public class AccountBL implements AccountBLService {

	AccountDataService accountDataService;
	AccountTransition accountTransition;
	AccountVO accountVO;
	AccountPO accountPO;

	public AccountBL() {
		accountDataService = RemoteHelper.getInstance().getAccountDataService();
		accountTransition = new AccountTransition();
	}

	@Override
	public ResultMessage add(AccountVO accountVO) {

		accountPO = new AccountPO("", "", 0.0);

		double m = Double.valueOf(accountVO.getMoney());

		boolean judge = true;
		if (!find(accountVO.getId(), FindAccountType.ID).isEmpty()) {
			judge = false;
			return ResultMessage.ILLEGALINPUTNAME;
		}
		if (0 > m || Double.MAX_VALUE < m) {
			judge = false;
			return ResultMessage.ILLEAGLINPUTDATA;
		}
		if (judge) {
			accountPO = accountTransition.VOtoPO(accountVO);
			try {
				return accountDataService.insertAccount(accountPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		}
		return ResultMessage.FAIL;
	}

	/**
	 * @author 王灿灿
	 */
	@Override
	public ResultMessage modify(AccountVO accountVO) {
		accountPO = new AccountPO("", "", 0.0);
		accountPO = accountTransition.VOtoPO(accountVO);
		try {
			accountDataService.updateAccount(accountPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(AccountVO accountVO) {
		String id = accountVO.getId();
		try {
			accountDataService.deleteAccount(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断输入的account是否合法
	 *
	 * @author 王灿灿
	 * @param accountVO
	 *            为传入的已修改的account对象
	 *
	 */
	@Override
	public ResultMessage judgeLegal(AccountVO accountVO) {
		String id = accountVO.getId();
		String name = accountVO.getName();
		Double money = accountVO.getMoney();
		// id的字符必须为0~9
		for (int i = 0; i < id.length(); i++) {
			if (!('0' <= id.charAt(i) && id.charAt(i) <= '9')) {
				return ResultMessage.ILLEAGLINPUTDATA;
			}
		}
		// accountName不允许有空格
		for (int i = 0; i < name.length(); i++) {
			if (32 == name.charAt(i)) {
				return ResultMessage.ILLEGALINPUTNAME;
			}
		}
		// money不能为负数
		if (Double.valueOf(money) < 0) {
			return ResultMessage.ILLEAGLINPUTDATA;
		}

		return ResultMessage.FAIL;
	}

	/**
	 * @author 王灿灿
	 * @param message为检索内容
	 *
	 */
	@Override
	public ArrayList<AccountVO> find(String message, FindAccountType findType) {

		accountVO = new AccountVO("", "", 0.0);

		ArrayList<AccountVO> accountVOs = new ArrayList<>();
		ArrayList<AccountPO> accountPOs = new ArrayList<>();
		try {
			accountPOs = accountDataService.findAccount(message, findType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < accountPOs.size(); i++) {
			accountVO = accountTransition.POtoVO(accountPOs.get(i));
			accountVOs.add(accountVO);
		}

		return accountVOs;
	}

	/**
	 *
	 * @author 王灿灿 得到当前服务器上银行账户的数据
	 *
	 */
	@Override
	public ArrayList<AccountVO> getAccountList() {

		accountVO = new AccountVO("", "", 0.0);

		ArrayList<AccountPO> accountPOs = null;
		ArrayList<AccountVO> accountVOs = new ArrayList<>();
		try {
			accountPOs = accountDataService.showAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (!accountPOs.isEmpty()) {
			for (int i = 0; i < accountPOs.size(); i++) {
				accountVO = accountTransition.POtoVO(accountPOs.get(i));
				accountVOs.add(accountVO);
			}
		}

		return accountVOs;
	}

}
