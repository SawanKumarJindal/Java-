import java.io.File;
import java.util.Scanner;
public class Palindrome
{
       public static boolean isPalindrome(String line, int i,int j)
    {	
		outerloop:
		if(i<j)
		{
			while((int) line.charAt(i)<97 || (int) line.charAt(i)>122)
			{
				if(i>=j)
				{
					break outerloop;
				}
				i=i+1;
			}
			while((int) line.charAt(j)<97 ||(int) line.charAt(j)>122)
			{
				if(i>=j)
				{
					break outerloop;
				}
				j=j-1;
			}
			if((int) line.charAt(i)==(int) line.charAt(j))
			{
			    i = i + 1 ; 
			    j = j - 1;
		      	   return isPalindrome(line,i,j);
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String args[])
	{
		try 
		{
			
			int count=0;
			Scanner sc  = new Scanner( new File("palindrome_1.txt"));
			while ( sc.hasNext() )
			{
				String line = sc.nextLine().trim();
				for(int i=0;i<line.length();i++)
				{
					String line1=line.toLowerCase();
					if((int) line1.charAt(i)<97 || (int) line1.charAt(i)>122)
					{continue;}
					for(int j=i+2;j<line.length();j++)
					{
						if((int) line1.charAt(j)<97 || (int) line1.charAt(j)>122)
						{continue;}	
						if(isPalindrome(line1,i,j))
						{
							count++;
							System.out.println(line.substring(i,j+1));
						}
						else
						continue;
					}

