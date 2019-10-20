package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.classificationvpo.ClassificationVPO;

/**
 * 
 * @author Lijie
 * @date 2018Äê1ÔÂ10ÈÕ
 */
public class ClassificationDataService_stub implements ClassificationDataService {

	@Override
	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ClassificationVPO getRoot() throws RemoteException {
		ClassificationVPO root = new ClassificationVPO("0001", "µÆ", true, null, null, null);
		return root;
	}

	@Override
	public ClassificationVPO findClassification(String name) throws RemoteException {
		ClassificationVPO root = new ClassificationVPO("0001", "µÆ", true, null, null, null);
		return root;
	}

	public String getId() throws RemoteException {
		return "00001";
	}

	@Override
	public ArrayList<ClassificationVPO> show() throws RemoteException {
		ArrayList<ClassificationVPO> list = new ArrayList<>();
		ClassificationVPO root = new ClassificationVPO("0001", "µÆ", true, null, null, null);
		list.add(root);
		return list;
	}

	@Override
	public String getID() throws RemoteException {
		return "0001";
	}

	@Override
	public ClassificationVPO findClassificationByID(String id) throws RemoteException {
		ClassificationVPO root = new ClassificationVPO("0001", "µÆ", true, null, null, null);

		return root;
	}

}
