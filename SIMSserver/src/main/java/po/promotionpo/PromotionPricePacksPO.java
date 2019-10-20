package po.promotionpo;
/**
*  特价包
* @author 潘星宇
* @date 2017年12月27日
*/

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.PromotionType;
import po.commoditypo.GiftPO;

public class PromotionPricePacksPO extends PromotionPO {
	private static final long serialVersionUID = 5383295935262148394L;
	private ArrayList<GiftPO> pricePacks;
	private Double discount; // 特价包优惠前的总价

	public PromotionPricePacksPO(String id, LocalDate beginDate, LocalDate endDate, Double discount,
			ArrayList<GiftPO> pricePacks) {
		super(id, beginDate, endDate, PromotionType.PRICEPACKS);
		this.pricePacks = pricePacks;
		this.discount = discount;
	}

	public void setPricePacks(ArrayList<GiftPO> pricePacks) {
		this.pricePacks = pricePacks;
	}

	public ArrayList<GiftPO> getPricePacks() {
		return pricePacks;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDiscount() {
		return discount;
	}

}
