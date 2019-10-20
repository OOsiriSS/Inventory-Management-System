package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum MemberCategory {

	RETAILER("销售商"), SUPPLIER("进货商"), BOTH("进货商&销售商");

	public final String value;

	MemberCategory(String value) {
		this.value = value;
	}

}
