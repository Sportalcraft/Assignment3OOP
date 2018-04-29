/**
 * This class represent a board
 */
public class Board implements IBoard
{
	/**
	 * The size of the board is sizeXsize
	 */
	private int _size;
	
	/**
	 * holds the tiles if this board
	 */
	private ITile[][] _boardMatrix;
	
	/**
	 * The amount of moves that were made on this board
	 */
	private int _moves; 
	
	public Board(int size, ITile[][] tiles){
		_size = size;
		_boardMatrix = tiles;
		_moves = 0;
	}
	
	@Override
	public int boardSize() {
		return _size;
	}

	@Override
	public void moveTile(int tileNum, int newPos) {
		
		if(!canMove(tileNum, newPos))
			throw new IllegalArgumentException("This operation could not be done!");
		
		getTile(tileNum).moveTo(newPos);
		_moves++; // A move was made
	}

	@Override
	public boolean isComplete() {
		
		int size =  boardSize();
		
		if( _boardMatrix[size][size] != null)
			return false; //EmtptyTile no in right-down corner
		
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j< size; j++)
			{
				ITile tile = _boardMatrix[i][j];
				
				if(i != size | j != size) // not The Empty Tile
				{
					if(!tile.isInPlace())
						return false;
				}
			}
		}
		
		return true; // All tiles in place
	}

	@Override
	public int moves() {
		return _moves;
	}
	
	/**
	 * gett the tile with the given position
	 * @param num the position of the tile
	 * @return the tile at the given position
	 */
	private ITile getTile(int num){
		
		int tRow = 	num/boardSize();
		int tCol = 	num%boardSize();
		
		return _boardMatrix[tRow][tCol];
	}
	
	/**
	 * Check if a given position is the place that have no tile in it
	 * @param pos the position to check
	 * @return true if this position is not occupied by any tile, false otherwise
	 */
	private boolean isTheEmptyTile(int pos){
		return getTile(pos) == null;
	}
	
	/**
	 * check if a tile can be move from old place to a new place
	 * @param oldPos the current position of the tile
	 * @param newPos the position to move the tile to
	 * @return true if the transition can be done
	 */
	private  boolean canMove(int oldPos, int newPos){	
		
		if(isTheEmptyTile(oldPos))		
		return false; //Can't move the empty tile
		
		if(!isTheEmptyTile(newPos))
			return false; //Can move only to the empty tile
		
		return AreNeighbors(oldPos, newPos); //Can move only if those position are touching each other
	}
	
	/**
	 * cheak if to position are neighbors - have a common side
	 * @param tile1 the number of the first tile
	 * @param tile2 the number of the second tile
	 * @return true if those tiles have a common side. false otherwise
	 */
	private boolean AreNeighbors(int tile1, int tile2){
		
		int size =  boardSize();
		int maxPos =size*size;
		
		if(tile1 <1 | tile2<1 | tile1 >maxPos | tile2>maxPos)
			throw new IllegalArgumentException("The input is out of range!");
		
		//Checking all the four neighbors of tile1 - it dossn't mater if illegal value will be returned
		int tLeft = tile1 % size - 1;
		int tRight = tile1 % size + 1;
		int tUp = tile1 - tile1 % size;
		int tDown = tile1 + tile1 % size;
		
		//return true if one of tile1's neighbors is tile2
		
		return tile2 == tLeft | tile2 == tRight | tile2 == tUp | tile2 == tDown;
	}

}
