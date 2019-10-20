package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataservice.salesdataservice.SalesDataService;
import po.commoditypo.CommodityItemPO;
import po.commoditypo.GiftPO;
import po.salespo.SalesPO;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年10月22日
 */
public class SalesDataService_Stub implements SalesDataService {

	@Override
	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException {
		ArrayList<CommodityItemPO> commodities = new ArrayList<>();

		CommodityItemPO e = new CommodityItemPO("000001", "潘星宇", "单身汪", 100, 200, "汪汪");
		commodities.add(e);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO p = new GiftPO("王灿灿", 200);
		gifts.add(p);
		SalesPO po = new SalesPO("XSD-20180101-00001", "000002", "王灿灿(000002)(销售商)", "王灿灿", "刘钦", Warehouse.WAREHOUSE1,
				commodities, gifts, 2000, 200, 300, 1500, "大吉大利，晚上吃鸡", BillType.SALESBILL, BillState.DRAFT);
		ArrayList<SalesPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

	@Override
	public ResultMessage insertSale(SalesPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;

	}

	@Override
	public ResultMessage deleteSale(String ID) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;

	}

	@Override
	public ResultMessage updateSale(SalesPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;

	}

	@Override
	public ArrayList<SalesPO> showSale() throws RemoteException {
		ArrayList<CommodityItemPO> commodities = new ArrayList<>();

		CommodityItemPO e = new CommodityItemPO("000001", "潘星宇", "单身汪", 100, 200, "汪汪");
		commodities.add(e);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO p = new GiftPO("王灿灿", 200);
		gifts.add(p);
		SalesPO po = new SalesPO("XSD-20180101-00001", "000002", "王灿灿(000002)(销售商)", "王灿灿", "刘钦", Warehouse.WAREHOUSE1,
				commodities, gifts, 2000, 200, 300, 1500, "大吉大利，晚上吃鸡", BillType.SALESBILL, BillState.DRAFT);
		ArrayList<SalesPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return "XSTHD-20171225-00001";
	}

	@Override
	public String getSaleID() throws RemoteException {
		return "XSD-20171225-00002";
	}

}
