package data.promotiondata;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionPO;
import po.promotionpo.PromotionPricePacksPO;

public class PromotionSpecialDataServiceImpl implements PromotionSpecialDataService {

	private PromotionData<PromotionPricePacksPO> promotion;

	public PromotionSpecialDataServiceImpl() {
		promotion = new PromotionData<>();
	}

	public static void main(String[] args) throws RemoteException {
		PromotionSpecialDataServiceImpl p = new PromotionSpecialDataServiceImpl();
		LocalDate beginDate = LocalDate.of(2016, 12, 31);
		LocalDate endDate = LocalDate.of(2017, 12, 31);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO g = new GiftPO("100010", 100);
		gifts.add(g);
		PromotionPricePacksPO po = new PromotionPricePacksPO("100013", beginDate, endDate, 100.0, gifts);
		p.insertPromotion(po);
		System.out.println(p.showSpecialPromotion().get(0).getId());
	}

	@Override
	public ResultMessage insertPromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deleteSpecialPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.delete(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionPricePacksPO> findSpecialPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.find(keyword, type);
	}

	@Override
	public ArrayList<PromotionPricePacksPO> showSpecialPromotion() throws RemoteException {
		ArrayList<PromotionPricePacksPO> result = new ArrayList<>();
		ArrayList<PromotionPO> list = promotion.show();
		for (PromotionPO po : list) {
			if (po.getType() == PromotionType.PRICEPACKS)
				result.add((PromotionPricePacksPO) po);
		}
		return result;
	}

}
