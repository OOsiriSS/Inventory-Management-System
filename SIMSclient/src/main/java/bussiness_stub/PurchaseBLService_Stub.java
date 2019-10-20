package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

public class PurchaseBLService_Stub implements PurchaseBLService {

	@Override
	public String getPurchaseID() {
		// TODO Auto-generated method stub
		return "JHD-20171214-00001";
	}

	@Override
	public ArrayList<PurchaseVO> show() {
		ArrayList<PurchaseVO> list = new ArrayList<>();
		ArrayList<CommodityItemVO> commodities = new ArrayList<>();
		CommodityItemVO commodity = new CommodityItemVO("001", "°×³ãµÆ", "L", 89, 45.00, "cnjwdfcj");
		commodities.add(commodity);
		PurchaseVO purchase1 = new PurchaseVO("0001", "Àî½Ü", Warehouse.WAREHOUSE1, "Panxy", commodities, "ncibwcfhbwvhu",
				45.00, BillType.PURCHASEBILL, BillState.COMMITED);
		PurchaseVO puchase2 = new PurchaseVO("0001", "Àî½Ü", Warehouse.WAREHOUSE1, "Panxy", commodities, "ncibwcfhbwvhu",
				45.00, BillType.PURCHASEBILL, BillState.DRAFT);
		list.add(purchase1);
		list.add(puchase2);
		return list;
	}

	@Override
	public ResultMessage submit(PurchaseVO Info) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage save(PurchaseVO Info) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage isLegal(CommodityItemVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getPurChaseBackID() {
		// TODO Auto-generated method stub
		return "JHTHD-20171214-00002";
	}

	@Override
	public void delete(PurchaseVO info) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PurchaseVO> find(String info, FindSalesType type) {
		ArrayList<PurchaseVO> list = new ArrayList<>();
		ArrayList<CommodityItemVO> commodities = new ArrayList<>();
		CommodityItemVO commodity = new CommodityItemVO("001", "°×³ãµÆ", "L", 89, 45.00, "cnjwdfcj");
		commodities.add(commodity);
		PurchaseVO purchase1 = new PurchaseVO("0001", "Àî½Ü", Warehouse.WAREHOUSE1, "Panxy", commodities, "ncibwcfhbwvhu",
				45.00, BillType.PURCHASEBILL, BillState.COMMITED);
		PurchaseVO puchase2 = new PurchaseVO("0001", "Àî½Ü", Warehouse.WAREHOUSE1, "Panxy", commodities, "ncibwcfhbwvhu",
				45.00, BillType.PURCHASEBILL, BillState.DRAFT);
		list.add(purchase1);
		list.add(puchase2);

		ArrayList<PurchaseVO> result = new ArrayList<>();
		for (PurchaseVO vo : list) {
			switch (type) {
			case ID:
				if (info.equals(vo.getId()))
					result.add(vo);
				break;
			case TOTAL:
				if (Double.valueOf(info) == vo.getSum())
					result.add(vo);
				break;

			default:
				break;
			}
		}
		return result;
	}

}
