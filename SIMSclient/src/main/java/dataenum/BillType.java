package dataenum;

public enum BillType {

	INVENTORYGIFTBILL("库存赠送单", "KCZSD"), INVENTORYLOSSBILL("库存报损单", "KCBSD"), INVENTORYREVENUEBILL("库存报溢单",
			"KCBYD"), INVENTORYWARNINGBILL("库存报警单", "KCBJD"), INVENTORYBILL("库存单", "KCD"), SALESBILL("销售单",
					"XSD"), PURCHASEBILL("进货单", "JHD"), SALESBACKBILL("销售退货单",
							"XSTHD"), PURCHASEBACKBILL("进货退货单", "JHTHD"), SKD("收款单", "SKD"), XJFYD("付款单", "XJFYD");

	public final String value;
	public final String prefix;

	BillType(String value, String prefix) {
		this.value = value;
		this.prefix = prefix;
	}

	public static BillType getType(String value) {
		switch (value) {
		case "库存赠送单":
			return BillType.INVENTORYGIFTBILL;
		case "库存报损单":
			return BillType.INVENTORYLOSSBILL;
		case "库存报溢单":
			return BillType.INVENTORYREVENUEBILL;
		case "库存报警单":
			return BillType.INVENTORYWARNINGBILL;
		case "库存单":
			return BillType.INVENTORYBILL;
		case "销售单":
			return BillType.SALESBILL;
		case "进货单":
			return BillType.PURCHASEBILL;
		case "销售退货单":
			return BillType.SALESBACKBILL;
		case "进货退货单":
			return BillType.PURCHASEBACKBILL;
		case "收款单":
			return BillType.SKD;
		case "付款单":
			return BillType.XJFYD;
		default:
			return BillType.XJFYD;
		}
	}
}
