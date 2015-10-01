import java.net.*;
import java.rmi.*;
public class SProg
{
	public static void main(String args[]) throws Exception
	{
		try{
		IProg obj=new Prog();
		Naming.rebind("rmi://localhost//abc",obj);
		}
		catch(Exception e){
		System.out.println(e);}
	}
	}
