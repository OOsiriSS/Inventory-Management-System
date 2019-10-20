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
	public boolean login(String userName, String passWord) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		UserPO user1 = new UserPO("000001", "sdv", "161250134", UserRole.USER_MANAGER, null);
		ArrayList<UserPO> list = new ArrayList<>();
		list.add(user1);
		return list;
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		UserPO user1 = new UserPO("000001", "Õı≤”≤”", "161250134", UserRole.PUR_SALE_MANAGER, null);
		UserPO user2 = new UserPO("000002", "¿ÓΩ‹", "161250058", UserRole.FINANCIAL_MANAGER, null);
		UserPO user3 = new UserPO("000003", "ÀÔºŒΩ‹", "161250122", UserRole.GENERAL_MANAGER, null);
		UserPO user4 = new UserPO("000004", "≈À–«”Ó", "161250095", UserRole.INVENTORY_MANAGER, null);
		ArrayList<UserPO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}
}
