package dataenum.findtype;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum FindCommodityType {

	ID("商品ID"), NAME("商品名称"), MODEL("商品分类"), CLASSIFICATION("商品分类"), NUMBER("商品数量"), PURPRICE("进价"), RETAILEDPRICE(
			"零售价"), RECENTPURPRICE("最近进价"), RECENTRETAILEDPRICE("最近零售价");

	public final String value;

	private FindCommodityType(String value) {
		this.value = value;
	}
}
