package bussinesslogic.memberbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import dataservice.memberdataservice.MemberDataService;
import po.memberpo.MemberPO;
import rmi.RemoteHelper;
import vo.membervo.MemberVO;

/**
 *
 * @author Lijie
 * @date 2017Äê12ÔÂ13ÈÕ
 */
public class MemberController implements MemberBLService {

	private MemberDataService service;
	private MemberTransition transition;

	public MemberController() {
		service = RemoteHelper.getInstance().getMemeberDataService();
		transition = new MemberTransition();
	}

	@Override
	public String getId() throws RemoteException {
		ArrayList<MemberPO> list = service.showMember();
		ArrayList<Integer> IDList = new ArrayList<>();
		if (list != null && list.size() != 0) {
			for (MemberPO po : list) {
				IDList.add(Integer.parseInt(po.getId()));
			}
			Collections.sort(IDList);
			String id = String.valueOf(IDList.get(IDList.size() - 1) + 1);
			StringBuilder sb = new StringBuilder(id);
			int len = id.length();
			for (int i = 0; i < 6 - len; i++) {
				sb.insert(0, "0");
			}
			return sb.toString();
		} else
			return "000001";
	}

	@Override
	public ArrayList<MemberVO> show() throws RemoteException {
		ArrayList<MemberVO> list = new ArrayList<>();
		ArrayList<MemberPO> poList = service.showMember();
		MemberVO vo = null;
		for (MemberPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public ArrayList<MemberVO> find(String keyword, FindMemberType type) throws RemoteException {
		ArrayList<MemberVO> list = new ArrayList<>();
		ArrayList<MemberPO> poList = service.findMember(keyword, type);
		MemberVO vo = null;
		for (MemberPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public ResultMessage insert(MemberVO vo) throws RemoteException {
		return service.insertMember(transition.VOtoPO(vo));
	}

	@Override
	public ResultMessage update(MemberVO vo) throws RemoteException {
		return service.updateMember(transition.VOtoPO(vo));
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		return service.deleteMember(id);
	}

	@Override
	public ArrayList<String> getIDandName() throws RemoteException {
		ArrayList<MemberVO> list = show();
		ArrayList<String> result = new ArrayList<>();
		for (MemberVO vo : list) {
			result.add(vo.getName() + "(" + vo.getID() + ")" + "(" + vo.getCategory().value + ")");
		}
		return result;
	}

}
