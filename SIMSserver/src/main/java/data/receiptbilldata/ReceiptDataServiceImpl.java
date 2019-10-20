package data.receiptbilldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import po.financialbillpo.ReceiptBillPO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ14ÈÕ
 */
public class ReceiptDataServiceImpl implements ReceiptBillDataService {

	private ReceiptBillData receipt;

	public ReceiptDataServiceImpl() {
		receipt = new ReceiptBillData();
	}

	@Override
	public ResultMessage insertReceiptBill(ReceiptBillPO po) throws RemoteException {
		return receipt.insert(po);
	}

	@Override
	public ResultMessage deleteReceiptBill(String id) throws RemoteException {
		return receipt.delete(id);
	}

	@Override
	public ResultMessage updateReceiptBill(ReceiptBillPO po) throws RemoteException {
		return receipt.update(po);
	}

	@Override
	public ArrayList<ReceiptBillPO> findReceiptBill(String keyword, FindAccountBillType type) throws RemoteException {
		return receipt.find(keyword, type);
	}

	@Override
	public ArrayList<ReceiptBillPO> showReceiptBill() throws RemoteException {
		return receipt.show();
	}

}
