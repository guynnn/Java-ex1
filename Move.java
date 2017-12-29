/**
 * The Move class a move each player make during a nim-game match. a move instance has the desired row, and
 * the left and right bounds.
 */
public class Move {

    /** the row that the player wants to make a move on **/
    int row;
    /** the left bound in the row that the player wants to make a move on **/
    int left;
    /** the right bound in the row that the player wants to make a move on **/
    int right;

    /**
     * creates a new Move object
     * @param inRow the row to make a move on.
     * @param inLeft the left bound of the move.
     * @param inRight the right bound of the move.
     */
    public Move(int inRow, int inLeft, int inRight){
        row = inRow;
        left = inLeft;
        right = inRight;
    }

    /**
     * @return a String representation on the Move.
     */
    public String toString(){
        return row + ":" + left + "-" + right;
    }

    /**
     * @return the row of the move.
     */
    public int getRow(){
        return row;
    }

    /**
     * @return the left bound in the row of the move.
     */
    public int getLeftBound(){
        return left;
    }

    /**
     * @return the right bound in the row of the move.
     */
    public int getRightBound(){
        return right;
    }
}
