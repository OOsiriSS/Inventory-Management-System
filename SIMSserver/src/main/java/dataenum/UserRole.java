package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum UserRole {

	INVENTORY_MANAGER("库存管理人员"), PUR_SALE_MANAGER("进货销售人员"), FINANCIAL_MANAGER("财务人员"), GENERAL_MANAGER(
			"总经理"), USER_MANAGER("用户管理员");

	public final String value;

	UserRole(String value) {
		this.value = value;
	}

	public static UserRole getRole(String value) {
		switch (value) {
		case "库存管理人员":
			return UserRole.INVENTORY_MANAGER;
		case "进货销售人员":
			return UserRole.PUR_SALE_MANAGER;
		case "财务人员":
			return UserRole.FINANCIAL_MANAGER;
		case "总经理":
			return UserRole.GENERAL_MANAGER;
		case "用户管理员":
			return UserRole.USER_MANAGER;
		default:
			return UserRole.USER_MANAGER;
		}
	}
}
