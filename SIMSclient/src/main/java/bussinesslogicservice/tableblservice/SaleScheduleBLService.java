package bussinesslogicservice.tableblservice;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.findtype.FindSaleScheduleType;
import vo.tablevo.SaleScheduleVO;

public interface SaleScheduleBLService {
	/**
	 * 导出表格
	 */
	public void exportReport(ArrayList<SaleScheduleVO> sale);

	/**
	 * 展示该全部列表
	 * 
	 * @return
	 */
	public ArrayList<SaleScheduleVO> show();

	/**
	 * 通过时间进行表格筛选
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<SaleScheduleVO> siftTime(LocalDate start, LocalDate end);

	/**
	 * 通过其他属性进行表格筛选
	 * 
	 * @param info
	 * @param type
	 * @return
	 */
	public ArrayList<SaleScheduleVO> sift(String info, FindSaleScheduleType type);

}
