package dataenum.findtype;

/**
 *
 * @author Lijie
 * @date 2017年12月2日
 */
public enum FindCommodityType {

	ID("ID"), NAME("商品名称"), MODEL("型号"), CLASSIFICATION("分类"), NUMBER("库存数量"), PURPRICE("进价"), RETAILEDPRICE(
			"零售价"), RECENTPURPRICE("最近进价"), RECENTRETAILEDPRICE("最近零售价"), WARMINGVALUE("警戒值");

	public final String value;

	FindCommodityType(String value) {
		this.value = value;
	}

	public static FindCommodityType getType(String value) {
		switch (value) {
		case "ID":
			return ID;
		case "商品名称":
			return NAME;
		case "型号":
			return MODEL;
		case "分类":
			return CLASSIFICATION;
		case "库存数量":
			return NUMBER;
		case "进价":
			return PURPRICE;
		case "零售价":
			return RETAILEDPRICE;
		case "最近进价":
			return RECENTPURPRICE;
		case "最近零售价":
			return RECENTRETAILEDPRICE;
		default:
			return WARMINGVALUE;
		}
	}
}
