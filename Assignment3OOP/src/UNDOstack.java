import java.util.Stack;

/**
 * This class enable undoing
 */
class UNDOstack 
{
	/**
	 * holds the turn in LIFO order
	 */
	private Stack<Turn> _turns;
	
	/**
	 * The board this stack is tracing
	 */
	private IBoard _board;
	
	/**
	 * The constructor of the UNDO class
	 * @param board the board this UNDO is tracking
	 */
	public UNDOstack(IBoard board){
	
		if(board== null)
			throw new IllegalArgumentException("recived a null board!");
		
		_board = board;
		_turns = new Stack<>();
	}
	
	/**
	 * Check if there are any turns to undo
	 * @return true if there is at least one turn to undo, false otherwise
	 */
	public boolean canUndo(){
		return !_turns.isEmpty();
	}
	
	/**
	 * Push a new turn to the stack
	 * @param Tile the tile that were moved
	 */
	public void push(int tile){
		_turns.push(new Turn(tile));
	}
	
	/**
	 * Undo the last operation
	 */
	public void undo(){
		
		if(!canUndo())
			throw new IllegalStateException();
		
		Turn tLastTurn  =  _turns.pop();
		_board.moveTile(tLastTurn.getTile());
	}
	
	
	
	/**
	 * This class represent a turn - witch tile moved and from were
	 */
	private class Turn
	{
		/**
		 * 	The tile that were moved
		 */
		private int _tile;
		
		/**
		 * The constructor of turn
		 * @param tile The tile that were moved this turn
		 */
		public Turn(int tile){
		
			if(tile <= 0)
				throw new IllegalStateException("position must be greater than 0!");
			
			_tile = tile;
		}
		
		/**
		 * getter to the tile
		 * @return The number of the moved tile
		 */
		public int getTile(){
			return _tile;
		}
	}
}
