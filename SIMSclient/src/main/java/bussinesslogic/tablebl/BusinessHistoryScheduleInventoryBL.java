package bussinesslogic.tablebl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.examinebl.ExamineInventoryBL;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class BusinessHistoryScheduleInventoryBL implements BusinessHistoryScheduleBLService<InventoryBillVO> {

	private InventoryBillBLService inventoryBillBLService;
	private ExamineBLService<InventoryBillVO> examineBLService;

	public BusinessHistoryScheduleInventoryBL() {
		inventoryBillBLService = new InventoryBillController();
		examineBLService = new ExamineInventoryBL();
	}

	@Override
	public ArrayList<InventoryBillVO> show() {// 只展示报溢、报损、赠送单
		ArrayList<InventoryBillVO> out = new ArrayList<>();
		ArrayList<InventoryBillVO> inventoryBillVOs = inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {// 过滤
			if ((inventoryBillVOs.get(i).getType() != BillType.INVENTORYWARNINGBILL)
					&& (inventoryBillVOs.get(i).getState() == BillState.SUCCESS)) {
				out.add(inventoryBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<InventoryBillVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<InventoryBillVO> out = new ArrayList<>();
		ArrayList<InventoryBillVO> inventoryBillVOs = show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			LocalDate localDate = StringtoDate(inventoryBillVOs.get(i).getId());
			if ((localDate.isAfter(start) || localDate.isEqual(start))
					&& (localDate.isBefore(end) || localDate.isEqual(end))
					&& (inventoryBillVOs.get(i).getState() == BillState.SUCCESS)) {
				out.add(inventoryBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<InventoryBillVO> sift(String info, FindSaleScheduleType type) {
		/*
		 * 这个方法不写
		 */
		return null;
	}

	@Override
	public void exportReport(ArrayList<InventoryBillVO> table) {
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/asus/Desktop/InventorySchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet bSheet = wwb.createSheet("InventoryTable", 0);

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
	public ArrayList<InventoryBillVO> writeOff(ArrayList<InventoryBillVO> table) {
		ArrayList<InventoryBillVO> iList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			InventoryBillVO inventoryBillVO = redRush(table.get(i));
			inventoryBillVO.setState(BillState.COMMITED);
			inventoryBillBLService.save(inventoryBillVO);
			iList.add(inventoryBillVO);
		}
		try {
			examineBLService.passBills(iList);
			return iList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> writeOffAndCopy(ArrayList<InventoryBillVO> table) {
		ArrayList<InventoryBillVO> iList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			InventoryBillVO inventoryBillVO = redRush(table.get(i));
			inventoryBillBLService.save(inventoryBillVO);
			iList.add(inventoryBillVO);
		}
		return iList;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	public InventoryBillVO redRush(InventoryBillVO inventoryBillVO) {
		String operator = inventoryBillVO.getOperator();
		BillState billState = inventoryBillVO.getState();
		BillType billType = inventoryBillVO.getType();
		String note = inventoryBillVO.getNote();
		String id = inventoryBillBLService.getId(billType);
		ArrayList<GiftVO> gifts = inventoryBillVO.getGifts();
		for (int i = 0; i < gifts.size(); i++) {
			int number = gifts.get(i).getNumber();
			gifts.get(i).setNumber(-number);
		}
		return new InventoryBillVO(id, gifts, operator, billType, billState, note);
	}

	@Override
	public ResultMessage updateBill(InventoryBillVO table) {
		InventoryBillVO inventoryBillVO = table;
		inventoryBillBLService.save(inventoryBillVO);
		return ResultMessage.SUCCESS;
	}

}
