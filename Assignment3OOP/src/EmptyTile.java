import java.awt.Image;

/**
 * This class represent the Empty Tile on the board
 */
public class EmptyTile implements ITile
{	
	/**
	 * The position of this tile
	 */
	private int _position;
	
	/**
	 * The desirable position of this tile - the position on a solved board
	 */
	private int _desirablePosition;
	
	/**
	 * The constructor of Tile class
	 * @param position the position if this tile
	 * @param desirablePosition the position if this tile on a solved board
	 */
	public EmptyTile(int position, int desirablePosition)
	{
		if(position <= 0 | desirablePosition <= 0)
			throw new IllegalArgumentException("position must be graqter than 0!");
		
		_position = position;
		_desirablePosition = desirablePosition;
	}
	
	@Override
	public int desirablePosition() {
		return _desirablePosition;
	}
	
	@Override
	public Image content() {
		return null;
	}
	
	@Override
	public int position() {
		return _position;
	}

	@Override
	public void moveTo(int newPos) {
		_position = newPos;		
	}

	@Override
	public boolean isInPlace() {
		return position() == desirablePosition();
	}

}
