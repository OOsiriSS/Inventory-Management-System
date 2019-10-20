package vo.tablevo;

import java.time.LocalDate;

public class SaleScheduleVO {

	private LocalDate date;// 时间
	private String name;// 商品名
	private String model;// 型号
	private Integer number;// 数量
	private Double price;// 单价
	private Double sum;

	public SaleScheduleVO(LocalDate d, String name, String m, Integer n, double p) {
		this.date = d;
		this.name = name;
		model = m;
		this.number = n;
		price = p;
		sum = n * p;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}
