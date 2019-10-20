package po.financialbillpo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

public class ReceiptBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private ArrayList<AccountListPO> accountListPOs;// 转账列表

	private double total;// 总额

	public ReceiptBillPO(String docID, String userID, String customer, BillType billType, BillState billState,
			ArrayList<AccountListPO> accountListPOs, Double total, String note) {
		super(docID, userID, customer, billType, billState, note);
		this.total = total;
		this.accountListPOs = accountListPOs;
		;
	}

	public ArrayList<AccountListPO> getAccountListPOs() {
		return accountListPOs;
	}

	public void setAccountListPOs(ArrayList<AccountListPO> accountListPOs) {
		this.accountListPOs = accountListPOs;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
