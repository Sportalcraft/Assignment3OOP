package GameFrame;

import java.io.IOException;

public class Game implements IGame {
	
	/**
	 * The board of this game
	 */
	private IBoard _board;
	
	/**
	 * The undo stack that track this game
	 */
	private undoStack _undo;
	
	/**
	 * The amount of moves that were made on this game
	 */
	private int _moves; 
	
	/**
	 * A constructor
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @param boardOrder the order to shuffle the board in
	 */
	public Game(String[][] images, Integer[][] boardOrder){
		
		Verify2DArray(images);
		Verify2DArray(boardOrder);
		
		_board = BuildBoard(images, boardOrder);
		_undo = new undoStack(_board);
		_moves = 0;
	}
	
	/**
	 * A constructor that randomly shuffle the board
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 */
	public Game(String[][] images){
		
		Verify2DArray(images);
		
		_board = new Board(BuildBoardMap(images), images[images.length][images.length], true);
		_undo = new undoStack(_board);
		_moves = 0;
	}

	/**
	 * A constructor
	 * @param image the image of the game
	 * @param boardOrder the order to shuffle the board in
	 * @throws IOException 
	 */
	public Game(String image, Integer[][] boardOrder) {
		this(ImageHandler.squareCut(image, boardOrder.length),boardOrder);
	}
	
	@Override
	public boolean undoable() {
		return _undo.canUndo();
	}

	@Override
	public void undo() {
		_undo.undo();		
	}
	
	@Override
	public int moves() {
		return _moves;
	}

	
	@Override
	public int boardSize() {
		return _board.boardSize();
	}

	@Override
	public void moveTile(int tile) {
		_board.moveTile(tile);
		_undo.push(tile); // Save this turn to the undo stack
		_moves++; 		  // A move was made
	}

	@Override
	public boolean isComplete() {
		return _board.isComplete();
	}

	@Override
	public ITile[][] boardMap() {
		return _board.boardMap();
	}
	
	
	
	/**
	 * Build the board of the game
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @param boardOrder the order to shuffle the board in
	 * @return a board that is built according to the instructions
	 */
	private IBoard BuildBoard(String[][] images, Integer[][] boardOrder)
	{
		int size = images.length;
		ITile[][] boardMap = new ITile[size][size];
		int desirablePosition;
		String imageOfEmty = null;
		
		for(int row = 1; row< size; row ++)
		{
			for(int col = 1; col< size; col ++)
			{
				desirablePosition = boardOrder[row][col];
				
				if(desirablePosition == 0) //EmptyTile
				{
					boardMap[row][col] = new EmptyTile(desirablePosition);
					imageOfEmty = images[desirablePosition/size][desirablePosition%size];
				}
				else
					boardMap[row][col] = new Tile(desirablePosition, images[desirablePosition/size][desirablePosition%size]);
			}
		}
		
		return new Board(boardMap, imageOfEmty);
	}
	
	/**
	 * Build the board map of the game
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @return a board map that is built by the order of images
	 */
	private ITile[][] BuildBoardMap(String[][] images) {
		
		int size = images.length;
		 ITile[][] map = new  ITile[size][size];
		
		for(int i = 0; i< size; i++){
			for(int j = 0; j< size; j++){
				map[i][j] = new Tile(i*size +j, images[i][j]);
			}
		}
		map[size][size] = new EmptyTile(size*size);
		
		return map;
	}
	
	/**
	 * verify if a 2D array is a matrix
	 * @param arr the array to check
	 * @throws IllegalArgumentException if not legal 2D matrix array
	 */
	private <T> void Verify2DArray(T[][] arr) throws IllegalArgumentException {
		
		if(arr == null)
			throw new IllegalArgumentException("The board is null!");
		
		int size = arr.length;
		
		if(size == 0)
			throw new IllegalArgumentException("The board is empty!");
		
		
		for(T[] row : arr)
		{
			if(row == null)
				throw new IllegalArgumentException("The board have a row that is null!");
			
			if(row.length != size)
				throw new IllegalArgumentException("The board have a row that is have a diffrent leangth that the baord size!");		
			
			for(T item : row)
			{
				if(item == null)
					throw new IllegalArgumentException("The board have a null item!");			
			}
		}
	}
}
