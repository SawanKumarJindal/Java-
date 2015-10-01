/*
 * Customer.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class is the class which is an interface to the items. It will handle all the operations 
 *regarding the no of items stored in a cart, bag, no of bags, items less or more than the capacity.
 *
 *@ author Sawan
 *@ author Prateek
 */
import java.util.Scanner;

class Customer extends AbstractClass{
    int apples, flour, kiwis, oranges, milk, totalNoOfBags = 0;
    // int[] cartArray=new int[5];
    int[] cartArray1=new int[5];
    // int[] bagArray=new int[5];
    int[] bagArray1=new int[5];
    int cartTotalValues;
    public static Cart cart;
    /*
     *This is the constructor which will handle the whole operation.
     */
    Customer(){
    	cart=new Cart();
	try{
	    Scanner sc = new Scanner(System.in);
	    cartArray1=askingCart();
	    cart.setAllValues(cartArray1[0],cartArray1[1],cartArray1[2],cartArray1[3],cartArray1[4]);
	    if(cart.getNumOfObjectInTheCart() > 50 ) // This will check whether the no of objects in the cart are exceeding the limit.
		{
		    askingCustomer();
		}
	    else{
		System.out.println("HOW MANY BAGS DO YOU HAVE"+ ":");
		totalNoOfBags =	sc.nextInt();
		cart.setBagValues(totalNoOfBags);
		// This loop will work until the no of bags that the customer wont get completed.
		// It will access all the item info. from the bag.
		for (int i = 0; i < totalNoOfBags ;i++){
		    bagArray1=askingBag(i);
		    cart.setBagItemsDetails(bagArray[0],bagArray[1],bagArray[2],bagArray[3],bagArray[4], i+1);
		}
		cartTotalValues=cart.passingValueOfBag() + cart.getNumOfObjectInTheCart();
		// This loop will check the limit of the total items in the cart.
		if( cartTotalValues > 50 ){
		    askingCustomer();
		}
	    }
	    
	}catch(Exception e)
	    {
		e.printStackTrace();
		System.out.println(e);
	    }
	
    }
    /*
     * If the limit will exceed then the cashier will ask about the new cart and that whole code is entitled in this function.
     */
    public void askingCustomer(){
    	try{
	    Scanner sc1 = new Scanner(System.in);
    	    System.out.println("You have exceeded the limit of having more than 50 items in one cart");
    	    System.out.println("Do you want to use another cart, type 1 for yes and 0 for NO");
    	    int option = sc1.nextInt();
	    // This will work if the customer wants to take another cart.
    	    if ( option == 1){
		Cart cart1 = new Cart();		
		cartArray1=askingCart();
		cart1.setAllValues(cartArray1[0],cartArray1[1],cartArray1[2],cartArray1[3],cartArray1[4]);
		// If the limit of the customer exceeds 100 it wont operate further.
		if((cart1.getNumOfObjectInTheCart()+cartTotalValues) > 100 )
		    {
			System.out.println("You Cannot carry more");
		    }
		else{
		    System.out.println("HOW MANY BAGS DO YOU HAVE"+ ":");
		    totalNoOfBags =	sc1.nextInt();
		    cart1.setBagValues(totalNoOfBags);
		    // Loop for bags for the second cart.
		    for (int i = 0; i < totalNoOfBags ;i++){
			bagArray1=askingBag(i);
			cart1.setBagItemsDetails(bagArray[0],bagArray[1],bagArray[2],bagArray[3],bagArray[4], i+1);
    			
		    }
		}
    	    }
    	} catch(Exception e){
	    e.printStackTrace();
    	}  	
    }
    
}