package bussinesslogic.commoditybl;
/**     
*  VO与PO的转换
* @author Lijie 
* @date 2017年12月18日    
*/

import po.commoditypo.CommodityPO;
import vo.commodityvo.CommodityVO;

public class CommodityTransiton {

	public CommodityPO VOtoPO(CommodityVO vo) {
		String id = vo.getID();
		String name = vo.getName();
		String model = vo.getModel();
		int number = vo.getNumber();
		double purPrice = vo.getPurPrice();
		double retailedPrice = vo.getRetailedPrice();
		int warmingValue = vo.getWarmingValue();
		String classification = vo.getClassification();
		double recentRetailedPrice = vo.getRecentRetailedPrice();
		double recentPurPrice = vo.getRecentPurPrice();
		CommodityPO po = new CommodityPO(id, name, model, classification, number, purPrice, retailedPrice,
				recentPurPrice, recentRetailedPrice, warmingValue);
		return po;
	}

	public CommodityVO POtoVO(CommodityPO po) {
		String id = po.getID();
		String name = po.getName();
		String model = po.getModel();
		int number = po.getNumber();
		double purPrice = po.getPurPrice();
		double retailedPrice = po.getRetailedPrice();
		int warmingValue = po.getWarmingValue();
		String classification = po.getClassification();
		double recentRetailedPrice = po.getRecentRetailedPrice();
		double recentPurPrice = po.getRecentPurPrice();

		CommodityVO vo = new CommodityVO(id, name, model, classification, number, purPrice, retailedPrice,
				warmingValue);
		vo.setRecentPurPrice(recentPurPrice);
		vo.setRecentRetailedPrice(recentRetailedPrice);
		return vo;
	}
}
