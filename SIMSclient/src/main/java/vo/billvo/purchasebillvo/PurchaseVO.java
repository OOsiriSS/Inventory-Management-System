package vo.billvo.purchasebillvo;

import java.util.ArrayList;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.billvo.BillVO;
import vo.commodityvo.CommodityItemVO;

public class PurchaseVO extends BillVO {

	private String supplier; // 供应商
	private Warehouse warehouse;
	@SuppressWarnings("unused")
	private String warehouseString;
	private String operator;
	private ArrayList<CommodityItemVO> commodities; // 入库商品列表
	private Double sum;

	public PurchaseVO(String id, String supplier, Warehouse warehouse, String operator,
			ArrayList<CommodityItemVO> commodities, String note, Double sum, BillType type, BillState state) {
		super(id, type, state, note);
		this.supplier = supplier;
		this.warehouse = warehouse;
		this.operator = operator;
		this.commodities = commodities;
		this.sum = sum;
		setWarehouseString(warehouse.value);
	}

	public String getSupplier() {
		return supplier;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public String getWarehouseString() {
		return warehouse.value;
	}

	public String getOperator() {
		return operator;
	}

	public ArrayList<CommodityItemVO> getCommodities() {
		return commodities;
	}

	public void setCommodities(ArrayList<CommodityItemVO> commodities) {
		this.commodities = commodities;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;

	}

	public void setWarehouseString(String warehouseString) {
		this.warehouseString = warehouseString;
	}

}
