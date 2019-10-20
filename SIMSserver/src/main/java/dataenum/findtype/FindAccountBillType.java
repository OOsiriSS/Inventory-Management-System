package dataenum.findtype;

/**
 * 
 * @author Lijie
 * @date 2017年12月14日
 */
public enum FindAccountBillType {
	CUSTOMER("客户"), OPERATOR("操作员"), BILLID("单据编号");

	public final String value;

	FindAccountBillType(String value) {
		this.value = value;
	}

	public FindAccountBillType getType(String value) {
		switch (value) {
		case "单据编号":
			return BILLID;
		case "客户":
			return CUSTOMER;
		default:
			return OPERATOR;
		}
	}
}
