package po.financialbillpo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

public class PaymentBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private double total;// 总额
	private String accountID;
	private ArrayList<EntryPO> entryListPO;// 条目清单

	public PaymentBillPO(String docID, String userID, String customer, String accountID, ArrayList<EntryPO> entryListPO,
			Double total, BillType billType, BillState billState, String note) {
		super(docID, userID, customer, billType, billState, note);
		this.entryListPO = entryListPO;
		this.accountID = accountID;
		this.total = total;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<EntryPO> getEntryListPO() {
		return entryListPO;
	}

	public void setEntryListPO(ArrayList<EntryPO> entryListPO) {
		this.entryListPO = entryListPO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
