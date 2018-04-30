import java.awt.Image;

/**
 * This class represent a tile
 */
public class Tile extends EmptyTile
{
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
		super(position, desirablePosition);
		
		if(content == null)
			throw new IllegalArgumentException("recived null as an image!");
		
		_content = content;
	}
	
	@Override
	public Image content() {
		return _content;
	}
}
