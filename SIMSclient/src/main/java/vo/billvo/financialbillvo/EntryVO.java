package vo.billvo.financialbillvo;

public class EntryVO {
	// 条目清单
	protected String entryName;// 条目名
	protected Double transferAmount;// 金额
	protected String note;// 备注

	public EntryVO(String entryName, Double transferAmount, String note) {
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

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
