package vo.commodityvo;

public class CommodityItemVO {

	private String id;
	private String name;
	private String model;
	private Integer number;
	private Double price;
	private Double total;
	private String remark;

	public CommodityItemVO(String ID, String name, String model, Integer number, Double price, String remark) {
		this.id = ID;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = price * number;
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

	public Integer getNumber() {
		return number;
	}

	public Double getPrice() {
		return price;
	}

	public Double getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
