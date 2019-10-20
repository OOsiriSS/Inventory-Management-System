package data.classificationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.classificationvpo.ClassificationVPO;

/**
 *
 * @author Lijie
 * @date 2017Äê12ÔÂ14ÈÕ
 */
public class ClassificationDataServiceImpl implements ClassificationDataService {

	private ClassificationData classfication;

	public ClassificationDataServiceImpl() {
		classfication = new ClassificationData();
	}

	@Override
	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException {
		return classfication.insert(po);
	}

	@Override
	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException {
		return classfication.update(po);
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		return classfication.delete(id);
	}

	@Override
	public ClassificationVPO getRoot() throws RemoteException {
		return classfication.getRoot();
	}

	@Override
	public ClassificationVPO findClassification(String keyword) throws RemoteException {
		return classfication.findClassification(keyword);
	}

	@Override
	public ArrayList<ClassificationVPO> show() throws RemoteException {
		return classfication.show();
	}

	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return classfication.getID();
	}

	@Override
	public ClassificationVPO findClassificationByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return classfication.findClassificationByID(id);
	}

}
