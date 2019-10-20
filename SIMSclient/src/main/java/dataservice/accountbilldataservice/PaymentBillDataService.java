package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import po.financialbillpo.PaymentBillPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
/**
 * 
 * @ClassName: PaymentBillDataService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijie
 * @date 2017年12月3日 上午11:42:48
 *
 */
public interface PaymentBillDataService extends Remote {

	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException;

	public ResultMessage deletePaymentBill(String id) throws RemoteException;

	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException;

	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException;

	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException;

}
