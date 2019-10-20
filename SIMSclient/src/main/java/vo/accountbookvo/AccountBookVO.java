package vo.accountbookvo;

import java.util.ArrayList;

import vo.accountvo.AccountVO;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;

public class AccountBookVO {
	private String date;
	private String clerkID;// 操作员ID
	private ArrayList<CommodityVO> commodityVOs;// 商品列表
	private ArrayList<MemberVO> memberVOs;// 客户列表
	private ArrayList<AccountVO> accountVOs;// 账户列表

	public AccountBookVO(String date, String clerkID, ArrayList<CommodityVO> commodityVOs,
			ArrayList<MemberVO> memberVOs, ArrayList<AccountVO> accountVOs) {
		this.date = date;
		this.clerkID = clerkID;
		this.commodityVOs = commodityVOs;
		this.memberVOs = memberVOs;
		this.accountVOs = accountVOs;
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

	public ArrayList<CommodityVO> getCommodityVOs() {
		return commodityVOs;
	}

	public void setCommodityVOs(ArrayList<CommodityVO> commodityVOs) {
		this.commodityVOs = commodityVOs;
	}

	public ArrayList<MemberVO> getMemeberVOs() {
		return memberVOs;
	}

	public void setMemeberVOs(ArrayList<MemberVO> memberVOs) {
		this.memberVOs = memberVOs;
	}

	public ArrayList<AccountVO> getAccountVOs() {
		return accountVOs;
	}

	public void setAccountVOs(ArrayList<AccountVO> accountVOs) {
		this.accountVOs = accountVOs;
	}

}
