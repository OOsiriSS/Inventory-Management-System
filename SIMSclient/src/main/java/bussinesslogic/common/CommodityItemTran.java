package bussinesslogic.common;
/**
* 用于purcahse与sale里面的商品项转换
* @author Lijie
* @date 2017年12月1日
*/

import java.util.ArrayList;

import po.commoditypo.CommodityItemPO;
import vo.commodityvo.CommodityItemVO;

public class CommodityItemTran {

	public static ArrayList<CommodityItemPO> VOtoPO(ArrayList<CommodityItemVO> vo) {
		ArrayList<CommodityItemPO> itemPO = new ArrayList<>();
		for (CommodityItemVO c : vo) {
			CommodityItemPO po = new CommodityItemPO(c.getId(), c.getName(), c.getModel(), c.getNumber(), c.getPrice(),
					c.getRemark());
			itemPO.add(po);
		}
		return itemPO;
	}

	public static ArrayList<CommodityItemVO> POtoVO(ArrayList<CommodityItemPO> po) {
		ArrayList<CommodityItemVO> itemVO = new ArrayList<>();
		for (CommodityItemPO c : po) {
			CommodityItemVO vo = new CommodityItemVO(c.getId(), c.getName(), c.getModel(), c.getNumber(), c.getPrice(),
					c.getRemark());
			itemVO.add(vo);
		}
		return itemVO;
	}
}
