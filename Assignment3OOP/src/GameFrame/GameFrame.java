package GameFrame;

import java.io.IOException;
import java.util.Stack;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	/**
	 * The board of this game
	 */
	private BoardPanel _board;
	 
	
	/**
	 * A constructor
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @param boardOrder the order to shuffle the board in
	 */
	public GameFrame(String[][] images, Integer[][] boardOrder){
		
		this(BuildBoard(images, boardOrder));
		
		Verify2DArray(images);
		Verify2DArray(boardOrder);

	}	
	
	/**
	 * A constructor that randomly shuffle the board
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 */
	public GameFrame(String[][] images){
		
		this(new BoardPanel(new Board(BuildBoardMap(images), true)));
		Verify2DArray(images);
	}
	
	/**
	 * A constructor to build the board from saved images
	 * @param size
	 * @param pic
	 */
	public GameFrame(Sizes size, SavedImages pic) {
		this(ImageHandler.BuildImagesMap(size.getSize(), pic.toString()));
	}
	
	/**
	 * Saved images
	 */
	public enum SavedImages
	{
		cat , cyber, sushi;
	}
	
	/**
	 * Saved images
	 */
	public enum Sizes
	{	
		THREE(3), FOUR(4), FIVE(5);
		
		private final int _size;
		
		Sizes(int size) {
			_size = size;
		}
		
		public int getSize() {
			return _size;
		}
	}	

	/**
	 *  * A constructor
	 * @param board the board
	 */
	private GameFrame(BoardPanel board) {		
		
		super("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().add(board);
		
		pack();
	}

	public void undo() {
		_board.undo();		
	}

	public boolean isComplete() {
		return _board.isComplete();
	}
	
	
	
	/**
	 * Build the board of the game
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @param boardOrder the order to shuffle the board in
	 * @return a board that is built according to the instructions
	 */
	private static BoardPanel BuildBoard(String[][] images, Integer[][] boardOrder)
	{
		int size = boardOrder.length;
		ITile[][] boardMap = new ITile[size][size];
		int desirablePosition;
		
		for(int row = 1; row< size; row ++)
		{
			for(int col = 1; col< size; col ++)
			{
				desirablePosition = boardOrder[row][col];
				
				if(desirablePosition == size*size-1) //EmptyTile
					boardMap[row][col] = new EmptyTile(desirablePosition, images[desirablePosition/size][desirablePosition%size]);
				else
					boardMap[row][col] = new Tile(desirablePosition, images[desirablePosition/size][desirablePosition%size]);
			}
		}
		
		return new BoardPanel(new Board(boardMap));
	}
	
	/**
	 * Build the board map of the game
	 * @param images the images of the tiles IN ORDER (1-N*N), including the empty tile image
	 * @return a board map that is built by the order of images
	 */
	private static ITile[][] BuildBoardMap(String[][] images) {
		
		int size = images.length;
		 ITile[][] map = new  ITile[size][size];
		
		for(int i = 0; i< size; i++){
			for(int j = 0; j< size; j++){
				map[i][j] = new Tile(i*size + j, images[i][j]);
			}
		}
		map[size-1][size-1] = new EmptyTile(size*size-1, images[size-1][size-1]);
		
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
