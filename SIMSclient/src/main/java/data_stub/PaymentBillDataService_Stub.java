package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import po.financialbillpo.EntryPO;
import po.financialbillpo.PaymentBillPO;

/**
 * 
 * @author Lijie
 * @date 2018Äê1ÔÂ10ÈÕ
 */
public class PaymentBillDataService_Stub implements PaymentBillDataService {

	@Override
	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deletePaymentBill(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException {
		ArrayList<EntryPO> entryList = new ArrayList<>();
		EntryPO entry1 = new EntryPO("QWERT", 20.00, "NCFIDJCN");
		EntryPO entry2 = new EntryPO("RAT", 789.00, "NCJDJC");
		entryList.add(entry1);
		entryList.add(entry2);
		PaymentBillPO bill1 = new PaymentBillPO("XJFKD-20180105-00001", "Panxy", "00001", "00001", entryList, 809.00,
				BillType.XJFYD, BillState.DRAFT, "dsa");
		ArrayList<PaymentBillPO> list = new ArrayList<>();
		list.add(bill1);

		return list;
	}

	@Override
	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException {
		ArrayList<EntryPO> entryList = new ArrayList<>();
		EntryPO entry1 = new EntryPO("QWERT", 20.00, "NCFIDJCN");
		EntryPO entry2 = new EntryPO("RAT", 789.00, "NCJDJC");
		entryList.add(entry1);
		entryList.add(entry2);
		PaymentBillPO bill1 = new PaymentBillPO("XJFKD-20180105-00001", "Panxy", "00001", "00001", entryList, 809.00,
				BillType.XJFYD, BillState.DRAFT, "dsa");
		ArrayList<PaymentBillPO> list = new ArrayList<>();
		list.add(bill1);

		return list;
	}

}
