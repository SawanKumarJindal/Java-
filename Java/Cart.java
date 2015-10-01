/*
 * Cart.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class is the reference of both the classes i.e. Bag class and Item class 
 * which gets accesed only by this class. It retrieves the information from and to both
 * the classes.
 *
 *@ author Sawan
 *@ author Prateek
 */
class Cart implements InterfaceClass{
    
    public int numOfObjectInTheCart=0,noOfBags=0,totalNoOfItemsInBags=0;
    public int totalNoOfApples,totalNoOfKiwis,totalNoOfFlour,totalNoOfOrange,totalNoOfMilk;
    Item item =  new Item();
    Bag bag = new Bag();
    /*
     *This is a function which will take the values from the customer class and pass those values
     * to the item class so that they can be saved at their particular entity.
     */
    public void setAllValues(int applesInItem1, int floursInItem1, int kiwisInItem1, int orangesInItem1, int milkInItem1 ){
	item.setAppleInCart(applesInItem1);
	item.setFlourInCart(floursInItem1);
	item.setKiwisInCart(kiwisInItem1);
	item.setOrangesInCart(orangesInItem1);
	item.setMilkInCart(milkInItem1);
    }
    /*
     * This function will transmit no of bags to the Bag class and will invoke the initialise 
     * functiion in Bag class.
     */
    public void setBagValues(int noOfBags)
    {
	bag.setTotalBags(noOfBags);
	bag.initialise();
    }
    /*
     * This function will pass the items quantity to the bag and also the bagno which will be useful
     * as bagno will work as the index where the info will be stored.
     */
    public void setBagItemsDetails(int applesInItem1, int floursInItem1, int kiwisInItem1, int orangesInItem1, int milkInItem1, int bagNo)
    {
	bag.setApplesInBag(applesInItem1, bagNo  );
	bag.setFlourInBag(floursInItem1, bagNo);
	bag.setKiwisInBag(kiwisInItem1, bagNo);
	bag.setOrangesInBag(orangesInItem1, bagNo);
	bag.setMilkInBag(milkInItem1, bagNo);
    }
    /*
     *This function will first intenally call the totalitemsInbags function and will retrieve that 
     * info from the Bag class using dot operator.
     */ 
    public void setTotalNoOfItemsInBags() {
	bag.totalItemsInBags();
	totalNoOfItemsInBags = bag.getTotalNoOfItemsInBags();
    }
    /*
     *This function will pass the total no of items in bags to the calling function.
     */
    public int passingValueOfBag(){
	setTotalNoOfItemsInBags();
	return totalNoOfItemsInBags;
    }
    /*
     * This is a setter function which will set the total no of values in the item class.
     */
    public void setNumOfObjectInTheCart() {
	numOfObjectInTheCart=item.gettotalNumberOfItems();
    }
    /*
     *This function will pass the total no of items in cart to the calling function. 
     */
    public int getNumOfObjectInTheCart() {
	setNumOfObjectInTheCart();
	return numOfObjectInTheCart;
    }
    /*
     * This will set the total no of apples in the cart.
     */
    public void setTotalApples(){
	totalNoOfApples=item.getAppleInCart() + bag.getApplesFromBags(); 
    }
    /*
     * This will set the total no of flour in the cart.
     */
    public void setTotalFlour(){
	totalNoOfFlour=item.getFlourInCart() + bag.getFlourFromBags();  
    }
    /*
     * This will set the total no of kiwis in the cart.
     */
    public void setTotalKiwis(){
	totalNoOfKiwis=item.getKiwisInCart() + bag.getKiwisFromBags();  
    }
    /*
     * This will set the total no of oranges in the cart.
     */
    public void setTotalOrange(){
	totalNoOfOrange=item.getOrangesInCart() + bag.getOrangeFromBags();  
    }
    /*
     * This will set the total no of milk in the cart.
     */
    public void setTotalMilk(){
	totalNoOfMilk=item.getMilkInCart() + bag.getMilkFromBags();  
    }
    /*
     *This function will pass the total no of apples in cart to the calling function. 
     */
    public int getTotalApples() {
	setTotalApples();
	return totalNoOfApples;
    }
    /*
     *This function will pass the total no of kiwis in cart to the calling function. 
     */
    public int getTotalKiwis() {
	setTotalFlour();
	return totalNoOfKiwis;
    }
    /*
     *This function will pass the total no of flour in cart to the calling function. 
     */
    public int getTotalFlour() {
	setTotalKiwis();
	return totalNoOfFlour;
    }
    /*
     *This function will pass the total no of oranges in cart to the calling function. 
     */
    public int getTotalOrange() {
	setTotalOrange();
	return totalNoOfOrange;
    }
    /*
     *This function will pass the total no of milk in cart to the calling function. 
     */
    public int getTotalMilk() {
	setTotalMilk();
	return totalNoOfMilk;
    }
}
