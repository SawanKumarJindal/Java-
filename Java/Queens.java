public class Queens {
      // squares per row or column
      public static final int BOARD_SIZE = 8; 

      // used to indicate an empty square
      public static final int EMPTY = 0; 

      // used to indicate square contains a queen
      public static final int QUEEN = 1; 

      private int board[][]; // chess board
      public Queens() {
      // -------------------------------------------------
      // Constructor: Creates an empty square board.
      // -------------------------------------------------
        board = new int[BOARD_SIZE][BOARD_SIZE];
      }  // end constructor         

      public void clearBoard() {
      // -------------------------------------------------
      // Clears the board.
      // Precondition: None.
      // Postcondition: Sets all squares to EMPTY.
      // -------------------------------------------------
        //loops through rows
          for (int i = 0; i < BOARD_SIZE; i++){
              //loops through columns
            for (int j = 0; j <BOARD_SIZE; j++){
                board[i][j] = EMPTY;
            }
        }
      }  // end clearBoard

      public void displayBoard() {
      // -------------------------------------------------
      // Displays the board.
      // Precondition: None.
      // Postcondition: Board is written to standard 
      // output; zero is an EMPTY square, one is a square 
      // containing a queen (QUEEN).
      // -------------------------------------------------

          for (int i = 0; i < BOARD_SIZE; i++){
              System.out.println("");

            for (int j = 0; j <BOARD_SIZE; j++){
                System.out.print(board [i][j] + " ");
            }
          }
      } // end displayBoard

      public boolean placeQueens(int column) {
      // -------------------------------------------------
      // Places queens in columns of the board beginning 
      // at the column specified.
      // Precondition: Queens are placed correctly in 
      // columns 1 through column-1.
      // Postcondition: If a solution is found, each 
      // column of the board contains one queen and method 
      // returns true; otherwise, returns false (no 
      // solution exists for a queen anywhere in column 
      // specified).
      // -------------------------------------------------
        if (column > BOARD_SIZE) {
          return true;  // base case
        } 
        else {
          boolean queenPlaced = false;
          int row = 1;  // number of square in column

          while ( !queenPlaced && (row < BOARD_SIZE) )  {
            // if square can be attacked
            if (isUnderAttack(row, column)) {
              ++row;  // consider next square in column
            } // end if
            else { // place queen and consider next column
              setQueen(row, column);
              queenPlaced = placeQueens(column+1);
              // if no queen is possible in next column,
              if (!queenPlaced) {
                // backtrack: remove queen placed earlier
                // and try next square in column
                removeQueen(row, column);
                ++row;
              } // end if
            } // end if
          } // end while
          return queenPlaced;
        } // end if
      } // end placeQueens

      private void setQueen(int row, int column) {
      // --------------------------------------------------
      // Sets a queen at square indicated by row and 
      // column.
      // Precondition: None.
      // Postcondition: Sets the square on the board in a 
      // given row and column to QUEEN.
      // --------------------------------------------------
        board [row][column] = QUEEN;
      }  // end setQueen

      private void removeQueen(int row, int column) {
      // --------------------------------------------------
      // Removes a queen at square indicated by row and
      // column.
      // Precondition: None.
      // Postcondition: Sets the square on the board in a 
      // given row and column to EMPTY.
      // --------------------------------------------------
        board [row][column] = EMPTY;
      }  // end removeQueen

      private boolean isUnderAttack(int row, int column) {
      // --------------------------------------------------
      // Determines whether the square on the board at a 
      // given row and column is under attack by any queens 
      // in the columns 1 through column-1.
      // Precondition: Each column between 1 and column-1 
      // has a queen placed in a square at a specific row. 
      // None of these queens can be attacked by any other
      // queen.
      // Postcondition: If the designated square is under 
      // attack, returns true; otherwise, returns false.
      // --------------------------------------------------
          //i = rows and j = columns
          //----------------------------------------
          //
          // Checks before and after square
          //
          //----------------------------------------

          //looks behind for queens
          for (int j = 0; j < column; j++){
            if (board[row][j] == QUEEN)
                return true;
        }
        //looks in front for queens
        for (int j =column+1; j < BOARD_SIZE; j++){
            if(board[row][j] == QUEEN)
                return true;
        }
        //-----------------------------------------------------------------
        //
        // Checks diagonally from square
        //
        //-----------------------------------------------------------------
        for (int i = 1+row, j = 1+column; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++){
            if (board[i][j] == QUEEN)
                return true;
        }
        for (int i= 1-row, j = 1-column; i >= 0 && j >=0; i--, j--){
            if (board[i][j] == QUEEN)
                return true;
        }
        for (int i= 1+row, j = 1-column; i < BOARD_SIZE && j >= 0; i++, j--){
            if (board[i][j] == QUEEN)
                return true;
        }
        for (int i= 1-row, j = 1+column; i >= 0 && j < BOARD_SIZE; i--, j++){
            if (board[i][j] == QUEEN)
                return true;
        }
        return false;
      }  // end isUnderAttack

      private int index(int number) {
      // --------------------------------------------------
      // Returns the array index that corresponds to
      // a row or column number.
      // Precondition: 1 <= number <= BOARD_SIZE.
      // Postcondition: Returns adjusted index value.
      // --------------------------------------------------
        return number -1;
      }  // end index
    }
}
} 
public static void main(String args[])
{
	Queens();
	clearBoard();
	displayBoard();
}

