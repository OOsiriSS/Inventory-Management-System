package vo.tablevo;

import java.time.LocalDate;

import dataenum.BillType;
import dataenum.Warehouse;
import javafx.scene.control.CheckBox;

public class BusinessHistoryScheduleVO {
	// 筛选条件
	private LocalDate date;// 时间
	private BillType type;
	private String typeString;
	private String customer;// 客户
	private String clerkID;// 业务员
	private Warehouse warehouse;
	private String warehouseString;// 仓库
	private CheckBox box;

	public BusinessHistoryScheduleVO(LocalDate d, BillType b, String cu, String cl, Warehouse w) {
		this.date = d;
		this.type = b;
		typeString = b.value;
		customer = cu;
		clerkID = cl;
		warehouse = w;
		warehouseString = w.value;
	}

	public LocalDate getDate() {
		return date;
	}

	public BillType getType() {
		return type;
	}

	public String getTypeString() {
		return typeString;
	}

	public String getCustomer() {
		return customer;
	}

	public String getClerkID() {
		return clerkID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public String getWarehouseString() {
		return warehouseString;
	}

	public CheckBox getBox() {
		return box;
	}

}
