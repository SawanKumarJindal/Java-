/*
 *
 * Center.java
 *
 * Version: 1.0
 * $Id$
 *
 * Revisions:
 * $Log$
 *
 */

/*
 * This program finds the center objects of all the objects.
 * 
 *@author Sawan
 *@author Prateek
 */

import java.io.*;
import java.util.Scanner;
import java.lang.*;
// This is the main class where the calculation is done.
class Center
{
    /* This is the calculation function in which the distance between
     * two points is calculated.
     */
    public static double distance(int x, int x1, int y,int y1,int z,int z1)
    {
	double d=Math.sqrt(Math.pow((x - x1), 2) + Math.pow((y - y1), 2) + Math.pow((z - z1), 2));
	return d;
    }
    /* This is the main function where execution begins
     *
     *@param args no command agrs reqiured
     */
    public static void main( String[] args )
    {
	try {
	    Scanner sc  = new Scanner( new File("file.txt"));
	    double temp,temp1=1000000.000000;
	    int arr[]=new int[3];
	    int x1 = 0;
	    int y1=0;
	    int z1=0;
	    
	    while ( sc.hasNext() ) //It will check whether there is more data.
		{
		    
		    
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    int z=sc.nextInt();
		    Scanner sc1 = new Scanner(new File("file.txt")); // Creating another Scanner object.
		    temp = 0;
		    while(sc1.hasNext())
			{
			    x1=sc1.nextInt();
			    y1=sc1.nextInt();
			    z1=sc1.nextInt();
			    temp = temp + distance(x,x1,y,y1,z,z1);
			    
			}
		    if(temp1>=temp) // It will compare the values of distances and they save that in the variable
			{	
			    temp1=temp;
			    arr[0]=x;
			    arr[1]=y;
			    arr[2]=z;
			}
		    sc1.close();		
		}
	    System.out.println("Minimum Disatnce:"+temp1);
	    System.out.println("x: "+arr[0]+" y: "+arr[1]+ " z: " + arr[2]);
	    sc.close();
	    
	} 
	catch ( Exception e )
	    {
		System.err.println("Something went wrong!");
	    }
    }
}
// Center.java
