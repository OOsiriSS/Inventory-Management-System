package bussinesslogic.commoditybl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.classificationbl.ClassificationController;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.classificationdataservice.ClassificationDataService;
import dataservice.commoditydataservice.CommodityDataService;
import javafx.util.converter.LocalDateStringConverter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import po.classificationvpo.ClassificationVPO;
import po.commoditypo.CommodityPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;
import vo.commodityvo.GiftVO;

/**
 *
 * @ClassName: CommodityController
 * @author lijie
 * @date 2017年12月16日 修改：王灿灿
 *
 */

public class CommodityBL implements CommodityBLService {

	private CommodityDataService service;
	private CommodityTransiton transition;
	private ClassificationBLService classificationBLService;
	private ClassificationDataService classificationDataService;
	private SalesBLService salesBLService;
	private PurchaseBLService purchaseBLService;
	private InventoryBillBLService inventoryBillBLService;

	public CommodityBL() {
		service = RemoteHelper.getInstance().getCommodityDataService();
		classificationDataService = RemoteHelper.getInstance().getClassificationDataService();
		transition = new CommodityTransiton();
		classificationBLService = new ClassificationController();
		salesBLService = new SalesController();
		purchaseBLService = new PurchaseController();
		inventoryBillBLService = new InventoryBillController();
	}

	@Override
	public String getID(String name) {
		try {
			ClassificationVPO father = classificationDataService.findClassification(name);
			if (father.getChildrenPointer() == null || father.getChildrenPointer().isEmpty())
				return name + "-" + "0001";
			else {
				String lastName = father.getChildrenPointer().get(father.getChildrenPointer().size() - 1);
				String last = service.findCommodity(lastName, FindCommodityType.NAME).get(0).getID();
				String nameID = last.substring(last.length() - 4);
				int willAdd = Integer.parseInt(nameID);
				willAdd++;
				String newID = String.valueOf(willAdd);
				while (newID.length() < nameID.length())
					newID = "0" + newID;
				return name + "-" + newID;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage insert(CommodityVO vo) {
		ClassificationVPO classificationVPO = new ClassificationVPO(vo.getID(), vo.getName(), false,
				vo.getClassification(), null, null);
		classificationBLService.insert(classificationVPO);
		try {
			return service.insertCommodity(transition.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(CommodityVO vo) throws Exception {
		try {
			// 在销售、进货以及库存类单据中查找，如果有商品则无法删除
			ArrayList<SalesVO> sales = salesBLService.show();
			for (SalesVO sale : sales) {
				if (sale.getState() != BillState.SUCCESS) {
					for (CommodityItemVO commodity : sale.getCommodity()) {
						String name = commodity.getName().substring(0, commodity.getName().length() - 8);
						if (name.equals(vo.getName()))
							return ResultMessage.COULDNOTDELETE;
					}
				}
			}
			ArrayList<PurchaseVO> purchases = purchaseBLService.show();
			for (PurchaseVO purchase : purchases) {
				if (purchase.getState() != BillState.SUCCESS) {
					for (CommodityItemVO commodity : purchase.getCommodities()) {
						String name = commodity.getName().substring(0, commodity.getName().length() - 8);
						if (name.equals(vo.getName()))
							return ResultMessage.COULDNOTDELETE;
					}
				}
			}
			ArrayList<InventoryBillVO> inventories = inventoryBillBLService.show();
			for (InventoryBillVO inventory : inventories) {
				if (inventory.getState() != BillState.SUCCESS) {
					for (GiftVO commodity : inventory.getGifts()) {
						String name = commodity.getName().substring(0, commodity.getName().length() - 8);
						if (name.equals(vo.getName()))
							return ResultMessage.COULDNOTDELETE;
					}
				}
			}

			ClassificationVPO classificationVPO = new ClassificationVPO(vo.getID(), vo.getName(), false,
					vo.getClassification(), null, null);
			classificationBLService.delete(classificationVPO);
			service.deleteCommodity(vo.getID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(CommodityVO vo) {
		try {
			ClassificationVPO classificationVPO = new ClassificationVPO(vo.getID(), vo.getName(), false,
					vo.getClassification(), null, null);
			classificationBLService.update(classificationVPO);
			return service.updateCommodity(transition.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) {
		ArrayList<CommodityVO> list = new ArrayList<>();
		ArrayList<CommodityPO> poList = null;
		try {
			poList = service.findCommodity(info, properties);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CommodityVO vo = null;
		for (CommodityPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}

		return list;
	}

	// ccw
	@Override
	public ArrayList<CommodityStockVO> stock() {
		ArrayList<CommodityStockVO> commodityStockVOs = new ArrayList<>();
		CommodityStockVO commodityStockVO = null;
		ArrayList<CommodityVO> commodityVOs = show();
		for (int i = 0; i < commodityVOs.size(); i++) {
			commodityStockVO = new CommodityStockVO(commodityVOs.get(i).getID(), commodityVOs.get(i).getName(),
					commodityVOs.get(i).getModel(), commodityVOs.get(i).getNumber(),
					(commodityVOs.get(i).getRecentRetailedPrice() + commodityVOs.get(i).getRetailedPrice()) / 2,
					(commodityVOs.get(i).getRecentPurPrice() + commodityVOs.get(i).getPurPrice()) / 2, i + 1);
			commodityStockVOs.add(commodityStockVO);
		}
		return commodityStockVOs;
	}

	@Override
	public ArrayList<CommodityVO> show() {
		ArrayList<CommodityVO> list = new ArrayList<>();
		ArrayList<CommodityPO> poList = null;
		try {
			poList = service.showCommodity();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CommodityVO vo = null;
		for (CommodityPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	/**
	 * 获取全部的商品ID和名字
	 *
	 * @author lijie
	 */
	@Override
	public ArrayList<String> getIDandName() {
		ArrayList<CommodityVO> list = show();
		ArrayList<String> result = new ArrayList<>();
		for (CommodityVO vo : list) {
			result.add(vo.getName() + "(" + vo.getID() + ")");
		}
		return result;
	}

	/**
	 * 返回所有分类下为商品或者该分类为空分类的分类
	 */
	@Override
	public ArrayList<String> getAllChildrenClass() throws Exception {
		ArrayList<ClassificationVPO> vpos = classificationDataService.show();
		ArrayList<String> childrenList = new ArrayList<>();
		for (ClassificationVPO vpo : vpos) {
			if (vpo.getB()) {
				if (vpo.getChildrenPointer() == null)
					childrenList.add(vpo.getName());
				else {
					String childrenName = vpo.getChildrenPointer().get(0);
					if (!classificationDataService.findClassification(childrenName).getB())
						childrenList.add(vpo.getName());
				}
			}
		}
		return childrenList;
	}

	// ccw
	@Override
	public ArrayList<CommodityCheckVO> check(LocalDate start, LocalDate end) {
		ArrayList<CommodityCheckVO> checkVOs = new ArrayList<>();
		// 赠送单、销售单、销售退货单、进货单、进货退货单

		BillType type = BillType.INVENTORYGIFTBILL;// 赠送单
		ArrayList<InventoryBillVO> gifts = inventoryBillBLService.show();
		for (int i = 0; i < gifts.size(); i++) {
			LocalDate localDate = StringtoDate(gifts.get(i).getId());
			if (gifts.get(i).getType() == type && localDate.isAfter(start) && localDate.isBefore(end)) {
				ArrayList<GiftVO> giftVOs = gifts.get(i).getGifts();
				for (int j = 0; j < giftVOs.size(); j++) {
					Double money = null;
					try {
						ArrayList<CommodityPO> commodityPOs = service.findCommodity(
								giftVOs.get(j).getName().substring(0, giftVOs.get(j).getName().length() - 8),
								FindCommodityType.NAME);
						money = giftVOs.get(j).getNumber() * commodityPOs.get(0).getRecentPurPrice();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					checkVOs.add(new CommodityCheckVO(localDate, type, giftVOs.get(j).getName(),
							giftVOs.get(j).getNumber(), money));
				}
			}
		}

		// 销售单或销售退货单
		ArrayList<SalesVO> salesVOs = salesBLService.show();
		for (int i = 0; i < salesVOs.size(); i++) {
			type = salesVOs.get(i).getType();
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
			if (salesVOs.get(i).getType() == type && localDate.isAfter(start) && localDate.isBefore(end)) {
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					checkVOs.add(new CommodityCheckVO(localDate, type, commodityItemVOs.get(j).getName(),
							commodityItemVOs.get(j).getNumber(), commodityItemVOs.get(j).getTotal()));
				}
			}
		}

		// 进货单或进货退货单
		ArrayList<PurchaseVO> purchaseVOs = purchaseBLService.show();
		for (int i = 0; i < purchaseVOs.size(); i++) {
			type = purchaseVOs.get(i).getType();
			LocalDate localDate = StringtoDate(purchaseVOs.get(i).getId());
			ArrayList<CommodityItemVO> commodityItemVOs = purchaseVOs.get(i).getCommodities();
			if (purchaseVOs.get(i).getType() == type && localDate.isAfter(start) && localDate.isBefore(end)) {
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					checkVOs.add(new CommodityCheckVO(localDate, type, commodityItemVOs.get(j).getName(),
							commodityItemVOs.get(j).getNumber(), commodityItemVOs.get(j).getTotal()));
				}
			}
		}

		return checkVOs;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	@Override
	public void exportReport(ArrayList<CommodityStockVO> commodityStockVOs) {
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/CommodityStock.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet cSheet = wwb.createSheet("CommodityStockTable", 0);

			int cSheetL = commodityStockVOs.size();

			Label ini = new Label(0, 0, "ID");
			cSheet.addCell(ini);
			ini = new Label(1, 0, "Name");// initialize payment
			cSheet.addCell(ini);
			ini = new Label(2, 0, "Model");
			cSheet.addCell(ini);
			ini = new Label(3, 0, "Number");
			cSheet.addCell(ini);
			ini = new Label(4, 0, "AvgRetailedPrice");
			cSheet.addCell(ini);
			ini = new Label(5, 0, "AvgPurPrice");
			cSheet.addCell(ini);
			ini = new Label(6, 0, "Line");
			cSheet.addCell(ini);

			for (int i = 1; i < cSheetL + 1; i++) {
				for (int j = 0; j < 7; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, commodityStockVOs.get(i - 1).getId());
						cSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, commodityStockVOs.get(i - 1).getName());
						cSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, commodityStockVOs.get(i - 1).getModel());
						cSheet.addCell(labelC);
					} else if (j == 3) {
						Label labelC = new Label(j, i, String.valueOf(commodityStockVOs.get(i - 1).getNumber()));
						cSheet.addCell(labelC);
					} else if (j == 4) {
						Label labelC = new Label(j, i,
								String.valueOf(commodityStockVOs.get(i - 1).getAvgRetailedPrice()));
						cSheet.addCell(labelC);
					} else if (j == 5) {
						Label labelC = new Label(j, i, String.valueOf(commodityStockVOs.get(i - 1).getAvgPurPrice()));
						cSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, String.valueOf(commodityStockVOs.get(i - 1).getLine()));
						cSheet.addCell(labelC);
					}
				}
			}
			wwb.write();// 从内从中写入文件中
			wwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("生成Excel文件" + fileName + "成功");
	}

}
