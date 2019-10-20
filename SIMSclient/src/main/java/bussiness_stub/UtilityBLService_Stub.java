package bussiness_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;
import po.commoditypo.CommodityPO;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public class UtilityBLService_Stub implements UtilityBLService {

	@Override
	public boolean isPrintLegal(ArrayList<String> list) {
		// TODO Auto-generated method stub
		return false;
	}

	public String generateID(BillType billType) {
		// TODO Auto-generated method stub
		return "15615156";
	}

	@Override
	public ArrayList<MessageVO> getMessage(UserVO user) {
		return null;
	}

	@Override
	public boolean hasMessage(UserVO user) {
		return false;
	}

	@Override
	public void warningMessage(CommodityPO po) throws RemoteException {
	}

	@Override
	public void saveMessage(MessageVO message) throws RemoteException {
	}

}
