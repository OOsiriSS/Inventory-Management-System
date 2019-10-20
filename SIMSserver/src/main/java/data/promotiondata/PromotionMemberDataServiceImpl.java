package data.promotiondata;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.MemberLevel;
import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPO;

public class PromotionMemberDataServiceImpl implements PromotionMemberDataService {

	private PromotionData<PromotionMemberPO> promotion;

	public static void main(String[] args) throws RemoteException {
		LocalDate beginDate = LocalDate.of(2017, 12, 30);
		LocalDate endDate = LocalDate.of(2017, 12, 31);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO g = new GiftPO("100010", 100);
		gifts.add(g);
		PromotionMemberPO po = new PromotionMemberPO("10001", beginDate, endDate, MemberLevel.LEVEL3, 120.0, 60.00,
				gifts);
		PromotionMemberDataServiceImpl p = new PromotionMemberDataServiceImpl();
		p.insertPromotion(po);
		System.out.println(p.showMemberPromotion().get(0).getId());
	}

	public PromotionMemberDataServiceImpl() {
		promotion = new PromotionData<>();
	}

	@Override
	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.delete(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.find(keyword, type);
	}

	@Override
	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException {
		ArrayList<PromotionMemberPO> result = new ArrayList<>();
		ArrayList<PromotionPO> list = promotion.show();
		for (PromotionPO po : list) {
			if (po.getType() == PromotionType.LEVEL_PROMOTION)
				result.add((PromotionMemberPO) po);
		}
		return result;
	}

}
