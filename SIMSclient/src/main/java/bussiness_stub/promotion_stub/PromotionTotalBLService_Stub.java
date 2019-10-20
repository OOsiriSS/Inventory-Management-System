package bussiness_stub.promotion_stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionTotalVO;

public class PromotionTotalBLService_Stub implements PromotionBLService<PromotionTotalVO> {

	@Override
	public ResultMessage insert(PromotionTotalVO vo) throws RemoteException {
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(PromotionTotalVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PromotionTotalVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionTotalVO> getPromotionList() throws RemoteException {
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
	public String getID() throws RemoteException {
		return "00005";
	}

	@Override
	public ArrayList<PromotionTotalVO> find(String info, FindPromotionType findType) throws RemoteException {
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

}
