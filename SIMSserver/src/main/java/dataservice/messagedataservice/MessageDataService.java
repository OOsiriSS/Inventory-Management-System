package dataservice.messagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import po.messagepo.MessagePO;
import po.userpo.UserPO;

public interface MessageDataService extends Remote {

	public ResultMessage save(MessagePO message) throws RemoteException;

	public ArrayList<MessagePO> getMessage(UserPO user) throws RemoteException;

	public String getMessageID() throws RemoteException;

}
