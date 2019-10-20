package po.accountpo;

import java.io.Serializable;

public class AccountPO implements Serializable {

	private static final long serialVersionUID = -8799405240174423193L;
	private String id;
	private String name;
	private double money;

	public AccountPO(String id, String name, double money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}