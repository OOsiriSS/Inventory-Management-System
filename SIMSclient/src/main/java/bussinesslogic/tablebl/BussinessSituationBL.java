package bussinesslogic.tablebl;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import bussinesslogicservice.tableblservice.BussinessSituationBLService;
import dataenum.BillType;
import dataenum.MoneyType;
import dataenum.findtype.FindCommodityType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityVO;
import vo.commodityvo.GiftVO;
import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//对商品类收入存在疑问
public class BussinessSituationBL implements BussinessSituationBLService {

	private SalesBLService salesBLService;
	private InventoryBillBLService inventoryBillBLService;
	private CommodityBLService commodityBLService;

	public BussinessSituationBL() {
		salesBLService = new SalesController();
		inventoryBillBLService = new InventoryBillController();
		commodityBLService = new CommodityBL();
	}

	@Override
	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive) {// 这个是导出为excel的方法
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/BussinessSituationSchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet pSheet = wwb.createSheet("PaymentTable", 0);
			WritableSheet rSheet = wwb.createSheet("ReceiptTable", 1);

			int pSheetL = pay.size();
			int rSheetL = receive.size();

			Label ini = new Label(0, 0, "Date");
			pSheet.addCell(ini);
			ini = new Label(1, 0, "Type");// initialize payment
			pSheet.addCell(ini);
			ini = new Label(2, 0, "Sum");
			pSheet.addCell(ini);

			ini = new Label(0, 0, "Date");
			rSheet.addCell(ini);
			ini = new Label(1, 0, "Type");// initialize receipt;
			rSheet.addCell(ini);
			ini = new Label(2, 0, "Allowance");
			rSheet.addCell(ini);
			ini = new Label(3, 0, "Sum");
			rSheet.addCell(ini);

			for (int i = 1; i < pSheetL + 1; i++) {
				for (int j = 0; j < 3; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(pay.get(i - 1).getDate()));
						pSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, pay.get(i - 1).getTypeString());
						pSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, Double.toString(pay.get(i - 1).getSum()));
						pSheet.addCell(labelC);
					}
				}
			}

			for (int i = 1; i < rSheetL + 1; i++) {
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(receive.get(i - 1).getDate()));
						rSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, receive.get(i - 1).getTypeString());
						rSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, Double.toString(receive.get(i - 1).getAllowance()));
						rSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, Double.toString(receive.get(i - 1).getSum()));
						rSheet.addCell(labelC);
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
	public ArrayList<PaymentTableVO> showPay() {// 支出类
		ArrayList<PaymentTableVO> paymentTableVOs = new ArrayList<>();

		ArrayList<SalesVO> salesVOs = salesBLService.show();// 销售成本
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			Double sum = salesVOs.get(i).getAfterPrice();// 销售成本
			paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
		}
		// 商品报损或赠出
		ArrayList<InventoryBillVO> inventoryBillVOs = inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			if (inventoryBillVOs.get(i).getType() == BillType.INVENTORYGIFTBILL
					|| inventoryBillVOs.get(i).getType() == BillType.INVENTORYLOSSBILL) {
				LocalDate localDate = StringtoDate(inventoryBillVOs.get(i).getId());
				double sum = 0.0;
				ArrayList<GiftVO> giftVOs = inventoryBillVOs.get(i).getGifts();
				for (int j = 0; j < giftVOs.size(); j++) {
					try {// 这里会多访问一次数据库，可以优化
						String name = giftVOs.get(j).getName();
						ArrayList<CommodityVO> commodityVOs = commodityBLService.find(getTrueName(name),
								FindCommodityType.NAME);
						sum += commodityVOs.get(0).getPurPrice() * giftVOs.get(j).getNumber();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.COMMODITY, sum));
			}
		}

		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> showReceive() {// 收入类
		ArrayList<ReceiveTableVO> receiveTableVOs = new ArrayList<>();

		ArrayList<SalesVO> salesVOs = salesBLService.show();// 销售收入
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			Double sum = salesVOs.get(i).getAfterPrice();// 销售折让收入
			Double allowance = salesVOs.get(i).getAllowance();// 销售折让金额
			receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance, sum));
		}

		return receiveTableVOs;
	}

	@Override
	public ArrayList<PaymentTableVO> siftPay(LocalDate start, LocalDate end) {
		ArrayList<PaymentTableVO> paymentTableVOs = new ArrayList<>();

		ArrayList<SalesVO> salesVOs = salesBLService.show();// 销售成本
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			if (localDate.isBefore(end) && localDate.isAfter(start)) {
				Double sum = salesVOs.get(i).getAfterPrice();// 销售成本
				paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
			}
		}
		// 商品报损或赠出
		ArrayList<InventoryBillVO> inventoryBillVOs = inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			LocalDate localDate = StringtoDate(inventoryBillVOs.get(i).getId());
			if (localDate.isBefore(end) && localDate.isAfter(start)) {
				if (inventoryBillVOs.get(i).getType() == BillType.INVENTORYGIFTBILL
						|| inventoryBillVOs.get(i).getType() == BillType.INVENTORYLOSSBILL) {
					double sum = 0.0;
					ArrayList<GiftVO> giftVOs = inventoryBillVOs.get(i).getGifts();
					for (int j = 0; j < giftVOs.size(); j++) {
						try {// 这里会多访问一次数据库，可以优化
							String name = giftVOs.get(j).getName();
							ArrayList<CommodityVO> commodityVOs = commodityBLService.find(getTrueName(name),
									FindCommodityType.NAME);
							sum += commodityVOs.get(0).getPurPrice() * giftVOs.get(j).getNumber();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.COMMODITY, sum));
				}
			}
		}

		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> siftReceive(LocalDate start, LocalDate end) {
		ArrayList<ReceiveTableVO> receiveTableVOs = new ArrayList<>();

		ArrayList<SalesVO> salesVOs = salesBLService.show();// 销售收入
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			if (localDate.isAfter(start) && localDate.isBefore(end)) {
				Double sum = salesVOs.get(i).getAfterPrice();// 销售折让收入
				Double allowance = salesVOs.get(i).getAllowance();// 销售折让金额
				receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance, sum));
			}
		}

		return receiveTableVOs;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	/**
	 * 商品名的过滤
	 * 
	 * @param name
	 *            显示在单据上的商品名
	 * @return 真实的商品名
	 */
	public String getTrueName(String name) {
		String newName = "";
		for (int m = 0; m < name.length(); m++) {
			if (name.charAt(m) == '(') {
				newName = name.substring(0, m);
				break;
			}
		}
		return newName;
	}
}
