/*
 * Store.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class is the main class which will execute every operation.
 *
 *@ author Sawan
 *@ author Prateek
 */
public class Store {
    /*
     * This is the main function from where the execution begins.
     *
     * @param args no command line.
     */
    public static void main(String args[]){
	Customer cust = new Customer();
	Cashier cash = new Cashier();
	cash.detailsOfCartItems();
	cash.displayContent();
    }
    
}
