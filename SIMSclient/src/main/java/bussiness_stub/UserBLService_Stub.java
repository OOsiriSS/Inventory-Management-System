package bussiness_stub;

import java.rmi.RemoteException;

import java.util.ArrayList;

import bussinesslogicservice.userblservice.UserBLService;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import vo.uservo.UserVO;

public class UserBLService_Stub implements UserBLService {

	@Override
	public ArrayList<UserVO> find(String info, FindUserType properties) throws RemoteException {
		UserVO user1 = new UserVO("000001", "Panxy", "161250134", UserRole.INVENTORY_MANAGER, null);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		return list;
	}

	@Override
	public ResultMessage insert(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> getUserList() throws RemoteException {
		// TODO Auto-generated method stub

		UserVO user1 = new UserVO("000001", "Õı≤”≤”", "161250134", UserRole.PUR_SALE_MANAGER, null);
		UserVO user2 = new UserVO("000002", "¿ÓΩ‹", "161250058", UserRole.FINANCIAL_MANAGER, null);
		UserVO user3 = new UserVO("000003", "ÀÔºŒΩ‹", "161250122", UserRole.GENERAL_MANAGER, null);
		UserVO user4 = new UserVO("000004", "≈À–«”Ó", "161250095", UserRole.INVENTORY_MANAGER, null);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}

	@Override
	public boolean login(String userName, String passWord) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
}
