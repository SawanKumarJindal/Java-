/*
 * Os.java
 * 
 *
 * Version: 1.0
 
 * $Id$
 *
 * Revisions:
 * $Log$ 
 */


/**
 * This program is used to find out
 
 
 * the operating system being used.
 * 
 
 
 * @author Sawan 
 *
 */
public class Os	{
    
    /**
     *  The execution of the program begins from main().
     * @param args No command-line arguments required.
     */
    public static void main( String args[])	{
        String getOsName= System.getProperty("os.name");// This will store the OS name in String 
        System.out.println("OS:"+getOsName);// Here it will print the OS name.
    }
}
