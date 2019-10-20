package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.billvo.salesbillvo.SalesPriceVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
import vo.promotionvo.PromotionVO;

/**
 *
 * @author Lijie
 * @date 2017年12月11日
 */
public interface Sale_PromotionInfo {

	public ArrayList<PromotionMemberVO> findMemberPromotion(String memberID) throws RemoteException;

	public ArrayList<PromotionTotalVO> findTotalPromotion(double beforePrice) throws RemoteException;

	public ArrayList<PromotionPricePacksVO> findPricePacksPromotion(ArrayList<CommodityItemVO> commodity)
			throws RemoteException;

	// public PromotionPricePacksVO findPricePacks(String id) throws
	// RemoteException;

	public SalesPriceVO getPromotionPrice(ArrayList<PromotionVO> promotionList);// 根据促销策略，返回代金券和价格折让

	// public ArrayList<CommodityItemPO> getGifts(String ID) throws
	// RemoteException;

}