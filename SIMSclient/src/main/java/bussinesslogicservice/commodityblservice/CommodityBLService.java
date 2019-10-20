package bussinesslogicservice.commodityblservice;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;

public interface CommodityBLService {

	public String getID(String name) throws Exception;

	public ResultMessage insert(CommodityVO vo) throws Exception;

	public ResultMessage delete(CommodityVO vo) throws Exception;

	public ResultMessage update(CommodityVO vo) throws Exception;

	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) throws Exception;

	public ArrayList<CommodityVO> show() throws Exception;

	public ArrayList<String> getIDandName() throws Exception;

	public ArrayList<String> getAllChildrenClass() throws Exception;// 返回所有无子节点或者子节点为商品的分类名称，不用带ID

	public ArrayList<CommodityStockVO> stock() throws Exception; // 库存盘点

	public ArrayList<CommodityCheckVO> check(LocalDate start, LocalDate end);

	public void exportReport(ArrayList<CommodityStockVO> commodityStockVOs);
}
