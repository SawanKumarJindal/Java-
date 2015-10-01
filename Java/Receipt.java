/*
 * Receipt.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class contains the function which will generate the receipt.
 *
 *@ author Sawan
 *@ author Prateek
 */
class Receipt {
    float completePrice=0;
    Cart cr= Customer.cart;
    /*
     * This function will calculate the total price of objects that is bought by the customer.
     */
    public void calculatePrice(){
	completePrice= (float)((cr.getTotalApples() * (0.50)) + (cr.getTotalFlour() * (0.7)) +(cr.getTotalKiwis() * ( 0.7)) +( cr.getTotalOrange() * (0.7)) + (cr.getTotalMilk() * ( 0.33))); 
    	
    }
    /*
     * This is the display function which will print the values to the screen.
     */
    public void display()
    {
	System.out.println("apple: " + cr.getTotalApples()+ "  (0.50)" );
	System.out.println("flour: " + cr.getTotalFlour()+ "  (0.70)" );
	System.out.println("kiwi: " + cr.getTotalKiwis()+ "  (0.70)" );
	System.out.println("orange: " + cr.getTotalOrange()+ "  (0.70)" );
	System.out.println("milk: " + cr.getTotalMilk()+ "  (0.33)" );
	System.out.println("----------------------");
	System.out.println("cost: " + completePrice);
    }
    
}
