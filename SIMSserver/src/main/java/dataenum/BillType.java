package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017年12月2日
 */
public enum BillType {

	INVENTORYGIFTBILL("库存赠送单", "KCZSD"), INVENTORYLOSSBILL("库存报损单", "KCBSD"), INVENTORYREVENUEBILL("库存报溢单",
			"KCBYD"), INVENTORYWARNINGBILL("库存报警单", "KCBJD"), SALESBILL("销售单", "XSD"), PURCHASEBILL("进货单",
					"JHD"), SALESBACKBILL("销售退货单",
							"XSTHD"), PURCHASEBACKBILL("进货退货单", "JHTHD"), SKD("收款单", "SKD"), XJFYD("付款单", "FKD");

	public final String value;
	public final String prefix;

	BillType(String value, String prefix) {
		this.value = value;
		this.prefix = prefix;
	}
}
