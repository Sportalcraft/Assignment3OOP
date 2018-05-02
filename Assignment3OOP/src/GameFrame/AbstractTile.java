package GameFrame;

/**
 * This class represent a Tile on the board
 */
abstract class AbstractTile implements ITile
{		
	/**
	 * The desirable position of this tile - the position on a solved board
	 */
	private int _desirablePosition;
	
	/**
	 * The constructor of AbstractTile class
	 * @param position the position if this tile
	 * @param desirablePosition the position if this tile on a solved board
	 */
	public AbstractTile(int desirablePosition)
	{
		if(desirablePosition <= 0)
			throw new IllegalArgumentException("position must be graqter than 0!");
		
		_desirablePosition = desirablePosition;
	}
	
	@Override
	public int desirablePosition() {
		return _desirablePosition;
	}
	
	@Override
	public abstract String content();

}
