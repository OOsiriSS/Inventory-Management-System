package dataenum;

public enum MoneyType {

	SALES("销售类"), COMMODITY("商品类");

	public final String value;

	MoneyType(String value) {
		this.value = value;
	}

	public static MoneyType getType(String value) {
		switch (value) {
		case "销售类":
			return SALES;
		default:
			return COMMODITY;
		}
	}

}
