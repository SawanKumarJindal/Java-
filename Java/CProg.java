import java.net.*;
import java.rmi.*;
public class CProg
{
	public static void main(String args[]) throws Exception
	{
		try{
			IProg obj=(IProg) Naming.lookup("rmi://localhost//abc");
			System.out.println(obj.getHello());
}
		catch(Exception e){
		System.out.println(e);}
	}
	}
