package po.commoditypo;

import java.io.Serializable;

public class GiftPO implements Serializable {

	private static final long serialVersionUID = -4425342273211989528L;
	private String name;
	private Integer number;

	public GiftPO(String name, Integer number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
