package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillBLService_Stub implements ReceiptBillBLService {

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type) {
		// TODO Auto-generated method stub
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		AccountListVO account1 = new AccountListVO("00001", 5000.00, "CNJDAN");
		AccountListVO account2 = new AccountListVO("00002", 4000.00, "CADCACDA");
		accountList.add(account1);
		accountList.add(account2);
		ArrayList<ReceiptBillVO> list = new ArrayList<>();
		ReceiptBillVO bill = new ReceiptBillVO("00001", "Panxy", "00001", BillType.XJFYD, BillState.DRAFT, accountList,
				9000.00, "ncidan");
		list.add(bill);
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
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		AccountListVO account1 = new AccountListVO("00001", 5000.00, "CNJDAN");
		AccountListVO account2 = new AccountListVO("00002", 4000.00, "CADCACDA");
		accountList.add(account1);
		accountList.add(account2);
		ArrayList<ReceiptBillVO> list = new ArrayList<>();
		ReceiptBillVO bill = new ReceiptBillVO("00001", "Panxy", "00001", BillType.XJFYD, BillState.DRAFT, accountList,
				9000.00, "ncidan");
		list.add(bill);
		return list;
	}

	@Override
	public String getId() {
		return "SKD-20171212-00002";
	}

}
