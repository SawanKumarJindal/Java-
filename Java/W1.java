
/*
 *
 * W1.java
 *
 *
 * Version: 1.0
 * 	$Id$
 *
 *
 * Revisions:
 *     $Log$
 *
 */




import java.util.Scanner;
import java.io.File;

/*
 * This program counts the number of printabe characters
 * and print them,then it prints the number of words and lines.
 * 
 * @author Sawan
 * @author Prateek
 *
 */

public class W1 
{
    
    /*
     * The main execution of the progarm starts here.
     *
     * @param args command line arguments (ignored).
     */
    public static void main( String[] args )
    {
	
	try 
	    
	    {
		
		Scanner sc  = new Scanner( new File("macbeth.txt")); // This will input the whole file in the system using Scanner inbuilt class. 
		int[] count = new int [95]; // This count array will store the frequency of no of printable chatacters .
		int value = 0;
		int word=0;
		int lineCount=0;
		for (int k=0; k<95;k++)
		    {
			count [k] = 0; // It initialises the count of each printable character to zero.
		    }
		while ( sc.hasNext() ) // This loop will keep on working until it has some text further.  
		    
		    {
			
			String line = sc.nextLine(); // It will take each line.
			for( int i=0 ; i != line.length()  ; i++ )
			    
			    {
				
				char result = line.charAt( i );
				value = ( ( int ) result - 32 );
				count [ value ] += 1;
				
				if (((int) result >=65&&(int) result<=90)||((int) result>=97&&(int) result<=122)||((int) result == 39)) // This loop will check the characters which seperate words
				    {
					continue;
				    }
				else
				    {
					word++;	
				    }
			    }
			lineCount++;
		    }
		for (int j=0;j<95;j++)
		    System.out.println( (char) (j + 32) + ":\t" + count [ j ] ); // this statement will print the frequency of each printable character.
		System.out.println("The number of words is " + word); // This will print the total number of words.
		System.out.println("The number of lines is " + lineCount); // This will print the total number of lines.
		sc.close();
		
	    }
	
	catch ( Exception e ) 
	    
	    {	
		
		System.err.println("Something went wrong!");
	    }		
	
    }
    
} // W1.java
