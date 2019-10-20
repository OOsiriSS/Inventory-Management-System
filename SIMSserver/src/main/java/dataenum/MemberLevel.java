package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum MemberLevel {

	LEVEL1("一级"), LEVEL2("二级"), LEVEL3("三级"), LEVEL4("四级"), LEVEL5("五级");

	public final String value;

	MemberLevel(String value) {
		this.value = value;
	}
}
