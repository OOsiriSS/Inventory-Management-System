package dataenum;

public enum MemberLevel {

	LEVEL1("一级", 1), LEVEL2("二级", 2), LEVEL3("三级", 3), LEVEL4("四级", 4), LEVEL5("五级", 5);

	public final String value;
	public final int num;

	MemberLevel(String value, int num) {
		this.value = value;
		this.num = num;
	}

	public static MemberLevel getLevel(String value) {
		switch (value) {
		case "一级":
			return LEVEL1;
		case "二级":
			return LEVEL2;
		case "三级":
			return LEVEL3;
		case "四级":
			return LEVEL4;
		default:
			return LEVEL5;
		}
	}
}