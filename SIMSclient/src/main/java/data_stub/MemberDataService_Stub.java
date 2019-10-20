package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import dataservice.memberdataservice.MemberDataService;
import po.memberpo.MemberPO;
import vo.membervo.MemberVO;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年10月22日
 */
public class MemberDataService_Stub implements MemberDataService {

	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		ArrayList<MemberPO> list = new ArrayList<>();
		MemberPO p = new MemberPO("000001", MemberCategory.RETAILER, MemberLevel.LEVEL1, "李杰", "138888888", "南京大学",
				"210046", "79@qq.com", 5000.0, "李杰");
		list.add(p);
		return list;
	}

	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		ArrayList<MemberPO> list = new ArrayList<>();
		MemberPO p = new MemberPO("000001", MemberCategory.RETAILER, MemberLevel.LEVEL1, "李杰", "138888888", "南京大学",
				"210046", "79@qq.com", 5000.0, "李杰");
		list.add(p);
		return list;
	}

}
