package data.promotiondata;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionSumDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionPO;
import po.promotionpo.PromotionTotalPO;

public class PromotionSumDataServiceImpl implements PromotionSumDataService {

	private PromotionData<PromotionTotalPO> promotion;

	public PromotionSumDataServiceImpl() {
		promotion = new PromotionData<>();
	}

	public static void main(String[] args) throws RemoteException {
		LocalDate beginDate = LocalDate.of(2016, 12, 20);
		LocalDate endDate = LocalDate.of(2017, 12, 31);
		GiftPO g = new GiftPO("100010", 100);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		gifts.add(g);
		PromotionTotalPO po = new PromotionTotalPO("100001", beginDate, endDate, 100.0, 200.0, gifts);
		PromotionSumDataServiceImpl p = new PromotionSumDataServiceImpl();
		p.insertPromotion(po);
		System.out.println(p.showSumPromotion().get(0).getId());
	}

	@Override
	public ResultMessage insertPromotion(PromotionTotalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deleteSumPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.delete(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionTotalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionTotalPO> findSumPromotion(String keyword, FindPromotionType type) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.find(keyword, type);
	}

	@Override
	public ArrayList<PromotionTotalPO> showSumPromotion() throws RemoteException {
		ArrayList<PromotionTotalPO> result = new ArrayList<>();
		ArrayList<PromotionPO> list = promotion.show();
		for (PromotionPO po : list) {
			if (po.getType() == PromotionType.SUM_PROMOTION)
				result.add((PromotionTotalPO) po);
		}
		return result;
	}

}
