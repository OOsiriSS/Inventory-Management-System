package vo.billvo.financialbillvo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

/**
 *
 * @author 王灿灿
 * @version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class PaymentBillVO extends FinancialDocVO {
	private Double total;// 总额
	private String accountID;
	private ArrayList<EntryVO> entryListVO;// 条目清单

	public PaymentBillVO(String docID, String userID, String customer, String accountID, ArrayList<EntryVO> entryListVO,
			Double total, BillType billType, BillState billState, String note) {
		super(docID, userID, customer, billType, billState, note);
		this.entryListVO = entryListVO;
		this.accountID = accountID;
		this.total = total;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public ArrayList<EntryVO> getEntryListVO() {
		return entryListVO;
	}

	public void setEntryListVO(ArrayList<EntryVO> entryListVO) {
		this.entryListVO = entryListVO;
	}

}
