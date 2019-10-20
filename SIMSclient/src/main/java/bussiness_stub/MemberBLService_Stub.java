package bussiness_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.membervo.MemberVO;

/**
 * 类说明
 *
 * @author ****
 * @date 2017年10月22日
 */
public class MemberBLService_Stub implements MemberBLService {

	public String getId() {
		return "000001";
	}

	public ArrayList<MemberVO> show() {
		MemberVO member1 = new MemberVO("00001", MemberCategory.SUPPLIER, MemberLevel.LEVEL5, "李杰", "1591515", "南京大学",
				"210064", "lq@qq.com", "50", "20", "50", "NJU");
		MemberVO member2 = new MemberVO("00002", MemberCategory.RETAILER, MemberLevel.LEVEL4, "NJU", "15cs515", "南京大学",
				"210064", "lq@qq.com", "50", "20", "50", "NJU");
		System.out.println("Show Succeed!\n");
		ArrayList<MemberVO> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		return list;
	}

	public MemberVO exactSearch(String ID) {
		System.out.println("exactSearch Succeed!\n");
		return null;
	}

	@Override
	public ArrayList<MemberVO> find(String keyword, FindMemberType properties) {
		MemberVO member1 = new MemberVO("161250001", MemberCategory.RETAILER, MemberLevel.LEVEL5, "NJU", "1591515",
				"南京大学", "210064", "lq@qq.com", "50", "20", "50", "NJU");
		System.out.println("Show Succeed!\n");
		ArrayList<MemberVO> list = new ArrayList<>();
		list.add(member1);
		return list;
	}

	@Override
	public ResultMessage insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(MemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<String> getIDandName() throws RemoteException {
		ArrayList<String> list = new ArrayList<>();
		String s1 = "李杰(00001)";
		String s2 = "王灿灿(00002)";
		list.add(s1);
		list.add(s2);
		return list;
	}

}
