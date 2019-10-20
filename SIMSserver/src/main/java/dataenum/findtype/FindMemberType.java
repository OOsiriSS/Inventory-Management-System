package dataenum.findtype;

/**
 * 模糊查找用户的类型
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum FindMemberType {

	ID("客户ID"), KIND("客户类别"), LEVEL("客户级别"), NAME("客户姓名"), PHONE("客户电话"), ADDRESS("客户地址"), POST("客户邮编"), EMAIL(
			"客户邮箱"), RECEIVABLELIMIT("应收额度"), RECEIVABLE("应收"), PAYABLE("应付"), SALESMAN("默认业务员");

	public final String value;

	FindMemberType(String value) {
		this.value = value;
	}
}
