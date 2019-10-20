package vo.billvo.financialbillvo;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;
import vo.billvo.BillVO;

/**
 *
 * @author 王灿灿
 * @version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO extends BillVO implements Serializable {
	protected String userID;// 当前登录用户的ID
	protected String customer;
	protected String customerID;// 客户ID

	public FinancialDocVO(String docID, String userID, String customer, BillType type, BillState state, String note) {
		super(docID, type, state, note);
		this.userID = userID;
		this.customer = customer;
		int t = 0;
		for (int i = 0; i < customer.length(); i++) {
			if (customer.charAt(i) == '(') {
				t = i + 1;
			} else if (customer.charAt(i) == ')') {
				customerID = customer.substring(t, i);
				break;
			}
		}
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
