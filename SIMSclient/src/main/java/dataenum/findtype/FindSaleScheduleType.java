package dataenum.findtype;

public enum FindSaleScheduleType {

	NAME("商品名"), MEMBER("客户"), OPERATOR("业务员"), WAREHOUSE("仓库");

	public final String value;

	FindSaleScheduleType(String value) {
		this.value = value;
	}

	public static FindSaleScheduleType getType(String value) {
		switch (value) {
		case "商品名":
			return NAME;
		case "客户":
			return MEMBER;
		case "业务员":
			return OPERATOR;
		default:
			return WAREHOUSE;
		}
	}
}
