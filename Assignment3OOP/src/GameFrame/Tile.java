package GameFrame;

/**
 * This class represent a tile
 */
class Tile extends AbstractTile
{
	/**
	 * The Image of this tile
	 */
	private String _content;
	
	/**
	 * The constructor of Tile class
	 * @param desirablePosition the position if this tile on a solved board
	 * @param content the image of this tile
	 */
	public Tile(int desirablePosition, String content)
	{
		super(desirablePosition);
		
		if(content == null)
			throw new IllegalArgumentException("recived null as an image!");
		
		_content = content;
	}
	
	@Override
	public String content() {
		return _content;
	}
}
