/*
 * Cashier.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class contains the details of the total no of items that are purchased by the customer.
 *
 *@ author Sawan
 *@ author Prateek
 */
public class Cashier {
    public int totalApples,totalKiwis,totalFlour,totalOrange,totalMilk;
    Cart cr= Customer.cart;
    Receipt receipt=new Receipt();
    /*
     *  This function will access the total values from the cart where the total items are retrieved.
     */
    public void detailsOfCartItems(){
	totalApples=cr.getTotalApples();
	totalKiwis=cr.getTotalKiwis();
	totalFlour=cr.getTotalFlour();
	totalOrange=cr.getTotalOrange();
	totalMilk=cr.getTotalMilk();		 
    }
    /*
     * This is a getter function for total apples.
     */
    public int getTotalApples() {
	return totalApples;
    }
    /*
     * This is a getter function for total kiwis.
     */
    public int getTotalKiwis() {
	return totalKiwis;
    }
    /*
     * This is a getter function for total flour.
     */
    public int getTotalFlour() {
	return totalFlour;
    }
    /*
     * This is a getter function for total oranges.
     */
    public int getTotalOrange() {
	return totalOrange;
    }
    /*
     * This is a getter function for total milk.
     */
    public int getTotalMilk() {
	return totalMilk;
    }
    /*
     *This function will display the content to the screen.
     */
    public void displayContent()
    {
	receipt.calculatePrice();
	receipt.display();
    }
}
