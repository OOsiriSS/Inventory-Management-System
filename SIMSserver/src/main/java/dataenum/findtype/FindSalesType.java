package dataenum.findtype;

/**
 * 
 * @author Lijie
 * @date 2017年12月9日
 */
public enum FindSalesType {

	ID("单据编号"), MEMBER("客户"), OPERATOR("操作员"), SALEMAN("业务员"), TOTAL("总额");

	public final String value;

	FindSalesType(String value) {
		this.value = value;
	}
}
