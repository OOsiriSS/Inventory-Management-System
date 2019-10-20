package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ11ÈÕ
 */
public interface Sale_MemberInfo {

	public ArrayList<String> getIDandName() throws RemoteException;

	public String getSaleMan(String id) throws RemoteException;

	public void changePayable(String memberID, double afterPrice) throws RemoteException;

	public boolean isLimit(String memberID, double money) throws RemoteException;

}
