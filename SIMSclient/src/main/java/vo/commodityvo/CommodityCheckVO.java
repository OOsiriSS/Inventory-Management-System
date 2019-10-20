package vo.commodityvo;

import java.time.LocalDate;
import dataenum.BillType;

public class CommodityCheckVO {

	private LocalDate date;
	private BillType type;
	private String typeString;
	private String name;
	private Integer number;
	private Double money;

	public CommodityCheckVO(LocalDate date, BillType type, String name, Integer number, Double money) {
		this.date = date;
		this.type = type;
		this.typeString = type.value;
		this.name = name;
		this.number = number;
		this.money = money;
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

	public String getName() {
		return name;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getMoney() {
		return money;
	}

}
