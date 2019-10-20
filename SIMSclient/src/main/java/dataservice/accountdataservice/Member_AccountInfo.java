package dataservice.accountdataservice;
/**     
*  
* @author Lijie 
* @date 2017年12月14日    
*/

import java.util.ArrayList;

import po.memberpo.MemberPO;

public interface Member_AccountInfo {

	public void setPayable(String id, double payable); // 修改应付

	public void setReceivable(String id, double receivable); // 修改应收

	public ArrayList<MemberPO> getMembers(); // 获取全部客户数据

	public String getName(String id);

	public String getId(String id);

}
