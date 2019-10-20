package bussinesslogic.accountbillbl;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillController implements ReceiptBillBLService {

	ReceiptBillBL receiptBillBL = new ReceiptBillBL();

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		return receiptBillBL.save(receiptBillVO);
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		return receiptBillBL.delete(receiptBillVO);
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		return receiptBillBL.show();
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type) {
		return receiptBillBL.find(info, type);
	}

	@Override
	public ArrayList<String> getAccountList() {
		return receiptBillBL.getAccountList();
	}

	@Override
	public ArrayList<String> getCustomerList() {
		return receiptBillBL.getCustomerList();
	}

	@Override
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		return receiptBillBL.commit(receiptBillVO);
	}

	@Override
	public String getId() {
		return receiptBillBL.getId();
	}

}
