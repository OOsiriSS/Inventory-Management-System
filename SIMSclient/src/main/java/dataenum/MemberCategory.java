package dataenum;

public enum MemberCategory {

	RETAILER("销售商"), SUPPLIER("进货商"), BOTH("进货商&销售商");

	public final String value;

	MemberCategory(String value) {
		this.value = value;
	}

	public static MemberCategory getCategory(String value) {
		switch (value) {
		case "销售商":
			return RETAILER;
		case "进货商":
			return SUPPLIER;
		default:
			return BOTH;
		}
	}

}
