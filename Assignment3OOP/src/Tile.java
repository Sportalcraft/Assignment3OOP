import java.awt.Image;

/**
 * This class represent a tile
 */
public class Tile extends AbstractTile
{
	/**
	 * The Image of this tile
	 */
	private Image _content;
	
	/**
	 * The constructor of Tile class
	 * @param desirablePosition the position if this tile on a solved board
	 * @param content the image of this tile
	 */
	public Tile(int desirablePosition, Image content)
	{
		super(desirablePosition);
		
		if(content == null)
			throw new IllegalArgumentException("recived null as an image!");
		
		_content = content;
	}
	
	@Override
	public Image content() {
		return _content;
	}
}
