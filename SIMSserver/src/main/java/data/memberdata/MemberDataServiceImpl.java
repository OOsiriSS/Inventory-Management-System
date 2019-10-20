package data.memberdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import dataservice.memberdataservice.MemberDataService;
import po.memberpo.MemberPO;

public class MemberDataServiceImpl implements MemberDataService {

	private MemberData member;

	// public static void main(String[] args) throws RemoteException {
	// MemberDataServiceImpl m = new MemberDataServiceImpl();
	// MemberPO po = new MemberPO("000006", MemberCategory.SUPPLIER,
	// MemberLevel.LEVEL2, "王灿灿", "1383838438",
	// "江苏省南京区仙林大道164号", "210050", "161250059@smail", 5000, "刘钦");
	// m.insertMember(po);
	// m.deleteMember("000001");
	// ArrayList<MemberPO> list = m.findMember("刘钦", FindMemberType.SALESMAN);
	// for (MemberPO p : list) {
	// System.out.println(p.toString());
	// }
	// }

	public MemberDataServiceImpl() {
		member = new MemberData();
	}

	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		return member.insert(po);
	}

	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		return member.delete(ID);
	}

	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		return member.update(po);
	}

	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		return member.show();
	}

	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		return member.find(keyword, type);
	}

}
