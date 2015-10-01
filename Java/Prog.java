import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
public class Prog extends UnicastRemoteObject implements IProg
{
	public Prog () throws RemoteException
	{}
     public String getHello() throws RemoteException
	{
		return "Hello";
	}
}
