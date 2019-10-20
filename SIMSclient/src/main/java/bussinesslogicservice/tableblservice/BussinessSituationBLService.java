package bussinesslogicservice.tableblservice;

import java.time.LocalDate;
import java.util.ArrayList;

import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

public interface BussinessSituationBLService {

	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive);

	public ArrayList<PaymentTableVO> showPay();

	public ArrayList<ReceiveTableVO> showReceive();

	public ArrayList<PaymentTableVO> siftPay(LocalDate start, LocalDate end);

	public ArrayList<ReceiveTableVO> siftReceive(LocalDate start, LocalDate end);

}
