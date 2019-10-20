package bussinesslogic.tablebl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.examinebl.ExaminePurchaseBL;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

public class BussinessHistorySchedulePurchaseBL implements BusinessHistoryScheduleBLService<PurchaseVO> {

	private PurchaseBLService purchaseBLService;
	private ExamineBLService<PurchaseVO> examineBLService;

	public BussinessHistorySchedulePurchaseBL() {
		purchaseBLService = new PurchaseController();
		examineBLService = new ExaminePurchaseBL();
	}

	@Override
	public ArrayList<PurchaseVO> show() {
		ArrayList<PurchaseVO> out = new ArrayList<>();
		ArrayList<PurchaseVO> purchaseVOs = purchaseBLService.show();
		for (int i = 0; i < purchaseVOs.size(); i++) {
			if (purchaseVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(purchaseVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<PurchaseVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<PurchaseVO> out = new ArrayList<>();
		ArrayList<PurchaseVO> purchaseVOs = show();
		for (int i = 0; i < purchaseVOs.size(); i++) {
			LocalDate localDate = StringtoDate(purchaseVOs.get(i).getId());
			if ((localDate.isAfter(start) || localDate.isEqual(start))
					&& (localDate.isBefore(end) || localDate.isEqual(end))
					&& purchaseVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(purchaseVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<PurchaseVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<PurchaseVO> out = new ArrayList<>();
		ArrayList<PurchaseVO> purchaseVOs = show();
		if (FindSaleScheduleType.OPERATOR == type) {// 操作员（业务员）
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if (purchaseVOs.get(i).getOperator().equals(info)) {
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.WAREHOUSE == type) {// 仓库
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if (purchaseVOs.get(i).getWarehouse().equals(info)) {
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.MEMBER == type) {// 客户：这里要注意客户为retailer，详情参见salesvo
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if (purchaseVOs.get(i).getSupplier().equals(info)) {
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.NAME == type) {// 商品，返回所有带有该商品的单据
			for (int i = 0; i < purchaseVOs.size(); i++) {
				ArrayList<CommodityItemVO> commodityItemVOs = purchaseVOs.get(i).getCommodities();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					if (commodityItemVOs.get(i).getName().equals(info)) {
						out.add(purchaseVOs.get(i));
						break;
					}
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<PurchaseVO> table) {
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/PurchaseSchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet bSheet = wwb.createSheet("PurchaseTable", 0);

			int bSheetL = table.size();

			Label ini = new Label(0, 0, "Date");
			bSheet.addCell(ini);
			ini = new Label(1, 0, "Id");// initialize
			bSheet.addCell(ini);
			ini = new Label(2, 0, "Type");
			bSheet.addCell(ini);
			ini = new Label(3, 0, "Operator");
			bSheet.addCell(ini);

			for (int i = 1; i < bSheetL + 1; i++) {
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(StringtoDate(table.get(i - 1).getId())));
						bSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, table.get(i - 1).getId());
						bSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, table.get(i - 1).getTypeString());
						bSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, table.get(i - 1).getOperator());
						bSheet.addCell(labelC);
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

	@Override
	public ArrayList<PurchaseVO> writeOff(ArrayList<PurchaseVO> table) {
		ArrayList<PurchaseVO> pList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PurchaseVO purchaseVO = redRush(table.get(i));
			purchaseVO.setState(BillState.COMMITED);
			purchaseBLService.save(purchaseVO);
			pList.add(purchaseVO);
		}
		try {
			examineBLService.passBills(pList);
			return pList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> writeOffAndCopy(ArrayList<PurchaseVO> table) {
		ArrayList<PurchaseVO> pList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PurchaseVO purchaseVO = redRush(table.get(i));
			purchaseVO.setState(BillState.COMMITED);
			purchaseBLService.save(purchaseVO);
			pList.add(purchaseVO);
		}
		return pList;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	public PurchaseVO redRush(PurchaseVO purchaseVO) {
		String supplier = purchaseVO.getSupplier();
		Warehouse warehouse = purchaseVO.getWarehouse();
		String operator = purchaseVO.getOperator();
		String note = purchaseVO.getNote();
		BillState billState = purchaseVO.getState();
		BillType billType = purchaseVO.getType();
		Double sum = -purchaseVO.getSum();
		String id = "";
		if (purchaseVO.getType() == BillType.PURCHASEBACKBILL)
			id = purchaseBLService.getPurChaseBackID();
		else
			id = purchaseBLService.getPurchaseID();
		ArrayList<CommodityItemVO> commodities = purchaseVO.getCommodities();
		for (int i = 0; i < commodities.size(); i++) {
			Integer number = commodities.get(i).getNumber();
			commodities.get(i).setNumber(-number);
		}
		return new PurchaseVO(id, supplier, warehouse, operator, commodities, note, sum, billType, billState);
	}

	@Override
	public ResultMessage updateBill(PurchaseVO table) {
		ArrayList<PurchaseVO> pList = new ArrayList<>();
		PurchaseVO purchaseVO = table;
		purchaseVO.setState(BillState.COMMITED);
		purchaseBLService.save(purchaseVO);
		pList.add(purchaseVO);
		try {
			examineBLService.passBills(pList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
