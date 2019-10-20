package po.financialbillpo;

import java.io.Serializable;

public class AccountListPO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected String accountID;// 银行账户ID
	protected Double money;// 转账金额
	protected String note;// 备注

	public AccountListPO(String accountID, Double money, String note) {
		this.accountID = accountID;
		this.money = money;
		this.note = note;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
