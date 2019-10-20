package bussinesslogic.accountbl;

import po.accountpo.AccountPO;
import vo.accountvo.AccountVO;

public class AccountTransition {

	public AccountPO VOtoPO(AccountVO accountVO) {
		String id = accountVO.getId();
		String name = accountVO.getName();
		Double money = accountVO.getMoney();
		return new AccountPO(id, name, money);
	}

	public AccountVO POtoVO(AccountPO accountPO) {
		String id = accountPO.getId();
		String name = accountPO.getName();
		Double money = accountPO.getMoney();
		return new AccountVO(id, name, money);
	}

}
