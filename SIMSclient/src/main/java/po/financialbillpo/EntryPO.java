package po.financialbillpo;

import java.io.Serializable;

public class EntryPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 条目清单
	protected String entryName;// 条目名
	protected double transferAmount;// 金额
	protected String note;// 备注

	public EntryPO(String entryName, double transferAmount, String note) {
		this.transferAmount = transferAmount;
		this.entryName = entryName;
		this.note = note;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
