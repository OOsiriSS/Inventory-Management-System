package vo.membervo;

import dataenum.MemberCategory;
import dataenum.MemberLevel;

public class MemberVO {
	private String ID;
	@SuppressWarnings("unused")
	private String categoryStr;
	private MemberCategory category; // 客户分类：进货商和销售商
	private String levelString;
	private MemberLevel level; // 客户级别：五级，一级普通用户，五级VIP客户
	private String name; // 客户名字
	private String cellNumber; // 电话号码
	private String address;
	private String post; // 邮编
	private String email;
	private String receivableLimit; // 应收额度
	private String receivable; // 应收
	private String payable; // 应付
	private String saleMan; // 默认业务员

	/**
	 * @param category
	 * @param level
	 * @param name
	 * @param cellNumber
	 * @param address
	 * @param post
	 * @param email
	 * @param receivableLimit
	 * @param receivable
	 * @param payable
	 * @param saleMan
	 */
	public MemberVO(String ID, MemberCategory category, MemberLevel level, String name, String cellNumber,
			String address, String post, String email, String receivableLimit, String receivable, String payable,
			String saleMan) {
		setCategoryStr(category.value);
		levelString = level.value;
		this.ID = ID;
		this.category = category;
		this.level = level;
		this.name = name;
		this.cellNumber = cellNumber;
		this.address = address;
		this.post = post;
		this.email = email;
		this.receivableLimit = receivableLimit;
		this.receivable = receivable;
		this.payable = payable;
		this.saleMan = saleMan;

	}

	public String getID() {
		return ID;
	}

	public MemberCategory getCategory() {
		return category;
	}

	public MemberLevel getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = MemberLevel.getLevel(level);
		this.levelString = level;
	}

	public String getName() {
		return name;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getPost() {
		return post;
	}

	public String getEmail() {
		return email;
	}

	public String getReceivableLimit() {
		return receivableLimit;
	}

	public String getReceivable() {
		return receivable;
	}

	public String getPayable() {
		return payable;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public String getCategoryStr() {
		return category.value;
	}

	public String getLevelString() {
		return levelString;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}

	public void setCategoryStr(String categoryStr) {
		this.categoryStr = categoryStr;
	}

}
