package dataenum.findtype;

public enum FindInventoryBillType {

	ID("单据编号"), TYPE("单据类型"), NAME("商品名"), STATE("单据状态");

	public final String value;

	FindInventoryBillType(String value) {
		this.value = value;
	}

	public static FindInventoryBillType getType(String value) {
		switch (value) {
		case "单据编号":
			return ID;
		case "单据类型":
			return TYPE;
		case "商品名":
			return NAME;
		default:
			return STATE;
		}
	}

}
