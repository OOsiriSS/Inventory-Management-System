package dataenum.findtype;

/**
 *
 * @author Lijie
 * @date 2017年12月3日
 */
public enum FindAccountType {

	ID("账户ID"), NAME("账户名称");

	public final String value;

	FindAccountType(String value) {
		this.value = value;
	}

	public static FindAccountType getFindType(String value) {
		switch (value) {
		case "账户ID":
			return FindAccountType.ID;
		case "账户名称":
			return FindAccountType.NAME;
		default:
			return FindAccountType.NAME;
		}
	}
}
