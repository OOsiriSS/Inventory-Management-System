package bussiness_stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.salesblservice.Sale_PromotionInfo;
import dataenum.MemberLevel;
import vo.billvo.salesbillvo.SalesPriceVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
import vo.promotionvo.PromotionVO;

public class Sale_PromotionInfo_Stub implements Sale_PromotionInfo {

	@Override
	public ArrayList<PromotionMemberVO> findMemberPromotion(String memberID) throws RemoteException {
		ArrayList<PromotionMemberVO> list = new ArrayList<>();
		ArrayList<GiftVO> gifts = new ArrayList<>();
		GiftVO g1 = new GiftVO("À¶µÆ", 100);
		GiftVO g2 = new GiftVO("ÂÌµÆ", 60);
		GiftVO g3 = new GiftVO("°×µÆ", 120);
		gifts.add(g1);
		gifts.add(g2);
		PromotionMemberVO m1 = new PromotionMemberVO("00001", LocalDate.of(2017, 11, 25), LocalDate.of(2017, 12, 05),
				MemberLevel.LEVEL3, 300.0, 125.0, gifts);
		list.add(m1);
		ArrayList<GiftVO> gifts1 = new ArrayList<>();
		gifts1.add(g3);
		gifts1.add(g2);
		PromotionMemberVO m2 = new PromotionMemberVO("00002", LocalDate.of(2017, 11, 30), LocalDate.of(2017, 12, 12),
				MemberLevel.LEVEL2, 500.0, 250.0, gifts1);
		list.add(m2);
		return list;

	}

	@Override
	public ArrayList<PromotionTotalVO> findTotalPromotion(double beforePrice) throws RemoteException {
		ArrayList<PromotionTotalVO> list = new ArrayList<>();
		ArrayList<GiftVO> gifts = new ArrayList<>();
		ArrayList<GiftVO> gifts1 = new ArrayList<>();
		GiftVO g1 = new GiftVO("¹í´µµÆ", 100);
		GiftVO g2 = new GiftVO("¿×Ã÷µÆ", 60);
		GiftVO g3 = new GiftVO("¹þµÇ", 120);
		gifts.add(g1);
		gifts.add(g2);
		gifts1.add(g3);
		gifts1.add(g2);
		PromotionTotalVO t1 = new PromotionTotalVO("00007", LocalDate.of(2017, 11, 30), LocalDate.of(2017, 12, 12),
				500.0, 250.0, gifts1);
		PromotionTotalVO t2 = new PromotionTotalVO("00008", LocalDate.of(2017, 12, 30), LocalDate.of(2018, 12, 12),
				1200.0, 350.0, gifts);
		list.add(t1);
		list.add(t2);
		return list;
	}

	@Override
	public ArrayList<PromotionPricePacksVO> findPricePacksPromotion(ArrayList<CommodityItemVO> commodity)
			throws RemoteException {
		ArrayList<PromotionPricePacksVO> list = new ArrayList<>();
		ArrayList<GiftVO> pricePacks = new ArrayList<>();
		GiftVO g1 = new GiftVO("¹í´µµÆ", 100);
		GiftVO g2 = new GiftVO("¿×Ã÷µÆ", 60);
		GiftVO g3 = new GiftVO("¹þµÇ", 120);
		pricePacks.add(g1);
		pricePacks.add(g2);
		ArrayList<GiftVO> pricePacks1 = new ArrayList<>();
		pricePacks1.add(g3);
		pricePacks1.add(g2);

		PromotionPricePacksVO p1 = new PromotionPricePacksVO("00002", LocalDate.of(2017, 11, 30),
				LocalDate.of(2017, 12, 15), 200.0, pricePacks);
		PromotionPricePacksVO p2 = new PromotionPricePacksVO("00003", LocalDate.of(2017, 12, 05),
				LocalDate.of(2017, 12, 25), 500.0, pricePacks1);
		list.add(p2);
		list.add(p1);
		return list;

	}

	@Override
	public SalesPriceVO getPromotionPrice(ArrayList<PromotionVO> promotionList) {
		return new SalesPriceVO(300.0, 500.0, null);
	}

}
