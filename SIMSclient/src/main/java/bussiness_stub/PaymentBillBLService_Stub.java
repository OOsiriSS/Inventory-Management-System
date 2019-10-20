package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;

public class PaymentBillBLService_Stub implements PaymentBillBLService {

	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage judgeLegal(String money) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindAccountBillType type) {
		ArrayList<EntryVO> entryList = new ArrayList<>();
		EntryVO entry1 = new EntryVO("QWERT", 20.00, "NCFIDJCN");
		EntryVO entry2 = new EntryVO("RAT", 789.00, "NCJDJC");
		entryList.add(entry1);
		entryList.add(entry2);

		ArrayList<PaymentBillVO> list = new ArrayList<>();
		PaymentBillVO bill1 = new PaymentBillVO("00001", "Panxy", "00001", "00001", entryList, 809.00, BillType.XJFYD,
				BillState.DRAFT, "dsa");
		list.add(bill1);
		return list;
	}

	@Override
	public ArrayList<String> getAccountList() {
		ArrayList<String> list = new ArrayList<>();
		String account1 = "cancan(00001)";
		String account2 = "lijie(00002)";
		list.add(account1);
		list.add(account2);
		return list;
	}

	@Override
	public ArrayList<String> getCustomerList() {
		String member1 = "¿ÓΩ‹(00001)";
		String member2 = "NJU(00002)";
		System.out.println("Show Succeed!\n");
		ArrayList<String> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		return list;
	}

	@Override
	public ArrayList<PaymentBillVO> show() {
		ArrayList<EntryVO> entryList = new ArrayList<>();
		EntryVO entry1 = new EntryVO("QWERT", 20.00, "NCFIDJCN");
		EntryVO entry2 = new EntryVO("RAT", 789.00, "NCJDJC");
		entryList.add(entry1);
		entryList.add(entry2);

		ArrayList<PaymentBillVO> list = new ArrayList<>();
		PaymentBillVO bill1 = new PaymentBillVO("00001", "Panxy", "00001", "00001", entryList, 809.00, BillType.XJFYD,
				BillState.DRAFT, "dsa");
		list.add(bill1);
		return list;
	}

	@Override
	public String getId() {
		return "FKD-20171225-00001";
	}

}
