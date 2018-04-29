import java.awt.Image;

/**
 * This class represent a tile
 */
public class Tile implements ITile
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
	 * The Image of this tile
	 */
	private Image _content;
	
	/**
	 * The constructor of Tile class
	 * @param position the position if this tile
	 * @param desirablePosition the position if this tile on a solved board
	 * @param content the image of this tile
	 */
	public Tile(int position, int desirablePosition, Image content)
	{
		_position = position;
		_desirablePosition = desirablePosition;
		_content = content;
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
	public int desirablePosition() {
		return _desirablePosition;
	}

	@Override
	public boolean isInPlace() {
		return position() == desirablePosition();
	}

	@Override
	public Image content() {
		return _content;
	}
}
