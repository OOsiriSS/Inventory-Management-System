package bussinesslogic.accountbillbl;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.PaymentBillVO;

public class PaymentBillController implements PaymentBillBLService {

	PaymentBillBL paymentBillBL = new PaymentBillBL();

	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		return paymentBillBL.save(paymentBillVO);
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		return paymentBillBL.delete(paymentBillVO);
	}

	@Override
	public ArrayList<PaymentBillVO> show() {
		return paymentBillBL.show();
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindAccountBillType type) {
		return paymentBillBL.find(info, type);
	}

	@Override
	public ArrayList<String> getAccountList() {
		return paymentBillBL.getAccountList();
	}

	@Override
	public ArrayList<String> getCustomerList() {
		return paymentBillBL.getCustomerList();
	}

	@Override
	public ResultMessage judgeLegal(String money) {
		return paymentBillBL.judgeLegal(money);
	}

	@Override
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		return paymentBillBL.commit(paymentBillVO);
	}

	@Override
	public String getId() {
		return paymentBillBL.getId();
	}

}
