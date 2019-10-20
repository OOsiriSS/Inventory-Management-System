package dataenum.findtype;

/**
 *
 * @author Lijie
 * @date 2017年12月9日
 */
public enum FindPromotionType {

	ID("促销编号"), TIMEINTERVAL("时间区间"), TYPE("促销类型");

	public final String value;

	private FindPromotionType(String value) {
		this.value = value;
	}

	public static FindPromotionType getType(String value) {
		switch (value) {
		case "促销编号":
			return ID;
		case "时间区间":
			return TIMEINTERVAL;
		default:
			return TYPE;
		}
	}

}
