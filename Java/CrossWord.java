import java.awt.Point;
import java.io.File;
import java.util.Scanner;
class CrosswordSpace {
    private Point start;
    private Point direction;
    private int length;
        
    public CrosswordSpace ( Point start, Point direction, int length ) {
        this.start = start;
        this.direction = direction;
        this.length = length;
    }
    
    public Point getStart() {
        return start;
    }
    
    public Point getDirection() {
        return direction;
    }
    
    public int getLength() {
        return length;
    }
}
class CrosswordWord {
    private String word;
    private boolean used;
        
    public CrosswordWord ( String word ) {
        this.word = word;
        used = false;
   }
    public void printWord()
	{
	System.out.println(word);
	}
    
    public String getWord() {
        return word;
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public void setUsed ( boolean isUsed ) {
        used = isUsed;
    }
}

class CrossWord {


  // INSTANCE VARIABLES:
    
    // The current state of the crossword puzzle, including
    // blank squares, solid squares, and any letters we've added:
    private char[][] puzzle;
    
    // A collection of CrosswordSpace objects, each of which
    // represents a "slot" in the puzzle (like "1 Across" or
    // "2 Down"):
    private CrosswordSpace[] slots;
    
    // The words we're trying to put in the crossword puzzle.
    // Each word is encapsulated within a CrosswordWord object,
    // which also keeps track of whether or not the word has
    // already been used:
    private CrosswordWord[] words;
    
    // This array keeps track of how many words are currently
    // using each letter in the puzzle -- this is needed so
    // that we can know which letters to actually remove from
    // the puzzle when we remove a word:
    private int[][] letterUsage;
    
    // Counts the number of backtracks the algorithm performs:
    private int numBacktracks;
    
    
    // CONSTANTS: characters used for blank and solid squares
    //            in the puzzle:
    public static final char BLANK = ' ';
    public static final char FILLED = '#';
    
    
    /**
     * CrosswordSolver()
     * 
     * The constructor simply stores references to the puzzle
     * array, slots array, and words array in the instance
     * variables.
     */
    public CrossWord ( char[][] puzzle, CrosswordSpace[] slots,
                             CrosswordWord[] words ) {
        this.puzzle = puzzle;
        this.slots = slots;
        this.words = words;                  
    }
    
    /**
     * reinitialize()
     *
     * Resets the solver to prepare for a fresh call to solve()
     * by zeroing out the letterUsage array and numBacktracks
     * variable.
     */
    private void reinitialize() {
	letterUsage = new int[puzzle.length][puzzle[0].length]; 
        numBacktracks = 0;     
    }
    
    /**
     * solve()
     *
     * A public "wrapper" method for the actual recursive method,
     * fillPuzzle(). Resets the state of the solver by calling
     * reinitialize(), then makes the first call to fillPuzzle(),
     * passing in 0 to tell it to start at the first slot (slot
     * number 0). Once the recursion is finished, checks the
     * return value to determine whether or not a solution was
     * found.
     */
    public void solve() {
	reinitialize();
System.out.println("After reinitialise");
        if ( fillPuzzle(0) ) {
            System.out.println("Solution found!");
            System.out.println("Backtracks: " + numBacktracks);
        }
        else {
            System.out.println("No solution found!");
        }
    }
    
    /**
     * fillPuzzle()
     *
     * Our recursive backtracking algorithm for solving the crossword
     * puzzle. For each slot in the slots array, tries to find an
     * UNUSED word from the words array that fits. If no such word
     * is found, or all the words it's tried lead to backtracks,
     * returns false to backtrack to the previous call and tell it
     * to choose a different word. If we've filled every slot, we
     * print the solution and return true, which causes every other
     * call to also return true, bringing us back to the solve()
     * wrapper method.
     */
    private boolean fillPuzzle ( int slot ) {
    
        // If we've filled every slot, slot will be equal to
        // the length of the slots array. In that case, we are
        // done, so we print the solution and return true to
        // tell all the previous calls to also return true:
	System.out.println("fillpuzzle");    
        if ( slot == slots.length ) {
            printPuzzle();
            return true;
        }
             
        // Consider each word from the words array as a potential
        // fit for the current slot:
           
        for ( CrosswordWord word : words ) {
        System.out.println("in for loop of fillpuzzle:::"+ word.getWord());
	//	words[i].printWord();
            // If the word is UNUSED and fits in the slot given
            // its length and the letters already there from other
            // words, we place the word in the slot (marking it
            // USED in the process), and make a recursive call to
            // fill the next slot. If that call backtracks (returns
            // false), we remove the word from the slot and choose
            // a different one:
            
            if ( wordFitsInSlot(word, slots[slot]) ) {
		System.out.println("If the word fits:::"+word.getWord());
                putWordInSlot(word, slots[slot]);
		System.out.println("After putting the word::::"+word.getWord());
                
                if ( fillPuzzle(slot + 1) ) {
                    return true;
                }
                
                removeWordFromSlot(word, slots[slot]);
            }
        }
        
        // If we get here, we've tried every word in the words
        // array for this slot, and all have either not fit or 
        // lead to backtracks, so we need to backtrack as well by 
        // returning false to tell the previous call to choose a 
        // different word:
        
        numBacktracks++;
        return false;
    }

    /**
     * wordFitsInSlot()
     *
     * Returns true if the word passed to it fits into the slot
     * passed to it AND is unused, otherwise returns false.
     */
    private boolean wordFitsInSlot ( CrosswordWord w, CrosswordSpace slot ) {
    
        // If the length of the word doesn't match the length of the
        // slot, or the word is already used, we can't put this word
        // here and so we return false:
        
        if ( w.getWord().length() != slot.getLength() || w.isUsed() ) {
            return false;
        }
        
        // Otherwise we examine each position in the slot. If
        // there are letters in the slot already, and those letters
        // DON'T match the letters at the corresponding positions
        // in our word, the word won't fit and we return false:
        
        Point position = new Point(slot.getStart());
        
        for ( int i = 0; i < slot.getLength(); i++ ) {
            
            if ( puzzle[position.x][position.y] != BLANK &&
                 puzzle[position.x][position.y] != w.getWord().charAt(i) ) {
                return false;    
            }
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // If we get here, it means the word is unused, the right
        // length for the current slot, and its letters match any
        // letters already in the slot:
        
        return true;
    }
    
    /**
     * putWordInSlot()
     *
     * Puts each letter from the word it's passed into the slot 
     * it's passed, and marks the word USED. Also increments the
     * positions in the letterUsage array corresponding to the
     * slot to indicate that one more word is now using these
     * letters.
     */
    private void putWordInSlot ( CrosswordWord w, CrosswordSpace slot ) {
        Point position = new Point(slot.getStart());
             
        for ( int i = 0; i < slot.getLength(); i++ ) {         
        
            // Put each letter from the word into this slot of
            // the puzzle:
            
            puzzle[position.x][position.y] = w.getWord().charAt(i);
            
            // Record the fact that one more word is now using the
            // letter at this position:
            
            letterUsage[position.x][position.y]++;
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // Mark the word as USED:
        
        w.setUsed(true);
    }
    
    /**
     * removeWordFromSlot()
     *
     * Clears each position in the slot it's passed, but ONLY
     * those positions containing letters NOT used by any other
     * words according to the letterUsage array. Also marks
     * the word that used to be in the slot as UNUSED.
     */
    private void removeWordFromSlot ( CrosswordWord w, CrosswordSpace slot ) {
        Point position = new Point(slot.getStart());
        
        for ( int i = 0; i < slot.getLength(); i++ ) { 
        
            // One fewer word is now using the letter at this position:
            
            letterUsage[position.x][position.y]--;
                       
            // If no words are now using this letter, clear it:
            
            if ( letterUsage[position.x][position.y] == 0 ) {                                      
                puzzle[position.x][position.y] = BLANK;
            }
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // Mark the word as UNUSED -- ie., available to be placed 
        // elsewhere in the puzzle:
            
        w.setUsed(false);
    }
    
    /**
     * printPuzzle()
     *
     * Outputs the current state of the crossword puzzle.
     */  
    public void printPuzzle() {
        printPuzzleBorder();
        
        for ( int row = 0; row < puzzle.length; row++ ) {
            System.out.print("|");
            for ( int col = 0; col < puzzle[row].length; col++ ) {
                System.out.print(puzzle[row][col] + "|");
            }
            System.out.println();
        }
              
        printPuzzleBorder();
        
        System.out.println();
    }
    
    /**
     * printPuzzleBorder()
     *
     * Helper method for printPuzzle() that prints the border at
     * the top and bottom of the puzzle output.
     */
    private void printPuzzleBorder() {
        for ( int i = 0; i < puzzle[0].length * 2 + 1; i++ ) {
            System.out.print("-");
        }
        System.out.println();    
    }



    public static void main ( String[] args )
	 {
		try
		{
		Scanner sc = new Scanner( new File("h2.txt"));    
       		
        	char[][] smallPuzzle = {
           { FILLED, FILLED, FILLED, FILLED, FILLED,FILLED, BLANK, FILLED, FILLED,FILLED,FILLED,FILLED,FILLED },
           { FILLED, FILLED, FILLED, FILLED, FILLED, 'F', 'U', 'N', FILLED,FILLED,FILLED,FILLED,FILLED },
           { FILLED, FILLED, FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK,FILLED,FILLED,FILLED,FILLED},
           { FILLED,FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK,BLANK,BLANK,FILLED,FILLED,FILLED },
           { FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, FILLED, BLANK, BLANK,BLANK,BLANK,FILLED,FILLED },
           { FILLED, BLANK, BLANK, BLANK, BLANK, FILLED,FILLED,FILLED, BLANK,BLANK,BLANK,BLANK,FILLED },
           { BLANK, BLANK, BLANK, BLANK, FILLED,FILLED,FILLED,FILLED,FILLED,BLANK, BLANK, BLANK, BLANK },
           { FILLED, BLANK, BLANK, BLANK, BLANK, FILLED,FILLED,FILLED, BLANK,BLANK,BLANK,BLANK,FILLED },
           { FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, FILLED, BLANK, BLANK,BLANK,BLANK,FILLED,FILLED },
           { FILLED,FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK,BLANK,BLANK,FILLED,FILLED,FILLED },
           { FILLED, FILLED, FILLED, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK,FILLED,FILLED,FILLED,FILLED},
           { FILLED, FILLED, FILLED, FILLED, FILLED, BLANK, BLANK, BLANK, FILLED,FILLED,FILLED,FILLED,FILLED },
           { FILLED, FILLED, FILLED, FILLED, FILLED,FILLED, BLANK, FILLED, FILLED,FILLED,FILLED,FILLED,FILLED }
        				};
        
        	CrosswordSpace[] slots = {
new CrosswordSpace(new Point(0,6), new Point(1, 0), 4),
 new CrosswordSpace(new Point(1,5), new Point(1, 0), 4),
 new CrosswordSpace(new Point(1,7), new Point(1, 0), 4),

            new CrosswordSpace(new Point(2, 4), new Point(0, 1), 5),
    new CrosswordSpace(new Point(2, 4), new Point(1,0), 4),
new CrosswordSpace(new Point(2,8), new Point(1,0), 4),
      new CrosswordSpace(new Point(3, 3), new Point(0, 1), 7),
	 new CrosswordSpace(new Point(3,3), new Point(1, 0), 7),
new CrosswordSpace(new Point(3,9), new Point(1, 0), 7),
 new CrosswordSpace(new Point(4, 2), new Point(0, 1), 4),
  new CrosswordSpace(new Point(4, 2), new Point(1,0), 5),
            new CrosswordSpace(new Point(5, 1), new Point(0, 1), 4),
  new CrosswordSpace(new Point(5,1), new Point(1,0), 3),
            new CrosswordSpace(new Point(6, 0), new Point(0, 1), 4),
            new CrosswordSpace(new Point(7, 1), new Point(0, 1), 4),
            new CrosswordSpace(new Point(7,4), new Point(1, 0), 4),

            new CrosswordSpace(new Point(8, 2), new Point(0, 1), 4),
            new CrosswordSpace(new Point(8, 5), new Point(1,0), 4),
            new CrosswordSpace(new Point(9, 3), new Point(0, 1), 7),
            new CrosswordSpace(new Point(9,6), new Point(1, 0), 4),
            new CrosswordSpace(new Point(10, 4), new Point(0, 1), 5),
            new CrosswordSpace(new Point(11, 5), new Point(0, 1), 3),

            new CrosswordSpace(new Point(8,7), new Point(1,0), 4),
    new CrosswordSpace(new Point(8, 7), new Point(0, 1), 4),
 new CrosswordSpace(new Point(7,8), new Point(1,0), 4),

 new CrosswordSpace(new Point(7, 8), new Point(0, 1), 4),
new CrosswordSpace(new Point(6, 9), new Point(0, 1), 4),
  new CrosswordSpace(new Point(5, 8), new Point(0, 1), 4),
 new CrosswordSpace(new Point(5,11), new Point(1, 0), 3),
            new CrosswordSpace(new Point(4, 7), new Point(0, 1), 4),	 
            new CrosswordSpace(new Point(4,10), new Point(1, 0), 5),
		   
        			};
		int i=0;
		CrosswordWord[] words=new CrosswordWord[90000];

            	while ( sc.hasNext() )
		{

                String line = sc.nextLine();

                String line1 =line.replaceAll("'s", "");

                line1= line1.toUpperCase();

                if(line1.length() == 3 || line1.length() == 4 || line1.length() == 5 || line1.length() == 7 )

                {
	                words[i]= new CrosswordWord(line1);
			i++;
                }

             }
	
 	CrossWord s = new CrossWord(smallPuzzle, slots, words);
     //   words[1500].printWord();
	System.out.println(words.length);    
	 s.solve();
	sc.close();
    }catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
}}


