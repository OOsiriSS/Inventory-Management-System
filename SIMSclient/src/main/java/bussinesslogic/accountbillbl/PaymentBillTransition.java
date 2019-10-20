package bussinesslogic.accountbillbl;

import java.util.ArrayList;

import po.financialbillpo.EntryPO;
import po.financialbillpo.PaymentBillPO;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;

public class PaymentBillTransition {

	EntryVO entryVO;
	EntryPO entryPO;

	public PaymentBillVO POtoVO(PaymentBillPO paymentBillPO) {

		entryVO = new EntryVO("", 0.0, "");
		PaymentBillVO paymentBillVO;

		double total = paymentBillPO.getTotal();
		String accountID = paymentBillPO.getAccountID();
		ArrayList<EntryPO> entryPOs = paymentBillPO.getEntryListPO();
		ArrayList<EntryVO> entryVOs = new ArrayList<>();
		for (int i = 0; i < entryPOs.size(); i++) {
			entryVO.setEntryName(entryPOs.get(i).getEntryName());
			entryVO.setTransferAmount(entryPOs.get(i).getTransferAmount());
			entryVO.setNote(entryPOs.get(i).getNote());
			entryVOs.add(entryVO);
		}

		paymentBillVO = new PaymentBillVO(paymentBillPO.getDocID(), paymentBillPO.getUserID(),
				paymentBillPO.getCustomer(), accountID, entryVOs, total, paymentBillPO.getBillType(),
				paymentBillPO.getBillState(), paymentBillPO.getNote());

		return paymentBillVO;
	}

	public PaymentBillPO VOtoPO(PaymentBillVO paymentBillVO) {

		entryPO = new EntryPO("", 0.0, "");
		PaymentBillPO paymentBillPO;

		double total = paymentBillVO.getTotal();
		String accountID = paymentBillVO.getAccountID();
		ArrayList<EntryVO> entryVOs = paymentBillVO.getEntryListVO();
		ArrayList<EntryPO> entryPOs = new ArrayList<>();
		for (int i = 0; i < entryVOs.size(); i++) {
			entryPO.setEntryName(entryVOs.get(i).getEntryName());
			entryPO.setTransferAmount(entryVOs.get(i).getTransferAmount());
			entryPO.setNote(entryVOs.get(i).getNote());
			entryPOs.add(entryPO);
		}

		paymentBillPO = new PaymentBillPO(paymentBillVO.getId(), paymentBillVO.getUserID(), paymentBillVO.getCustomer(),
				accountID, entryPOs, total, paymentBillVO.getType(), paymentBillVO.getState(), paymentBillVO.getNote());

		return paymentBillPO;
	}
}
