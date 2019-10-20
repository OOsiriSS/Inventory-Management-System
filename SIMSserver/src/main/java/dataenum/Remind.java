package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum Remind {

	USER("用户"), MEMBER("客户"), ACCOUNT("账户"), TABLE("表格"), BILL("单据"), COMMODITY("商品"), CLASSIFICATION("分类"), PROMOTION(
			"策略");

	public final String value;

	Remind(String value) {
		this.value = value;
	}
}
