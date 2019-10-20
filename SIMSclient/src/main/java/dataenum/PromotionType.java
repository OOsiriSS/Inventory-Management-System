package dataenum;

/**
 *
 * @author Lijie
 * @date 2017年12月3日
 */
public enum PromotionType {

	LEVEL_PROMOTION("等级促销"), PRICEPACKS("特价包"), SUM_PROMOTION("总价促销");

	public final String value;

	PromotionType(String value) {
		this.value = value;
	}

	public static PromotionType getType(String value) {
		switch (value) {
		case "等级促销":
			return LEVEL_PROMOTION;
		case "特价包":
			return PRICEPACKS;
		default:
			return SUM_PROMOTION;
		}
	}
}
