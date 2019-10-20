package vo.accountvo;

/**
 *
 * @author 王灿灿
 * @version 2017-12-1
 */
public class AccountVO {

	private String id;// 银行卡号
	private String name;// 银行账户名称
	private Double money;// 账户余额

	public AccountVO(String id, String name, Double money) {
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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}