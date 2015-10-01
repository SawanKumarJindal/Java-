/*
 * Board.java
 * 
 * Version: 1.0
 * $ID$
 * 
 * Revisions:
 * $Log$
 */

/*
 * This program counts the number of kings that can be placed on a 10*10 board 
 * without threatening each other
 */
public class Board {
    //Execution starts from the main program
    //@param args No command line argument required
    static String board [][]; //Creating a static array to initialize the board
    static String green[][];  //Creating a static array to initialize the positions of previously placed kings	
    static int count=0;
    static int k;
    static int l;
    // This function initializes all the white and green boxes on the board
    public static void White()
    {
	board=new String[10][10];
	green=new String[10][10];
	board[0][4]=board[0][5]=board[1][1]=board[1][2]=board[1][3]="W";
	board[1][4]=board[1][5]=board[1][6]=board[1][7]=board[1][8]="W";
	board[4][0]=board[4][4]=board[4][5]=board[4][9]=board[5][0]="W";
	board[5][4]=board[5][5]=board[5][9]=board[8][1]=board[8][2]="W";
	board[8][3]=board[8][4]=board[8][5]=board[8][6]=board[8][7]="W";
	board[8][8]=board[9][4]=board[9][5]="W";
	
	green[3][3]=green[3][6]=green[6][6]=green[6][3]="G";
	
    }
    //This function will convert all the neighbors of a green box into white boxes
    public static void Green()
    {
	for(int i=0;i<10;i++)
	    {
		for(int j=0;j<10;j++)
		    {
			if(green[i][j]=="G")
			    {
				board[(i-1)<0?0:(i-1)][(j-1)<0?0:(j-1)]="W";
				board[(i-1)<0?0:(i-1)][j]="W";
				board[(i-1)<0?0:(i-1)][(j+1)>9?9:(j+1)]="W";
				board[i][(j-1)<0?0:(j-1)]="W";
				board[i][j]="W";
				board[i][(j+1)>9?9:(j+1)]="W";
				board[(i+1)>9?9:(i+1)][(j-1)<0?0:(j-1)]="W";
				board[(i+1)>9?9:(i+1)][j]="W";	
				board[(i+1)>9?9:(i+1)][(j+1)>9?9:(j+1)]="W";
			    }
		    }
	    }
    }
    //This function will determine where a king can be placed without breaking the given rules
    public static void PlacingAKing(int k, int l)
    {
	
	for(int i=0 ;i<=9;i++)
	    {
		for(int j=0;j<=9;j++)
		    {
			if(board[i][j]=="W")
			    {
				continue;
			    }
			else
			    {
				green[i][j]="G";
				Green();
			    }
		    }
	    }
	
    }
    // This is the main function where execution begins
    // 
    // @param args No command args required
    
    public static void main(String args[])
    {
	White(); // This will initialise the white boxes
	Green(); // This will convert the neighbors of king into white boxes 
	PlacingAKing(0,0); // This method will determine the kings position
	
	for(int i=0;i<10;i++)
	    {
		for(int j=0;j<10;j++)
		    {
			if(green[i][j]=="G")	{
			    count++;
			}
		    }
	    }
	System.out.println(count-4); // This will print out the number of kings placed
    }
    
}//Board
