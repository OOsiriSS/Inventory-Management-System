package po.accountbookpo;

import java.io.Serializable;
import java.util.ArrayList;

import po.accountpo.AccountPO;
import po.commoditypo.CommodityPO;
import po.memberpo.MemberPO;

public class AccountBookPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String date;
	private String clerkID;// 操作员ID
	private ArrayList<CommodityPO> commodityPOs;// 商品列表
	private ArrayList<MemberPO> memberPOs;// 客户列表
	private ArrayList<AccountPO> accountPOs;// 账户列表

	public AccountBookPO(String date, String clerkID, ArrayList<CommodityPO> commodityPOs,
			ArrayList<MemberPO> memberPOs, ArrayList<AccountPO> accountPOs) {
		this.date = date;
		this.clerkID = clerkID;
		this.commodityPOs = commodityPOs;
		this.memberPOs = memberPOs;
		this.accountPOs = accountPOs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public ArrayList<CommodityPO> getCommodityPOs() {
		return commodityPOs;
	}

	public void setCommodityPOs(ArrayList<CommodityPO> commodityPOs) {
		this.commodityPOs = commodityPOs;
	}

	public ArrayList<MemberPO> getMemberPOs() {
		return memberPOs;
	}

	public void setMemberPOs(ArrayList<MemberPO> memberPOs) {
		this.memberPOs = memberPOs;
	}

	public ArrayList<AccountPO> getAccountPOs() {
		return accountPOs;
	}

	public void setAccountPOs(ArrayList<AccountPO> accountPOs) {
		this.accountPOs = accountPOs;
	}
}
