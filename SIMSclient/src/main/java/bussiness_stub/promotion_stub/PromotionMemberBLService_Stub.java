package bussiness_stub.promotion_stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;

public class PromotionMemberBLService_Stub implements PromotionBLService<PromotionMemberVO> {

	@Override
	public ResultMessage insert(PromotionMemberVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PromotionMemberVO vo) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PromotionMemberVO vo) throws RemoteException {
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PromotionMemberVO> getPromotionList() throws RemoteException {
		ArrayList<PromotionMemberVO> list = new ArrayList<>();
		ArrayList<GiftVO> gifts = new ArrayList<>();
		GiftVO g1 = new GiftVO("¹í´µµÆ", 100);
		GiftVO g2 = new GiftVO("¿×Ã÷µÆ", 60);
		GiftVO g3 = new GiftVO("¹þµÇ", 120);
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
	public String getID() throws RemoteException {
		return "00001";
	}

	@Override
	public ArrayList<PromotionMemberVO> find(String info, FindPromotionType findType) throws RemoteException {
		ArrayList<PromotionMemberVO> list = new ArrayList<>();
		ArrayList<GiftVO> gifts = new ArrayList<>();
		GiftVO g1 = new GiftVO("¹í´µµÆ", 100);
		GiftVO g2 = new GiftVO("¿×Ã÷µÆ", 60);
		GiftVO g3 = new GiftVO("¹þµÇ", 120);
		gifts.add(g1);
		gifts.add(g2);
		PromotionMemberVO m1 = new PromotionMemberVO("00001", LocalDate.of(2017, 11, 25), LocalDate.of(2017, 12, 05),
				MemberLevel.LEVEL3, 300.0, 125.0, gifts);
		list.add(m1);
		return list;
	}

}
