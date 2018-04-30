import java.util.List;
import java.util.Vector;

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
		
		if(size <= 0)
			throw new IllegalArgumentException("size must be greater than 0!");
		
		VerifyBoard(tiles); // Input checking for the board
		
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
		
		swap(tileNum, newPos);
		_moves++; // A move was made
	}

	@Override
	public boolean isComplete() {
			
		int currentPlace = 1;
		
		for(ITile[] row : _boardMatrix)
		{		
			for(ITile tile : row)
			{							
				if(tile.desirablePosition() != currentPlace)
					return false;
				
				currentPlace++;
			}
		}
		
		return true; // All tiles in place
	}

	@Override
	public int moves() {
		return _moves;
	}
	
	
	/**
	 * check if a board is legal
	 * @param board the board to check
	 * @throws IllegalArgumentException if the board is not legal
	 */
	private void VerifyBoard(ITile[][] board) throws IllegalArgumentException
	{
		int size;
		boolean emptyFound = false;							// Exactly one empty tile is allowed
		List<Integer> usedDesirablePlaces = new Vector<>(); // save the Desirable already taken. two tiles can't go to the same place
		
		if(board == null)
			throw new IllegalArgumentException("The board is null!");
		
		size = board.length;
		
		if(size == 0)
			throw new IllegalArgumentException("The board is empty!");
		
		
		for(ITile[] row : board)
		{
			if(row == null)
				throw new IllegalArgumentException("The board have a row that is null!");
			
			if(row.length != size)
				throw new IllegalArgumentException("The board have a row that is have a diffrent leangth that the baord size!");
			
			
			for(ITile tile : row)
			{
				if(tile == null)
					throw new IllegalArgumentException("The board have a null tile!");
				
				if(usedDesirablePlaces.contains(tile.desirablePosition()))
					throw new IllegalArgumentException("The board have two tiles with the same desirable position!");
				
				usedDesirablePlaces.add(tile.desirablePosition());
				
				if(isTheEmptyTile(tile))
				{
					if(emptyFound)
						throw new IllegalArgumentException("The board have more than one empty tiles!");
					
					if(tile.desirablePosition() != size*size) //not the right-down corner
						throw new IllegalArgumentException("The desirable position of the empty tile is nit the right corner!");
					
					emptyFound = true;
				}
			}
		}
		
		if(!emptyFound)
			throw new IllegalArgumentException("The board have no empty tile!");		
	}
	
	/**
	 * get the tile with the given position
	 * @param num the position of the tile
	 * @return the tile at the given position
	 */
	private ITile getTile(int num){		
		return _boardMatrix[getTileRow(num)][getTileCol(num)];
	}
	
	/**
	 * calculate the row of the n tile
	 * @param num the position of the tile
	 * @return the row that this tile is in
	 */
	private int getTileRow(int num){
		return num / boardSize();
	}
	
	/**
	 * calculate the column of the n tile
	 * @param num the position of the tile
	 * @return the column that this tile is in
	 */
	private int getTileCol(int num){
		return num % boardSize();
	}
	
	/**
	 * Check if a given tile is the empty tile
	 * @param pos the position to check
	 * @return true if this position is not occupied by any tile, false otherwise
	 */
	private boolean isTheEmptyTile(ITile pos){
		return pos instanceof EmptyTile;
	}
	
	/**
	 * Check if a given position is the empty tile
	 * @param pos the position to check
	 * @return true if this position is the empty tile, false otherwise
	 */
	private boolean isTheEmptyTile(int pos){
		return isTheEmptyTile(getTile(pos));
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
	 * Check if to position are neighbors - have a common side
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
	
	/**
	 * swap two tiles in the board
	 * @param tileNum
	 * @param newPos
	 */
	private void swap(int tile1, int tile2) {
		
		ITile tTile1 =  _boardMatrix[getTileRow(tile1)][getTileCol(tile1)];
		ITile tTile2 =  _boardMatrix[getTileRow(tile2)][getTileCol(tile2)];
		
		_boardMatrix[getTileRow(tile1)][getTileCol(tile1)] = tTile2;
		_boardMatrix[getTileRow(tile2)][getTileCol(tile2)] = tTile1;
	}

}
