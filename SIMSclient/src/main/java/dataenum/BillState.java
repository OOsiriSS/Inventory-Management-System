package dataenum;

public enum BillState {

	DRAFT("草稿状态"), COMMITED("已提交状态"), SUCCESS("审批成功"), FAIL("审批失败");

	public final String value;

	BillState(String value) {
		this.value = value;
	}
}
