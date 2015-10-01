import java.net.*;
import java.rmi.*;
public interface IProg extends Remote
{
     public String getHello() throws RemoteException;
}
