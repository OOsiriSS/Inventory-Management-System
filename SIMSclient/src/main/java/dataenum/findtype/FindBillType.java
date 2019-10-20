package dataenum.findtype;

public enum FindBillType {

	ID("单据编号"), TYPE("单据类型"), NAME("商品名"), ACCOUNT("银行账户"), MEMBER("会员"), SALEMAN("业务员"), TOTAL("总额"), OPERATOR("操作员");

	public final String value;

	FindBillType(String value) {
		this.value = value;
	}

	public static FindBillType getType(String value) {
		switch (value) {
		case "单据编号":
			return ID;
		case "单据类型":
			return TYPE;
		case "商品名":
			return NAME;
		case "银行账户":
			return ACCOUNT;
		case "会员":
			return MEMBER;
		case "总额":
			return TOTAL;
		case "操作员":
			return OPERATOR;
		default:
			return SALEMAN;
		}
	}

}
