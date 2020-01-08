package designpatterns.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteService extends Remote{

	public String hello() throws RemoteException;
}
