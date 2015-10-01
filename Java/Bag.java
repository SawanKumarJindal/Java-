/*
 * Bag.java
 *
 * Versions:
 * $ Id $
 *
 * Revisions: 1.0
 * $ Log $
 *
 */
/*
 * This class contains the items that are stored in the bags. This will be the only class
 * made for handling the items in bags.
 *
 *@ author Sawan
 *@ author Prateek
 */
public class Bag {
    
    int noOfBags=0,totalNoOfItemsInBags=0;
    public int totalNoOfApples=0,totalNoOfKiwis=0,totalNoOfFlour=0,totalNoOfOrange=0,totalNoOfMilk=0;
    // This will initialise the no of bags in a particular bag.
    public void setTotalBags(int noOfBags){
	this.noOfBags = noOfBags;
    }
    int initialArray[][] = new int[50][5];
    /*
     *This function will initialise all the entities in the array to default zero.
     */
    public void initialise(){
	for(int i = 0; i < (noOfBags+1); i++){
	    for( int j = 0; j< 5 ; j++){
		initialArray[i][j]=0; 
	    }
	}
    }
    /*
     * This function will obtain the total no of apples that are in the bags.
     */
    public int getApplesFromBags(){
	totalNoOfApples = 0;
	for(int i = 1; i < (noOfBags+1); i++){
	    totalNoOfApples += initialArray[i][0];	
	}
	return totalNoOfApples;
    }
    /*
     *This function will obtain the total no of flour that are in the bags.
     */
    public int getFlourFromBags(){
	totalNoOfFlour= 0;
	for(int i = 0; i < (noOfBags+1); i++){
	    totalNoOfFlour += initialArray[i][1];
	}
	return totalNoOfFlour;
    }
    /*
     *This function will obtain the total no of kiwis that are in the bags.
     */
    public int getKiwisFromBags(){
	totalNoOfKiwis= 0;
	for(int i = 0; i < (noOfBags+1); i++){
	    totalNoOfKiwis += initialArray[i][2];
	}
	return totalNoOfKiwis;
    }
    /*
     *This function will obtain the total no of oranges that are in the bags.
     */
    public int getOrangeFromBags(){
	totalNoOfOrange = 0;
	for(int i = 0; i < (noOfBags+1); i++){
	    totalNoOfOrange += initialArray[i][3];
	}
	return totalNoOfOrange;
    }
    /*
     *This function will obtain the total no of milk that are in the bags.
     */
    public int getMilkFromBags(){
	totalNoOfMilk = 0;
	for(int i = 0; i < (noOfBags+1); i++){
	    totalNoOfMilk += initialArray[i][4];
	}
	return totalNoOfMilk;
    }
    /*
     *This function will set the total no of apples that are in the bags.
     */
    public void setApplesInBag(int applesInItem1, int bagNo) {
	initialArray[bagNo][0] += applesInItem1;
    }
    /*
     *This function will set the total no of flours that are in the bags.
     */
    public void setFlourInBag(int floursInItem1, int bagNo) {
	initialArray[bagNo][1] += floursInItem1;
    }
    /*
     *This function will set the total no of kiwis that are in the bags.
     */
    public void setKiwisInBag(int kiwisInItem1, int bagNo) {
	initialArray[bagNo][2] += kiwisInItem1;
    }
    /*
     *This function will set the total no of oranges that are in the bags.
     */
    public void setOrangesInBag(int orangesInItem1, int bagNo) {
	initialArray[bagNo][3] += orangesInItem1;
    }
    /*
     *This function will set the total no of milk that are in the bags.
     */
    public void setMilkInBag(int milkInItem1, int bagNo) {
	initialArray[bagNo][4] += milkInItem1;
    }
    /*
     *This function will get the total no of items that are in the bags.
     */
    public void totalItemsInBags(){
	for(int i = 0; i < (noOfBags+1); i++){
	    for( int j = 0; j< 5 ; j++){
		totalNoOfItemsInBags += initialArray[i][j];
	    }
	}
    }	
    /*
     *This function will return the total no of items that are in the bags.
     */
    public int getTotalNoOfItemsInBags() {
	return totalNoOfItemsInBags;
    }
}