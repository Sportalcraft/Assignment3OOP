/**
 * This interface represent the board
 */
public interface IBoard 
{
	/**
	 * check what is the size of this board
	 * @return the size if the board
	 */
	int boardSize();
	
	/**
	 * Move a tile to a given place
	 * @param tileNum The number of the tile to move
	 * @param newPos The new position of the tile
	 */
	void moveTile(int tileNum, int newPos);
	
	/**
	 * check if the board is solved
	 * @return true if the board is solved, false otherwise
	 */
	boolean isComplete();
	
	/**
	 * get the amount of moves that were made in this board
	 * @returnThe amount of moves that were made in this board
	 */
	int moves();
}
