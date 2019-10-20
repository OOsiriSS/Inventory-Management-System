package dataenum.findtype;

/**
 * 
 * @author Lijie
 * @date 2017年12月3日
 */
public enum FindAccountType {

	ID("账户ID"), NAME("账户名称"), MONEY("账户金额");

	public final String value;

	FindAccountType(String value) {
		this.value = value;
	}
}
