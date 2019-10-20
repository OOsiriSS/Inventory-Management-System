package dataservice.classificationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import po.classificationvpo.ClassificationVPO;

public interface ClassificationDataService extends Remote {

	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException;

	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException;

	public ResultMessage deleteClassification(String id) throws RemoteException;

	public ClassificationVPO getRoot() throws RemoteException;

	public String getID() throws RemoteException;

	public ClassificationVPO findClassification(String name) throws RemoteException;

	public ClassificationVPO findClassificationByID(String id) throws RemoteException;

	public ArrayList<ClassificationVPO> show() throws RemoteException;

}
