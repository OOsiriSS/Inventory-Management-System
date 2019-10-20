package bussinesslogicservice.memberblservice;

import java.rmi.RemoteException;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.membervo.MemberVO;

public interface MemberBLService {

	public String getId() throws RemoteException;

	public ArrayList<MemberVO> show() throws RemoteException;

	public ArrayList<MemberVO> find(String keyword, FindMemberType type) throws RemoteException;

	public ResultMessage insert(MemberVO vo) throws RemoteException;

	public ResultMessage update(MemberVO vo) throws RemoteException;

	public ResultMessage delete(String id) throws RemoteException;

	public ArrayList<String> getIDandName() throws RemoteException;

}
