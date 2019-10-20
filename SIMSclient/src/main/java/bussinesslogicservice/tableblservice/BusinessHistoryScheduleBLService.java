package bussinesslogicservice.tableblservice;

import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.BillVO;

public interface BusinessHistoryScheduleBLService<B extends BillVO> {

	public ArrayList<B> show();

	public ArrayList<B> siftTime(LocalDate start, LocalDate end);

	public ArrayList<B> sift(String info, FindSaleScheduleType type);// 里面的商品名除外

	public void exportReport(ArrayList<B> table);

	public ArrayList<B> writeOff(ArrayList<B> table);// 红冲

	public ArrayList<B> writeOffAndCopy(ArrayList<B> table);// 红冲并复制

	public ResultMessage updateBill(B table);// 将红冲并复制的单据入账

}
