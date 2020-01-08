package designpatterns.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientService {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		new ClientService().go();
	}

	private void go() throws MalformedURLException, RemoteException, NotBoundException {
		IRemoteService service = (IRemoteService) Naming.lookup("rmi://127.0.0.1/helloService");
		String hello = service.hello();
		System.out.println(hello);
	}
}
