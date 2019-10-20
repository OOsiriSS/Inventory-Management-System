package po.commoditypo;

import java.io.Serializable;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ2ÈÕ
 */
public class CommodityItemPO implements Serializable {

	private static final long serialVersionUID = 8871761745550204005L;
	private String id;
	private String name;
	private String model;
	private int number;
	private double price;
	private double total;
	private String remark;

	public CommodityItemPO(String ID, String name, String model, int number, double price, String remark) {
		this.id = ID;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = number * price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}

	public double getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}

}
