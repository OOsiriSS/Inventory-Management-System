package bussinesslogic.accountbillbl;

import java.util.ArrayList;

import po.financialbillpo.AccountListPO;
import po.financialbillpo.ReceiptBillPO;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillTransition {

	AccountListPO accountListPO;
	AccountListVO accountListVO;

	public ReceiptBillPO VOtoPO(ReceiptBillVO receiptBillVO) {

		accountListPO = new AccountListPO("", 0.0, "");

		double total = receiptBillVO.getTotal();
		ArrayList<AccountListVO> accountListVOs = receiptBillVO.getAccountListVOs();
		ArrayList<AccountListPO> accountListPOs = new ArrayList<>();
		for (int i = 0; i < accountListVOs.size(); i++) {
			accountListPO.setAccountID(accountListVOs.get(i).getAccountID());
			accountListPO.setMoney(accountListVOs.get(i).getMoney());
			accountListPO.setNote(accountListVOs.get(i).getNote());
			accountListPOs.add(accountListPO);
		}

		ReceiptBillPO receiptBillPO = new ReceiptBillPO(receiptBillVO.getId(), receiptBillVO.getUserID(),
				receiptBillVO.getCustomer(), receiptBillVO.getType(), receiptBillVO.getState(), accountListPOs, total,
				receiptBillVO.getNote());

		return receiptBillPO;
	}

	public ReceiptBillVO POtoVO(ReceiptBillPO receiptBillPO) {

		accountListVO = new AccountListVO("", 0.0, "");

		Double total = receiptBillPO.getTotal();
		ArrayList<AccountListPO> accountListPOs = receiptBillPO.getAccountListPOs();
		ArrayList<AccountListVO> accountListVOs = new ArrayList<>();
		for (int i = 0; i < accountListPOs.size(); i++) {
			accountListVO.setAccountID(accountListPOs.get(i).getAccountID());
			accountListVO.setMoney(accountListPOs.get(i).getMoney());
			accountListVO.setNote(accountListPOs.get(i).getNote());
			accountListVOs.add(accountListVO);
		}

		ReceiptBillVO receiptBillVO = new ReceiptBillVO(receiptBillPO.getDocID(), receiptBillPO.getUserID(),
				receiptBillPO.getCustomer(), receiptBillPO.getBillType(), receiptBillPO.getBillState(), accountListVOs,
				total, receiptBillPO.getNote());

		return receiptBillVO;

	}
}
