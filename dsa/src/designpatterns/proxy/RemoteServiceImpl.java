package designpatterns.proxy;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServiceImpl extends UnicastRemoteObject implements IRemoteService {

	protected RemoteServiceImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String hello() throws RemoteException{
		return "Hello from remote service";
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		RemoteServiceImpl remoteServiceImpl = new RemoteServiceImpl();
		Naming.rebind("helloService", remoteServiceImpl);
	}

}
