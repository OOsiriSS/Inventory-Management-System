package dataenum.findtype;

public enum FindUserType {
	ID("ID"), NAME("用户名"), USERROLE("职务");

	public final String value;

	FindUserType(String value) {
		this.value = value;
	}

	public static FindUserType getType(String value) {
		switch (value) {
		case "ID":
			return ID;
		case "用户名":
			return NAME;
		default:
			return USERROLE;
		}
	}
}
