package bussinesslogic.salesbl;

import java.util.ArrayList;
import bussinesslogic.common.CommodityItemTran;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commoditypo.CommodityItemPO;
import po.commoditypo.GiftPO;
import po.salespo.SalesPO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.GiftVO;

/**
 * 用于PO与VO的相互转换
 */
public class SalesTransition {

	public static SalesPO VOtoPO(SalesVO vo) {
		String id = vo.getId();
		String retailer = vo.getRetailer(); // 销售商客户
		String retailerId = vo.getRetailerID();
		String saleMan = vo.getSaleMan(); // 业务员
		String operator = vo.getOperator(); // 操作员
		Warehouse warehouse = vo.getWarehouse();
		ArrayList<CommodityItemPO> commodity = CommodityItemTran.VOtoPO(vo.getCommodity());
		ArrayList<GiftPO> giftPOs = new ArrayList<>();
		for (GiftVO giftVO : vo.getGifts()) {
			GiftPO gift = new GiftPO(giftVO.getName(), giftVO.getNumber());
			giftPOs.add(gift);
		}
		double beforePrice = vo.getBeforePrice();
		double allowance = vo.getAllowance(); // 折让
		double voucher = vo.getVoucher(); // 使用代金券金额
		double afterPrice = vo.getAfterPrice();
		String remark = vo.getNote(); // 备注
		BillType type = vo.getType();
		BillState state = vo.getState();
		return new SalesPO(id, retailerId, retailer, saleMan, operator, warehouse, commodity, giftPOs, beforePrice,
				allowance, voucher, afterPrice, remark, type, state);
	}

	public static SalesVO POtoVO(SalesPO po) {
		String id = po.getId();
		String retailer = po.getClientName();
		String salesMan = po.getSaleMan();
		String operator = po.getOperator();
		Warehouse warehouse = po.getWarehouse();
		ArrayList<CommodityItemVO> commodity = CommodityItemTran.POtoVO(po.getCommodities());
		ArrayList<GiftVO> giftVOs = new ArrayList<>();
		if (po.getGifts() != null) {
			for (GiftPO giftPO : po.getGifts()) {
				GiftVO gift = new GiftVO(giftPO.getName(), giftPO.getNumber());
				giftVOs.add(gift);
			}
		}
		double beforePrice = po.getBeforePrice();
		double allowance = po.getAllowance(); // 折让
		double voucher = po.getVoucher(); // 使用代金券金额
		double afterPrice = po.getAfterPrice();
		String remark = po.getRemark(); // 备注
		BillType type = po.getType();
		BillState state = po.getState();
		return new SalesVO(id, retailer, salesMan, operator, warehouse, commodity, giftVOs, beforePrice, allowance,
				voucher, afterPrice, remark, state, type);
	}
}
