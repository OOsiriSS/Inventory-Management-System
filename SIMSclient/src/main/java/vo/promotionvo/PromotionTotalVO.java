package vo.promotionvo;
/**
* 根据购买的商品总价，制定折让，赠品，赠送代金券
* @author Lijie
* @date 2017年12月11日
*/

import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.PromotionType;
import vo.commodityvo.GiftVO;

public class PromotionTotalVO extends PromotionVO {

	private Double total;
	private Double voucher;
	private ArrayList<GiftVO> gifts;

	public PromotionTotalVO(String id, LocalDate beginDate, LocalDate endDate, Double total, Double voucher,
			ArrayList<GiftVO> gifts) {
		super(id, beginDate, endDate, PromotionType.SUM_PROMOTION);
		this.setVoucher(voucher);
		this.setGifts(gifts);
		this.setTotal(total);
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public ArrayList<GiftVO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftVO> gifts) {
		this.gifts = gifts;
	}

}
