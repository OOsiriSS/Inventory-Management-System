package dataenum.findtype;

public enum FindPurchaseType {

	ID("单据编号"), MEMBER("客户"), OPERATOR("操作员"), TOTAL("总额");

	public final String value;

	FindPurchaseType(String value) {
		this.value = value;
	}

	public static FindPurchaseType getType(String value) {
		switch (value) {
		case "单据编号":
			return ID;
		case "客户":
			return MEMBER;
		case "操作员":
			return OPERATOR;
		default:
			return TOTAL;
		}
	}

}
