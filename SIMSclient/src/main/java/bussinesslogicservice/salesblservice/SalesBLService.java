package bussinesslogicservice.salesblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;

/**
 *
 * @ClassName: SalesBLService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijie
 *
 */
public interface SalesBLService {

	public String getSaleID();

	public String getBackSaleID();

	public ResultMessage isLegal(CommodityItemVO item);

	public void delete(SalesVO info);

	public ResultMessage submit(SalesVO Info);

	public ResultMessage save(SalesVO Info);

	public ArrayList<SalesVO> show();

	public ArrayList<SalesVO> find(String info, FindSalesType type);

	public ArrayList<PromotionPricePacksVO> showPricePacks();

	public ArrayList<PromotionTotalVO> FindTotalPromotion();

	public ArrayList<PromotionMemberVO> FindMemberPromotion();

}
