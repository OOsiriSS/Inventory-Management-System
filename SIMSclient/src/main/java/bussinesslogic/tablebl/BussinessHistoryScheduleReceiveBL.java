package bussinesslogic.tablebl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.ReceiptBillController;
import bussinesslogic.examinebl.ExamineReceiptBL;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
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
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class BussinessHistoryScheduleReceiveBL implements BusinessHistoryScheduleBLService<ReceiptBillVO> {

	private ExamineBLService<ReceiptBillVO> examineBLService;
	private ReceiptBillBLService receiptBillBLService;

	public BussinessHistoryScheduleReceiveBL() {
		examineBLService = new ExamineReceiptBL();
		receiptBillBLService = new ReceiptBillController();
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		ArrayList<ReceiptBillVO> out = new ArrayList<>();
		ArrayList<ReceiptBillVO> receiptBillVOs = receiptBillBLService.show();
		for (int i = 0; i < receiptBillVOs.size(); i++) {
			if (receiptBillVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(receiptBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<ReceiptBillVO> siftTime(LocalDate start, LocalDate end) {

		ArrayList<ReceiptBillVO> out = new ArrayList<>();
		ArrayList<ReceiptBillVO> receiptBillVOs = receiptBillBLService.show();
		for (int i = 0; i < receiptBillVOs.size(); i++) {
			LocalDate localDate = StringtoDate(receiptBillVOs.get(i).getId());
			if ((localDate.isBefore(end) || localDate.isEqual(end))
					&& (localDate.isAfter(start) || localDate.isEqual(start))
					&& (receiptBillVOs.get(i).getState() == BillState.SUCCESS)) {
				out.add(receiptBillVOs.get(i));
			}
		}
		return out;
	}

	/**
	 * 筛选条件：客户、业务员
	 */
	@Override
	public ArrayList<ReceiptBillVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<ReceiptBillVO> out = new ArrayList<>();
		ArrayList<ReceiptBillVO> receiptBillVOs = receiptBillBLService.show();
		if (type == FindSaleScheduleType.OPERATOR) {
			for (int i = 0; i < receiptBillVOs.size(); i++) {
				String userID = receiptBillVOs.get(i).getUserID();
				if (userID.equals(info)) {
					out.add(receiptBillVOs.get(i));
				}
			}
		}
		if (type == FindSaleScheduleType.MEMBER) {
			for (int i = 0; i < receiptBillVOs.size(); i++) {
				String customerID = receiptBillVOs.get(i).getCustomerID();
				if (customerID.equals(info)) {
					out.add(receiptBillVOs.get(i));
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<ReceiptBillVO> table) {
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/ReceiptSchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet pSheet = wwb.createSheet("ReceiptTable", 0);

			int bSheetL = table.size();

			Label ini = new Label(0, 0, "Date");
			pSheet.addCell(ini);
			ini = new Label(1, 0, "Id");// initialize
			pSheet.addCell(ini);
			ini = new Label(2, 0, "Type");
			pSheet.addCell(ini);
			ini = new Label(3, 0, "Operator");
			pSheet.addCell(ini);
			ini = new Label(4, 0, "Total");
			pSheet.addCell(ini);

			for (int i = 1; i < bSheetL + 1; i++) {
				for (int j = 0; j < 5; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(StringtoDate(table.get(i - 1).getId())));
						pSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, table.get(i - 1).getId());
						pSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, table.get(i - 1).getTypeString());
						pSheet.addCell(labelC);
					} else if (j == 3) {
						Label labelC = new Label(j, i, table.get(i - 1).getUserID());
						pSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, String.valueOf(table.get(i - 1).getTotal()));
						pSheet.addCell(labelC);
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
	public ArrayList<ReceiptBillVO> writeOff(ArrayList<ReceiptBillVO> table) {
		ArrayList<ReceiptBillVO> rList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			ReceiptBillVO receiptBillVO = redRush(table.get(i));
			receiptBillVO.setState(BillState.COMMITED);
			receiptBillBLService.save(receiptBillVO);// 存入红冲创建的新单据
			rList.add(receiptBillVO);
		}
		try {
			examineBLService.passBills(rList);
			return rList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReceiptBillVO> writeOffAndCopy(ArrayList<ReceiptBillVO> table) {
		ArrayList<ReceiptBillVO> rList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			ReceiptBillVO receiptBillVO = redRush(table.get(i));
			receiptBillBLService.save(receiptBillVO);// 存入红冲创建的新单据
			rList.add(receiptBillVO);
		}
		return rList;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	public ReceiptBillVO redRush(ReceiptBillVO receiptBillVO) {
		String customerID = receiptBillVO.getCustomerID();
		String userID = receiptBillVO.getUserID();
		String note = receiptBillVO.getNote();
		BillState billState = receiptBillVO.getState();
		BillType billType = receiptBillVO.getType();
		// 以上是不会变化的单据属性
		// 单据的id要另外存取
		String docID = receiptBillBLService.getId();
		// 以下是会将数值取负的单据属性
		double total = -receiptBillVO.getTotal();
		ArrayList<AccountListVO> aVOs = new ArrayList<>();
		ArrayList<AccountListVO> accountListVOs = receiptBillVO.getAccountListVOs();
		for (int i = 0; i < accountListVOs.size(); i++) {
			aVOs.add(new AccountListVO(accountListVOs.get(i).getAccountID(), -accountListVOs.get(i).getMoney(),
					accountListVOs.get(i).getNote()));
		}
		return new ReceiptBillVO(docID, userID, customerID, billType, billState, aVOs, total, note);
	}

	@Override
	public ResultMessage updateBill(ReceiptBillVO table) {
		ArrayList<ReceiptBillVO> rList = new ArrayList<>();
		ReceiptBillVO receiptBillVO = table;
		receiptBillVO.setState(BillState.COMMITED);
		receiptBillBLService.save(receiptBillVO);// 存入红冲创建的新单据
		rList.add(receiptBillVO);
		try {
			examineBLService.passBills(rList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
