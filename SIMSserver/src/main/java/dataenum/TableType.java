package dataenum;

public enum TableType {
	BUSINESS_HISTORY_SCHEDULE("经营历程表"), SALE_SCHEDULE("销售明细表"), STATEMENT_OF_OPERATION("经营情况表");

	public final String type;

	TableType(String type) {
		this.type = type;
	}

}
