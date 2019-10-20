package bussiness_stub.promotion_stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionPricePacksVO;

public class PromotionSpecialBLService_Stub implements PromotionBLService<PromotionPricePacksVO> {

	@Override
	public ResultMessage insert(PromotionPricePacksVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PromotionPricePacksVO vo) throws RemoteException {
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage update(PromotionPricePacksVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionPricePacksVO> getPromotionList() throws RemoteException {
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
	public String getID() throws RemoteException {
		return "00002";
	}

	@Override
	public ArrayList<PromotionPricePacksVO> find(String info, FindPromotionType findType) throws RemoteException {
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

}
