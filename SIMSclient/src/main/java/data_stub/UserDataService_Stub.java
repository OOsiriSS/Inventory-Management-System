package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.userpo.UserPO;

public class UserDataService_Stub implements UserDataService {

	@Override
	public boolean login(String id, String password) throws RemoteException {
		System.out.println("登录成功！");
		return true;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		UserPO po = new UserPO("1", "王灿灿", "admin", UserRole.USER_MANAGER, null);
		ArrayList<UserPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		UserPO po = new UserPO("1", "王灿灿", "admin", UserRole.USER_MANAGER, null);
		ArrayList<UserPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

}
