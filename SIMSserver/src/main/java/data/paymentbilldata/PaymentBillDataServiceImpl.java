package data.paymentbilldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import po.financialbillpo.PaymentBillPO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ14ÈÕ
 */
public class PaymentBillDataServiceImpl implements PaymentBillDataService {

	private PaymentBillData payment;

	public PaymentBillDataServiceImpl() {
		payment = new PaymentBillData();
	}

	@Override
	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException {
		return payment.insert(po);
	}

	@Override
	public ResultMessage deletePaymentBill(String id) throws RemoteException {
		return payment.delete(id);
	}

	@Override
	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException {
		return payment.update(po);
	}

	@Override
	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException {
		return payment.find(keyword, type);
	}

	@Override
	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException {
		return payment.show();
	}

}
