package data_stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPO;

public class PromotionDataService_Stub implements PromotionMemberDataService {

	@Override
	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		ArrayList<PromotionMemberPO> list = new ArrayList<>();
		LocalDate beginDate = LocalDate.of(2017, 12, 30);
		LocalDate endDate = LocalDate.of(2017, 12, 31);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO g = new GiftPO("100010", 100);
		gifts.add(g);
		PromotionMemberPO po = new PromotionMemberPO("10001", beginDate, endDate, MemberLevel.LEVEL3, 120.0, 60.00,
				gifts);
		list.add(po);
		return list;
	}

	@Override
	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException {
		ArrayList<PromotionMemberPO> list = new ArrayList<>();
		LocalDate beginDate = LocalDate.of(2017, 12, 30);
		LocalDate endDate = LocalDate.of(2017, 12, 31);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO g = new GiftPO("100010", 100);
		gifts.add(g);
		PromotionMemberPO po = new PromotionMemberPO("10001", beginDate, endDate, MemberLevel.LEVEL3, 120.0, 60.00,
				gifts);
		list.add(po);
		return list;
	}

}
