package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import po.userpo.UserPO;

public interface UserDataService extends Remote {

	public boolean login(String id, String password) throws RemoteException;

	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException;

	public ResultMessage insertUser(UserPO po) throws RemoteException;

	public ResultMessage deleteUser(String ID) throws RemoteException;

	public ResultMessage updateUser(UserPO po) throws RemoteException;

	public ArrayList<UserPO> showUser() throws RemoteException;

}
