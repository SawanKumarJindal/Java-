/*
 * AbstractClass.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class contains the abstract methods which can contain its body.
 *
 *@ author Sawan
 *@ author Prateek
 */
import java.util.Scanner;
public abstract class AbstractClass {
    // Two arrays which will contain the values returned by the functions.
    int[] bagArray=new int[5];  
    int[] cartArray=new int[5];
    /*
     *This is an abstract method which will return the user values of items in the bag.
     * It will take input from the user itself and will return the array.
     */
    public  int[] askingBag(int i){
	try{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("How many items do you have in Bag"+(i+1)+":");
	    System.out.print("Apples: ");
	    bagArray[0]=sc.nextInt();
	    System.out.print("Flour: ");
	    bagArray[1]=sc.nextInt();
	    System.out.print("Kiwis: ");
	    bagArray[2]=sc.nextInt();
	    System.out.print("Oranges: ");
	    bagArray[3]=sc.nextInt();
	    System.out.print("Milk: ");
	    bagArray[4]=sc.nextInt();
	} catch(Exception e){
	    e.printStackTrace();
	} return bagArray; 	
    }
    /*
     *This is an abstract method which will return the user values of items in the cart but not in the bag.
     * It will take input from the user itself and will return an array.
     */
    public int[] askingCart(){
	try{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("How many items do you have in cart");
	    System.out.print("Apples: ");
	    cartArray[0]=sc.nextInt();
	    System.out.print("Flour: ");
	    cartArray[1]=sc.nextInt();
	    System.out.print("Kiwis: ");
	    cartArray[2]=sc.nextInt();
	    System.out.print("Oranges: ");
	    cartArray[3]=sc.nextInt();
	    System.out.print("Milk: ");
	    cartArray[4]=sc.nextInt();
	} catch(Exception e){
	    e.printStackTrace();
	} return cartArray; 	
    }
    
}
