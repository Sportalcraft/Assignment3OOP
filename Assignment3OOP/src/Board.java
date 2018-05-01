import java.awt.Image;
import java.util.List;
import java.util.Vector;

/**
 * This class represent a board
 */
class Board implements IBoard
{
	/**
	 * holds the tiles if this board
	 */
	private ITile[][] _boardMatrix;
	
	/**
	 * The amount of moves that were made on this board
	 */
	private int _moves; 
	
	/**
	 * The image that should go to the empty tile when the borad is solved
	 */
	private Image _picOfEmtyTile;
	
	/**
	 * Does this board was solved already?
	 */
	private boolean _solved;
	
	/**
	 * The constructor
	 * @param tiles the boards
	 * @param picOfEmpty the image that should go to the empty tile
	 */
	public Board(ITile[][] tiles, Image picOfEmpty){
		
		if(picOfEmpty == null)
			throw new IllegalArgumentException("The image for the empty tile is null!"); 
		
		VerifyBoard(tiles); // Input checking for the board
		
		_boardMatrix = tiles;
		_picOfEmtyTile = picOfEmpty;
		_moves = 0;		
		_solved = false;
		
		if(isComplete())
			throw new IllegalArgumentException("The reciving boaard is already solved!"); 
	}
	
	@Override
	public int boardSize() {
		return _boardMatrix.length;
	}

	@Override
	public void moveTile(int tile) {
		
		if(isLocked())
			throw new IllegalStateException("A change cannot be made to this board since it is already solved!"); 
		
		List<Integer> neighbors = neighborsOf(tile);
		
		for(int neighbor : neighbors)
		{
			if(isTheEmptyTile(neighbor))
			{
				swap(tile, neighbor);
				_moves++; // A move was made
				
				isComplete(); //Lock if solved
				
				return;
			}
		}
		
		throw new IllegalArgumentException("This tile is not a neighbor of the empty tile, and therefore, could not be moved!"); 
	}

	@Override
	public boolean isComplete() {
			
		int currentPlace = 1;
		
		if(isLocked())
			return true;
		
		for(ITile[] row : _boardMatrix)
		{		
			for(ITile tile : row)
			{							
				if(tile.desirablePosition() != currentPlace)
					return false;
				
				currentPlace++;
			}
		}
		
		lock(); 	 // Lock the board - it is solved
		return true; // All tiles in place
	}

	@Override
	public int moves() {
		return _moves;
	}
	
	@Override
	public ITile[][] boardMap() {
		return _boardMatrix;
	}
	
	/**
	 * check if this board can be changed
	 * @return true if this board was not solved yet, false otherwise
	 */
	private boolean isLocked(){
		return !_solved;
	}
	

	/**
	 * lock this board to changes
	 */
	private void lock(){
		_solved = true;
		int size = boardSize();
		_boardMatrix[size][size] = new Tile(size*size, _picOfEmtyTile); //Change th empty tile to a normal tile with the right picture
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
	 * return the neighbors of a certain tile
	 * @param tile the number of the tile
	 * @return a list that contains the neighbors of the tile
	 */
	private List<Integer> neighborsOf(int tile){
			
		int size = boardSize();
		List<Integer> neighbors = new Vector<>();	
		
		if(tile < 1 | tile  > size*size )
			throw new IllegalArgumentException("The input is out of range!");
		
		if(getTileCol(tile) > 1)
			neighbors.add(tile - 1); // Left
		
		if(getTileCol(tile) < size)
			neighbors.add(tile + 1); // Right
		
		if(getTileRow(tile) > 1)
			neighbors.add(tile - size); // Up
		
		if(getTileRow(tile) < size)
			neighbors.add(tile + size); // Down
		
		return neighbors;
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
