/*
 *GrepCommand.java
 *
 *Version 1.0
 *   $Id$
 *
 * Revisions: 
 * $ Log$
 *
 */

/*
 *This program prints the file name which will contain the user defined string 
 *in the directory and will print it in the specified pattern.
 *It is a grep command which is generally used in UNIX.
 * 
 * @author Sawan
 * @author Prateek
 */
import java.util.Scanner;
import java.io.File;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/*
 *This is the main class in which the main implementation
 *of command and its structure is done.
 * 
 */
class GrepCommand
{
    public static String SearchingWord;
    public static String SearchingDirectory;
    /*
     *This is the method which will perform the recursive loop if the authorised
     *location assigned by the user is a directory not a single file. In this case, it will
     *recursively iterate over all the folders containing the files and then it will check 
     *whether the file can be executed or not. If not then it will search for the word in it. 
     */
    public static void SearchInTheFile(File x) 
    {
	// This for loop will iterate over all the files present in the folder.
	for ( File i : x.listFiles()) 
	    {
		//This statement will check if the current location is a directory or a file.
		//If yes, then it will perform the recursive operation.
		if (i.isDirectory()==true) 
		    {
			SearchInTheFile(i);
		    } 
		// This will check for the word present in the file.	
		if(i.canExecute() == false) 
		    {
			containsWord(i);
		    }
	    }
    }
    /*
     *This is the core method of the program which will check
     *whether the word is contained in the file or not.
     */
    public static void containsWord(File x)
    {
	char checkChar;
	boolean a = false;
	String check = "";
	String tem="";
	int p ;
	try
	    {  
		// This will input the file to checked using FileInputStream.
		FileInputStream f = new FileInputStream(x);
		BufferedReader br = new BufferedReader(new InputStreamReader(f));	
		//This while loop which continue to execute the statements until the content in the file is readable.
		while((p = br.read()) != -1)
		    {
			checkChar = (char) p;
			//This if statement will check if the non-executable file contains the characters that are binary and not tab and spaces. 
			if (p < 32 && p != 9 && p != 10)
			    {
				a = true;
			    }
			// This statement will check if the character is new line then it will check the new line.
			else if(p == 10) 
			    {
				for(int i = 0 ; i <= (check.length() - SearchingWord.length()) ; i++)
				    {
					tem=check.substring(i , i+ SearchingWord.length());
					if(tem.equals(SearchingWord))
					    {
						if(a == false)
						    {	
							System.out.println(check);
						    }
						else
						    {
							System.out.println("File " + x.getCanonicalFile() +" matches");
							return;	
						    }
						break;
					    }	
				    }
				check = "";
			    } 	
			else
			    {
				check = check + checkChar; 
			    }
		    }
	    }
	catch(Exception e)
	    {
		System.out.println(e);
	    }
    }
    /*
     * This is the main function where the execution begins.
     *
     *@param args no command line.
     */
    public static void main(String[] args)
    {
	try
	    {
		File x =null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the word");
		SearchingWord = sc.next();
		System.out.println("Enter the directory");
		SearchingDirectory=sc.next();
		// It will check whether the user prescribed directory is current directory.
		if(SearchingDirectory.equals("."))
		    {
			x = new File(".");
		    }
		// This statement will execute the find command in the specified directory.
		else
		    {	
			x = new File(SearchingDirectory);	
		    }
		SearchInTheFile(x);
	    }
	catch(Exception e)
	    {
		System.out.println(e);
	    }
    }
}
