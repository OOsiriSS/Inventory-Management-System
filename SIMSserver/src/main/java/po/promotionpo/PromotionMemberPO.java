package po.promotionpo;
/**
*
* @author ≈À–«”Ó
* @date 2017ƒÍ12‘¬27»’
*/

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.MemberLevel;
import dataenum.PromotionType;
import po.commoditypo.GiftPO;

public class PromotionMemberPO extends PromotionPO implements Serializable {

	private static final long serialVersionUID = 7539070862489685774L;
	private MemberLevel level;
	private String levelString;
	private Double allowance;
	private Double voucher;
	private ArrayList<GiftPO> gifts;

	public PromotionMemberPO(String id, LocalDate beginDate, LocalDate endDate, MemberLevel level, Double allowance,
			Double voucher, ArrayList<GiftPO> gifts) {
		super(id, beginDate, endDate, PromotionType.LEVEL_PROMOTION);
		this.level = level;
		levelString = level.value;
		this.allowance = allowance;
		this.voucher = voucher;
		this.gifts = gifts;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Double getAllowance() {
		return allowance;
	}

	public MemberLevel getLevel() {
		return level;
	}

	public String getLevelString() {
		return levelString;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	}

	public ArrayList<GiftPO> getGifts() {
		return gifts;
	}

}
