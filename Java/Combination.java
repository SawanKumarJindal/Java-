/*
 * Combination.java
 * 
 * Version:1.0
 * $ID$
 * 
 * Revisions:
 * $Log$
 */


import java.util.ArrayList;

/*
 * This program creates the possible combinations of the four 
 * inputs taken i.e a,b,c,d.
 *
 *@author Sawan
 *@author Prateek
 *
 *
 *
 */

public class Combination {
    // Execution starts from the main program
    // @param args No command line argument required
    
    public static void main(String args[])	{
	String a[]=new String[16];   // Creating a string which will take the input
	a[1]="a";
	a[2]="b";
	a[4]="c";
	a[8]="d";
	String b[]=new String[16];  // Another String which will hold the output 
	ArrayList arr=new ArrayList(); // ArrayList will print the output in a list style
	int j=1;
	arr.add("{}");  // Adding default null in the ArrayList
	for(int i=1;i<16;i++)	{
	    if(a[i]!=null){
		b[i]=a[i];  // this will input the stored values in the output string
		j=1;
	    }
	    else{
		if(a[i-1]==null){
		    j++;
		}
		b[i]=a[i-j]+b[j]; // this will input the new combination of values to the output string
	    }
	    arr.add("{"+b[i]+"}"); // this will add the output string into ArrayList
	}
	System.out.println(arr); // It will print the ArrayList
    }
}// Combination
