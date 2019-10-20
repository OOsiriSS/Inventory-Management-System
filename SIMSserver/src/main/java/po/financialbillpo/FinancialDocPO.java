package po.financialbillpo;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;
import po.billpo.BillPO;

public class FinancialDocPO extends BillPO implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String docID;// 单据编号
	protected String userID;// 当前登录用户的ID
	protected String customerID;
	protected String customer;// name(ID)(供货商||销售商||(供货商&&销售商))
	protected String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public FinancialDocPO(String docID, String userID, String customer, BillType billType, BillState billState,
			String note) {
		super(billType, billState);
		this.docID = docID;
		this.userID = userID;
		this.customer = customer;
		this.billType = billType;
		this.billState = billState;
		this.note = note;

	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
