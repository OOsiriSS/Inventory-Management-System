package bussinesslogic.purchasebl;

import java.util.ArrayList;

import bussinesslogic.common.CommodityItemTran;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commoditypo.CommodityItemPO;
import po.purchasepo.PurchasePO;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

/**
 * 用于PO与VO的互相转换
 * 
 * @author Lijie
 * @date 2017年12月1日
 */
public class PurchaseTransition {

	public static PurchasePO VOtoPO(PurchaseVO vo) {
		ArrayList<CommodityItemPO> commodities = CommodityItemTran.VOtoPO(vo.getCommodities());
		String id = vo.getId();
		String memberID = vo.getSupplier();
		String member = vo.getSupplier();
		Warehouse warehouse = vo.getWarehouse();
		String operator = vo.getOperator();
		String remark = vo.getNote();
		Double sum = vo.getSum();
		BillType type = vo.getType();
		BillState state = vo.getState();
		PurchasePO po = new PurchasePO(id, memberID, member, warehouse, operator, commodities, remark, sum, type,
				state);
		return po;
	}

	public static PurchaseVO POtoVO(PurchasePO po) {
		ArrayList<CommodityItemVO> commodities = CommodityItemTran.POtoVO(po.getCommodities());
		String id = po.getId();
		String supplier = po.getMember();
		Warehouse warehouse = po.getWarehouse();
		String operator = po.getOperator();
		String note = po.getRemark();
		Double sum = po.getSum();
		BillType type = po.getType();
		BillState state = po.getState();
		PurchaseVO vo = new PurchaseVO(id, supplier, warehouse, operator, commodities, note, sum, type, state);
		return vo;
	}

}
