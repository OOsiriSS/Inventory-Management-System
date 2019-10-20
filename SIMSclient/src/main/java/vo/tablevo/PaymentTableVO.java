package vo.tablevo;

import java.time.LocalDate;

import dataenum.MoneyType;

public class PaymentTableVO {

	private LocalDate date;
	private MoneyType type;
	private String typeString;
	private Double sum;

	public PaymentTableVO(LocalDate d, MoneyType t, Double s) {
		date = d;
		type = t;
		typeString = t.value;
		sum = s;
	}

	public LocalDate getDate() {
		return date;
	}

	public MoneyType getType() {
		return type;
	}

	public Double getSum() {
		return sum;
	}

	public String getTypeString() {
		return typeString;
	}

}
