package bussinesslogic.userbl;

import java.rmi.RemoteException;

import java.util.ArrayList;
import bussinesslogicservice.userblservice.UserBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.uservo.UserVO;

public class UserController implements UserBLService {

	private UserDataService service;

	public UserController() {
		super();
		service = RemoteHelper.getInstance().getUserDataService();
	}

	/**
	 * 登录的用户名及密码判断
	 * 
	 * @throws RemoteException
	 */
	@Override
	public boolean login(String id, String passWord) throws RemoteException {
		return service.login(id, passWord);
	}

	@Override
	public ResultMessage insert(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.insertUser(voTopo(vo));
	}

	@Override
	public ResultMessage delete(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.deleteUser(vo.getID());
	}

	@Override
	public ResultMessage update(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updateUser(voTopo(vo));
	}

	@Override
	public ArrayList<UserVO> find(String info, FindUserType properties) throws RemoteException {
		ArrayList<UserVO> voList = new ArrayList<>();
		ArrayList<UserPO> poList = service.findUser(info, properties);
		for (int i = 0; i < poList.size(); i++)
			voList.add(poTovo(poList.get(i)));
		return voList;
	}

	@Override
	public ArrayList<UserVO> getUserList() throws RemoteException {
		ArrayList<UserVO> voList = new ArrayList<>();
		ArrayList<UserPO> poList = service.showUser();
		for (int i = 0; i < poList.size(); i++)
			voList.add(poTovo(poList.get(i)));
		return voList;
	}

	public UserPO voTopo(UserVO vo) {
		UserPO po = new UserPO(vo.getID(), vo.getName(), vo.getPassword(), vo.getRole(), vo.getImage());
		return po;

	}

	public UserVO poTovo(UserPO po) {
		UserVO vo = new UserVO(po.getID(), po.getName(), po.getPassword(), po.getRole(), po.getImage());
		return vo;

	}

}
