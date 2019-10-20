package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.MainUI;
import rmi.RemoteHelper;

public class ClientRunner {

	private RemoteHelper remoteHelper;

	public static final double VERSION = 0.1;

	public ClientRunner() {
	}

	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://127.0.0.1:8887/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ClientRunner runner = new ClientRunner();
		// runner.test();
		runner.linkToServer();
		try {
			new MainUI().run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {
		try {
			System.out.println(remoteHelper.getUserDataService().login("000002", "admin"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
