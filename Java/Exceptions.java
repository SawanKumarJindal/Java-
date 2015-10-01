/*
*Exceptions.java
*
*Version: 1.0
* $Id$
*
* Revisions:
* $Log$
*/

/*
*This program prints all the Exceptions i.e. Checked, runTime and Error.
* 
* @author Sawan
* @author Prateek
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
*  This class is defined to produce FILENOTFOUND Exception by taking a file that is not present.
*/
class FileNot extends Exception

{

  public  FileNot() {

try {

Scanner sc  = new Scanner( new File("text.txt"));

while ( sc.hasNext() ){

String line = sc.nextLine();

}

sc.close();

} catch ( FileNotFoundException e )	{

e.printStackTrace();

  }


  }

}

/*
*This class is defined to produce ARITHMETIC Exception by dividing the number by zero.
*/
class DivideByZero extends Exception

{

  public  DivideByZero() {

try {

int a=10;

int b=0,c;

c= a/b;

} catch ( ArithmeticException e )	{

e.printStackTrace();

  }


  }

}

/*
*This class is made in order to produce a user defined error and throw that exception.
*/
class PassingMarks

{

public PassingMarks(int m1,int m2,int m3)

{

try

{

int sub1,sub2,sub3;

sub1=m1;

sub2=m2;

sub3=m3;

if(sub1 < 85 || sub2 <85 ||sub3 < 85)

throw new Error("Error occured! Please clear the brige courses before going forward");

else

System.out.println("Congrts! you have cleared the bridge courses");

}

catch(Error e)

{

System.out.println(e);

}

}

}
/*
*This class is defined in such a way that it produces ARRAYINDEXOUTOFBOUNDS Exception.
*/
class ArrayIndex
{
	public ArrayIndex()
	{
		try
{
  int array[] = { 0, 1, 4, 5, 6 };
          int num = array[11];
        
	}

catch(Exception e)
{
e.printStackTrace();
}
}
}	
// This is the main class which will call all the exceprion containing classes.
public class Exceptions {

// this is the main method from where the execution begins.
public static void main( String[] args ) throws IOException{

try{

PassingMarks pass = new PassingMarks(21,987,245);

FileNot exception = new FileNot();

DivideByZero divide =new DivideByZero();
ArrayIndex ai=new ArrayIndex();

} catch(Exception e){

System.out.println("hello");

}

    }

}
