package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.PaymentBillVO;

public interface PaymentBillBLService {

	public ResultMessage save(PaymentBillVO paymentBillVO);// 如果没有，就新建，否则修改

	public ResultMessage delete(PaymentBillVO paymentBillVO);

	public ArrayList<PaymentBillVO> show();

	public ArrayList<PaymentBillVO> find(String info, FindAccountBillType type);

	public ArrayList<String> getAccountList(); // id+" "+name

	public ArrayList<String> getCustomerList(); // id+" "+name

	public ResultMessage judgeLegal(String money);

	public ResultMessage commit(PaymentBillVO paymentBillVO);

	public String getId();

}
