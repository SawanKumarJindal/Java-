/*
 * Item.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This is the base class which enlists the information regarding the items
 * that are in the cart but are not in the bags.
 *
 *@ author Sawan
 *@ author Prateek
 */
class Item 
{
    int totalNoOfItems =0;
    int appleInCart = 0;
    int flourInCart = 0;
    int kiwisInCart = 0;
    int orangeInCart = 0;
    int milkInCart = 0;
    /*
     * This function will set the value of apple in the variable.
     */
    public void setAppleInCart(int appleInCart) {
	this.appleInCart += appleInCart;
    }
    /*
     * This getter will return the value of apples from the variable.
     */
    public int getAppleInCart() {
	return appleInCart;
    }
    /*
     * This function will set the value of flour in the variable.
     */
    public void setFlourInCart(int flourInCart) {
	this.flourInCart += flourInCart;
    }
    /*
     * This getter will return the value of flour from the variable.
     */
    public int getFlourInCart() {
	return flourInCart;
    }
    /*
     * This function will set the value of kiwis in the variable.
     */
    public void setKiwisInCart(int kiwisInCart) {
	this.kiwisInCart += kiwisInCart;
    }
    /*
     * This getter will return the value of kiwis from the variable.
     */
    public int getKiwisInCart() {
	return kiwisInCart;
    }
    /*
     * This function will set the value of orange in the variable.
     */
    public void setOrangesInCart(int orangeInCart) {
	this.orangeInCart += orangeInCart;
    }
    /*
     * This getter will return the value of oranges from the variable.
     */
    public int getOrangesInCart() {
	return orangeInCart;
    }
    /*
     * This function will set the value of milk in the variable.
     */
    public void setMilkInCart(int milkInCart) {
	this.milkInCart += milkInCart;
    }
    /*
     * This getter will return the value of milk from the variable.
     */
    public int getMilkInCart() {
	return milkInCart;
    }
    /*
     * This function will return the total no of items that are in the cart but not in the bag.
     */
    public int gettotalNumberOfItems(){
    	totalNoOfItems = appleInCart + flourInCart + kiwisInCart + orangeInCart + milkInCart;
    	return totalNoOfItems;
    	
    }
}