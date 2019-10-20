package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionPricePacksPO;
import rmi.RemoteHelper;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionPricePacksVO;

/**
 * 特价包促销策略
 * 
 * @author 潘星宇
 * @date 2017年12月27日
 */
public class PromotionSpecialBL implements PromotionBLService<PromotionPricePacksVO> {

	private PromotionSpecialDataService service;

	public PromotionSpecialBL() {
		service = RemoteHelper.getInstance().getSpecialPromotionDataService();
	}

	@Override
	public ResultMessage insert(PromotionPricePacksVO vo) throws RemoteException {
		return service.insertPromotion(voTopo(vo));
	}

	@Override
	public ResultMessage delete(PromotionPricePacksVO vo) throws RemoteException {
		return service.deleteSpecialPromotion(vo.getId());
	}

	@Override
	public ResultMessage update(PromotionPricePacksVO vo) throws RemoteException {
		return service.updatePromotion(voTopo(vo));
	}

	@Override
	public ArrayList<PromotionPricePacksVO> getPromotionList() throws RemoteException {
		ArrayList<PromotionPricePacksVO> promotionList = new ArrayList<>();
		for (PromotionPricePacksPO po : service.showSpecialPromotion())
			promotionList.add(poTovo(po));
		return promotionList;
	}

	@Override
	public String getID() throws RemoteException {
		ArrayList<PromotionPricePacksPO> promotionList = service.showSpecialPromotion();
		if (promotionList != null && promotionList.size() != 0) {
			String oldID = promotionList.get(promotionList.size() - 1).getId();
			int tmp = Integer.parseInt(oldID);
			tmp++;
			String newID = String.valueOf(tmp);
			while (newID.length() < oldID.length())
				newID = "0" + newID;
			return newID;
		} else
			return "200001";
	}

	@Override
	public ArrayList<PromotionPricePacksVO> find(String info, FindPromotionType findType) throws RemoteException {
		ArrayList<PromotionPricePacksVO> promotionList = new ArrayList<>();
		for (PromotionPricePacksPO po : service.findSpecialPromotion(info, findType))
			promotionList.add(poTovo(po));
		return promotionList;
	}

	public PromotionPricePacksPO voTopo(PromotionPricePacksVO vo) {
		ArrayList<GiftPO> gifts = new ArrayList<>();
		if (vo.getPricePacks() != null) {
			for (GiftVO gift : vo.getPricePacks())
				gifts.add(new GiftPO(gift.getName(), gift.getNumber()));
		} else
			gifts = null;
		PromotionPricePacksPO po = new PromotionPricePacksPO(vo.getId(), vo.getBeginDate(), vo.getEndDate(),
				vo.getDiscount(), gifts);
		return po;
	}

	public PromotionPricePacksVO poTovo(PromotionPricePacksPO po) {
		ArrayList<GiftVO> gifts = new ArrayList<>();
		if (po.getPricePacks() != null) {
			for (GiftPO gift : po.getPricePacks())
				gifts.add(new GiftVO(gift.getName(), gift.getNumber()));
		} else
			gifts = null;
		PromotionPricePacksVO vo = new PromotionPricePacksVO(po.getId(), po.getBeginDate(), po.getEndDate(),
				po.getDiscount(), gifts);
		return vo;
	}

}
