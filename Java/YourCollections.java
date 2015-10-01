/*
 *YourCollections.java
 *
 *Version 1.0
 *   $Id$
 *
 * Revisions: 
 * $ Log$
 *
 */

import java.lang.*;
import java.util.*;

/*
 *This class implements the interface Comparator and 
 *defines the manual function compare which returns greater value.
 */
class MyComparator implements Comparator<Integer>
{
    public int compare(Integer a,Integer b)
    {
	return ((a>b)?a:b);
    }
}
/*
 *This is the main class in which we are storing the values in the list and then shuffling them 
 *using their index number and again using the same list and sort them using the described comparator 
 *which is defined above.
 *
 *@author Sawan
 *@author Prateek
 */
public class YourCollections
{
    static int size;
    static int position=0;
    static int randomNumber;
    /*
     *This is the function which will generate the random number in the range min and max.
     *This max will be equal to the size of the list and min will be the starting index.
     */
    private static int randInt(int max,int min)
    {
	Random r=new Random();
	int no=r.nextInt((max-min)+1)+min;
	return no;
    }
    /*
     *This function will swap the value in the list by accepting the random number
     *and swapping its places.
     */
    private static void swapping(int randomNumber,List l)
    {		
	Object temp,temp1;
	temp=l.get(position);
	temp1=l.get(randomNumber);
	l.set(position,temp1);
	l.set(randomNumber,temp);
	position++;
    }
    /*
     *This function will sort the list using Bubble Sort where the comparator will be 
     *using the manual function and sorting it in Descending order.
     */
    public static void sort(List l, Comparator c)
    {
	Object result;
	int k;
	// It iterates the list until the end of the list.
	for(int i=0;i<l.size();i++)
	    {
		// It will keep on track of the element which is being compared.
		for(int j=0;j<l.size()-i-1;j++)
		    {
			result=c.compare(l.get(j),l.get(j+1));
			if(result == l.get(j+1))
			    {
				l.set(j+1,l.get(j));
				l.set(j,result);
			    }
		    }
	    }
    }
    /*
     *This function will shuffle the list provided by the user by using the functions defined above.
     */	
    
    public static void shuffle( List l)
    {
	size=l.size();
	for(int k=1;k<=size;k++)
	    {	
		randomNumber=YourCollections.randInt(size-1,0);
		swapping(randomNumber,l);
	    }
    }	
    /*
     *This is the main function where the execution begins.
     *
     *@param args no command required.
     */
    public static void main(String args[])
    {
	List l=new ArrayList();
	MyComparator c=new MyComparator();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the no of values you want to shuffle:");
	int no=sc.nextInt();
	System.out.println("Enter the nos you want to shuffle:");
	// It will insert the elements in the list.
	for(int i=0;i<no;i++)
	    {
		l.add(Integer.parseInt(sc.next()));
	    }
	YourCollections.shuffle(l);
	System.out.println("Values After Shuffling");
	// It will display the elements .
	for(int i=0;i<no;i++)
	    {
		System.out.print(l.get(i)+" ");
	    }
	System.out.println();
	System.out.println("Using the same list and After Sorting in Descending order:");
	YourCollections.sort(l,c);
	for(int i=0;i<no;i++)
	    {
		System.out.print(l.get(i)+" ");
	    }
	System.out.println();
    }
}
