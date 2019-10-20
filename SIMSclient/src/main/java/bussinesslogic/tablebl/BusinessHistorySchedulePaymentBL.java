package bussinesslogic.tablebl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogic.examinebl.ExaminePaymentBL;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
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
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;

//红冲依旧存在问题
public class BusinessHistorySchedulePaymentBL implements BusinessHistoryScheduleBLService<PaymentBillVO> {

	private ExamineBLService<PaymentBillVO> examineBLService;
	private PaymentBillBLService paymentBillBLService;

	public BusinessHistorySchedulePaymentBL() {
		examineBLService = new ExaminePaymentBL();
		paymentBillBLService = new PaymentBillController();
	}

	@Override
	public ArrayList<PaymentBillVO> show() {
		ArrayList<PaymentBillVO> out = new ArrayList<>();
		ArrayList<PaymentBillVO> paymentBillVOs = paymentBillBLService.show();
		for (int i = 0; i < paymentBillVOs.size(); i++) {
			if (paymentBillVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(paymentBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<PaymentBillVO> siftTime(LocalDate start, LocalDate end) {

		ArrayList<PaymentBillVO> out = new ArrayList<>();
		ArrayList<PaymentBillVO> paymentBillVOs = paymentBillBLService.show();
		for (int i = 0; i < paymentBillVOs.size(); i++) {
			LocalDate localDate = StringtoDate(paymentBillVOs.get(i).getId());
			if ((localDate.isBefore(end) || localDate.isEqual(start))
					&& (localDate.isAfter(start) || localDate.isEqual(end))
					&& (paymentBillVOs.get(i).getState() == BillState.SUCCESS)) {
				out.add(paymentBillVOs.get(i));
			}
		}
		return out;
	}

	/**
	 * 筛选条件：客户、业务员
	 */
	@Override
	public ArrayList<PaymentBillVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<PaymentBillVO> out = new ArrayList<>();
		ArrayList<PaymentBillVO> paymentBillVOs = paymentBillBLService.show();
		if (type == FindSaleScheduleType.OPERATOR) {
			for (int i = 0; i < paymentBillVOs.size(); i++) {
				String userID = paymentBillVOs.get(i).getUserID();
				if (userID.equals(info)) {
					out.add(paymentBillVOs.get(i));
				}
			}
		}
		if (type == FindSaleScheduleType.MEMBER) {
			for (int i = 0; i < paymentBillVOs.size(); i++) {
				String customerID = paymentBillVOs.get(i).getCustomerID();
				if (customerID.equals(info)) {
					out.add(paymentBillVOs.get(i));
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<PaymentBillVO> table) {
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/PaymentSchedule.xlsx";
		try {
			// 创建一个可写入的工作簿（WorkBook）对象,
			// 这里用父类方法createWorkbook创建子类WritableWorkbook让我想起了工厂方法
			wwb = Workbook.createWorkbook(new File(fileName));

			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作簿中的位置
			WritableSheet pSheet = wwb.createSheet("PaymentTable", 0);

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
	public ArrayList<PaymentBillVO> writeOff(ArrayList<PaymentBillVO> table) {// 不能是总经理
		ArrayList<PaymentBillVO> pArrayList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PaymentBillVO paymentBillVO = redRush(table.get(i));
			paymentBillVO.setState(BillState.COMMITED);
			paymentBillBLService.save(paymentBillVO);
			pArrayList.add(paymentBillVO);
		}
		try {
			examineBLService.passBills(pArrayList);
			return pArrayList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> writeOffAndCopy(ArrayList<PaymentBillVO> table) {// 不能是总经理
		ArrayList<PaymentBillVO> pArrayList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PaymentBillVO paymentBillVO = redRush(table.get(i));
			paymentBillBLService.save(paymentBillVO);
			pArrayList.add(paymentBillVO);
		}
		return pArrayList;
	}

	public LocalDate StringtoDate(String id) {// id是单据编号
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	public PaymentBillVO redRush(PaymentBillVO paymentBillVO) {// 红冲数据转化方法
		String customerID = paymentBillVO.getCustomerID();
		String userID = paymentBillVO.getUserID();
		String accountID = paymentBillVO.getAccountID();
		String note = paymentBillVO.getNote();
		BillState billState = paymentBillVO.getState();
		BillType billType = paymentBillVO.getType();
		// 以上是不会变化的单据属性
		// 单据的id要另外存取
		String docID = paymentBillBLService.getId();
		// 以下是会将数值取负的单据属性
		double total = -paymentBillVO.getTotal();
		ArrayList<EntryVO> eVOs = new ArrayList<>();
		ArrayList<EntryVO> entryVOs = paymentBillVO.getEntryListVO();
		for (int i = 0; i < entryVOs.size(); i++) {
			eVOs.add(new EntryVO(entryVOs.get(i).getEntryName(), -entryVOs.get(i).getTransferAmount(),
					entryVOs.get(i).getNote()));
		}
		return new PaymentBillVO(docID, userID, customerID, accountID, eVOs, total, billType, billState, note);
	}

	@Override
	public ResultMessage updateBill(PaymentBillVO table) {
		ArrayList<PaymentBillVO> pList = new ArrayList<>();
		PaymentBillVO paymentBillVO = table;
		paymentBillVO.setState(BillState.COMMITED);
		paymentBillBLService.save(paymentBillVO);
		pList.add(paymentBillVO);
		try {
			examineBLService.passBills(pList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
