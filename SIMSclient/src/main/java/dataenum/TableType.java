package dataenum;

public enum TableType {
	BUSINESS_HISTORY_SCHEDULE("经营历程表"), SALE_SCHEDULE("销售明细表"), STATEMENT_OF_OPERATION("经营情况表");

	public final String value;

	TableType(String value) {
		this.value = value;
	}

	public static TableType getType(String value) {
		switch (value) {
		case "经营历程表":
			return TableType.BUSINESS_HISTORY_SCHEDULE;
		case "销售明细表":
			return TableType.SALE_SCHEDULE;
		case "经营情况表":
			return TableType.STATEMENT_OF_OPERATION;
		default:
			return TableType.STATEMENT_OF_OPERATION;
		}
	}

}
