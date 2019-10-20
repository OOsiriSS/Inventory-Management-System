package bussinesslogicservice.examineblservice;
/**
*  审批接口
* @author Lijie
* @date 2017年12月17日
*/

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import vo.billvo.BillVO;

public interface ExamineBLService<B extends BillVO> {

	public ResultMessage updateBill(B vo) throws RemoteException;

	public ResultMessage passBills(ArrayList<B> vos) throws RemoteException;

	public ResultMessage notPassBills(ArrayList<B> vos) throws RemoteException;

	public ArrayList<B> getCommitedBills() throws RemoteException;

	public ArrayList<B> find(String info, FindBillType type) throws RemoteException;// 已提交的单据

}
