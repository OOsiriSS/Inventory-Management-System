package bussinesslogic.tablebl;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.salesblservice.SalesBLService;
import bussinesslogicservice.tableblservice.SaleScheduleBLService;
import dataenum.BillType;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.tablevo.SaleScheduleVO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class SaleScheduleBL implements SaleScheduleBLService {

	private SalesBLService salesBLService;

	public SaleScheduleBL() {
		salesBLService = new SalesController();
	}

	@Override
	public void exportReport(ArrayList<SaleScheduleVO> sale) {// 这个是导出为excel的方法
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/SaleSchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet sSheet = wwb.createSheet("SaleTable", 0);

			int sSheetL = sale.size();

			Label ini = new Label(0, 0, "Date");
			sSheet.addCell(ini);
			ini = new Label(1, 0, "Name");// initialize payment
			sSheet.addCell(ini);
			ini = new Label(2, 0, "Model");
			sSheet.addCell(ini);
			ini = new Label(3, 0, "Number");
			sSheet.addCell(ini);
			ini = new Label(4, 0, "Price");
			sSheet.addCell(ini);
			ini = new Label(5, 0, "Sum");
			sSheet.addCell(ini);

			for (int i = 1; i < sSheetL + 1; i++) {
				for (int j = 0; j < 6; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getDate()));
						sSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, sale.get(i - 1).getName());
						sSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, sale.get(i - 1).getModel());
						sSheet.addCell(labelC);
					} else if (j == 3) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getNumber()));
						sSheet.addCell(labelC);
					} else if (j == 4) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getPrice()));
						sSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getSum()));
						sSheet.addCell(labelC);
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
	public ArrayList<SaleScheduleVO> show() {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					String name = commodityItemVOs.get(j).getName();
					String model = commodityItemVOs.get(j).getModel();
					Integer number = commodityItemVOs.get(j).getNumber();
					Double price = commodityItemVOs.get(j).getPrice();
					SaleScheduleVO saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
				}
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		SaleScheduleVO saleScheduleVO = null;
		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				if ((localDate.isEqual(start) || localDate.isAfter(start))
						&& (localDate.isEqual(end) || localDate.isBefore(end))) {
					ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
					for (int j = 0; j < commodityItemVOs.size(); j++) {
						String name = commodityItemVOs.get(j).getName();
						String model = commodityItemVOs.get(j).getModel();
						Integer number = commodityItemVOs.get(j).getNumber();
						Double price = commodityItemVOs.get(j).getPrice();
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
					}
				}
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		SaleScheduleVO saleScheduleVO = null;
		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				String member = salesVOs.get(i).getRetailer();// 这里直接用的客户string
				String operator = salesVOs.get(i).getOperator();
				String wareHouse = salesVOs.get(i).getWarehouseString();
				ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					String name = commodityItemVOs.get(j).getName();
					String model = commodityItemVOs.get(j).getModel();
					Integer number = commodityItemVOs.get(j).getNumber();
					Double price = commodityItemVOs.get(j).getPrice();
					if (type == FindSaleScheduleType.NAME && name.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.MEMBER && member.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.OPERATOR && operator.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.WAREHOUSE && wareHouse.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
				}
			}
		}
		return saleScheduleVOs;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

}
