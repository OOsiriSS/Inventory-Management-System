package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionMemberPO;
import rmi.RemoteHelper;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;

/**
 * 会员促销策略
 *
 * @author 潘星宇
 * @date 2017年12月27日
 */
public class PromotionMemberBL implements PromotionBLService<PromotionMemberVO> {

	private PromotionMemberDataService service;

	public PromotionMemberBL() {
		service = RemoteHelper.getInstance().getMemberPromotionDataService();
	}

	@Override
	public ResultMessage insert(PromotionMemberVO vo) throws RemoteException {
		return service.insertPromotion(voTopo(vo));
	}

	@Override
	public ResultMessage delete(PromotionMemberVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.deleteMemberPromotion(vo.getId());
	}

	@Override
	public ResultMessage update(PromotionMemberVO vo) throws RemoteException {
		return service.updatePromotion(voTopo(vo));
	}

	@Override
	public ArrayList<PromotionMemberVO> getPromotionList() throws RemoteException {
		ArrayList<PromotionMemberVO> promotionList = new ArrayList<>();
		for (PromotionMemberPO po : service.showMemberPromotion())
			promotionList.add(poTovo(po));
		return promotionList;
	}

	@Override
	public String getID() throws RemoteException {
		ArrayList<PromotionMemberPO> promotionList = service.showMemberPromotion();
		if (promotionList != null && promotionList.size() != 0) {
			String oldID = promotionList.get(promotionList.size() - 1).getId();
			int tmp = Integer.parseInt(oldID);
			tmp++;
			String newID = String.valueOf(tmp);
			while (newID.length() < oldID.length())
				newID = "0" + newID;
			return newID;
		} else
			return "100001";
	}

	@Override
	public ArrayList<PromotionMemberVO> find(String info, FindPromotionType findType) throws RemoteException {
		ArrayList<PromotionMemberVO> promotionList = new ArrayList<>();
		for (PromotionMemberPO po : service.findMemberPromotion(info, findType))
			promotionList.add(poTovo(po));
		return promotionList;
	}

	public PromotionMemberPO voTopo(PromotionMemberVO vo) {
		ArrayList<GiftPO> gifts = new ArrayList<>();
		if (vo.getGifts() != null) {
			for (GiftVO gift : vo.getGifts())
				gifts.add(new GiftPO(gift.getName(), gift.getNumber()));
		} else
			gifts = null;
		PromotionMemberPO po = new PromotionMemberPO(vo.getId(), vo.getBeginDate(), vo.getEndDate(), vo.getLevel(),
				vo.getAllowance(), vo.getVoucher(), gifts);
		return po;
	}

	public PromotionMemberVO poTovo(PromotionMemberPO po) {
		ArrayList<GiftVO> gifts = new ArrayList<>();
		if (po.getGifts() != null) {
			for (GiftPO gift : po.getGifts())
				gifts.add(new GiftVO(gift.getName(), gift.getNumber()));
		} else
			gifts = null;
		PromotionMemberVO vo = new PromotionMemberVO(po.getId(), po.getBeginDate(), po.getEndDate(), po.getLevel(),
				po.getAllowance(), po.getVoucher(), gifts);
		return vo;
	}

}
