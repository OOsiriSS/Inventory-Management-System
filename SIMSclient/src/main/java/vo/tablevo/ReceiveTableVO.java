package vo.tablevo;

import java.time.LocalDate;

import dataenum.MoneyType;

public class ReceiveTableVO {

	private LocalDate date;
	private MoneyType type;
	private String typeString;
	private Double allowance;
	private Double sum;

	public ReceiveTableVO(LocalDate d, MoneyType t, Double a, Double s) {
		date = d;
		type = t;
		typeString = t.value;
		allowance = a;
		sum = s;
	}

	public LocalDate getDate() {
		return date;
	}

	public MoneyType getType() {
		return type;
	}

	public Double getAllowance() {
		return allowance;
	}

	public Double getSum() {
		return sum;
	}

	public String getTypeString() {
		return typeString;
	}

}
