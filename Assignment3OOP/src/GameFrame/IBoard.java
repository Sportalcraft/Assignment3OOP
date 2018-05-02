package GameFrame;

/**
 * This interface represent the board
 */
interface IBoard 
{
	/**
	 * check what is the size of this board
	 * @return the size if the board
	 */
	int boardSize();
	
	/**
	 * Move a tile to a the empty board, if possible
	 * @param tile The number of the tile to move
	 */
	void moveTile(int tile);
	
	/**
	 * check if the board is solved
	 * @return true if the board is solved, false otherwise
	 */
	boolean isComplete();
	
	/**
	 * get the tiles of the board in their order
	 * @return the board of tiles
	 */
	ITile[][] boardMap();
}
