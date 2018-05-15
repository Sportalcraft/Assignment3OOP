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
	 * The Image of this tile
	 */
	private String _content;
	
	/**
	 * The constructor of AbstractTile class
	 * @param position the position if this tile
	 * @param desirablePosition the position if this tile on a solved board
	  * @param content the image of this tile
	 */
	public AbstractTile(int desirablePosition,  String content)
	{
		if(desirablePosition < 0)
			throw new IllegalArgumentException("position must be atleast 0!");
		
		if(content == null)
			throw new IllegalArgumentException("recived null as an image!");
		
		_desirablePosition = desirablePosition;
		_content = content;
	}
	
        /**
         * @return the tiles desirablePosition
         */
	@Override
	public int desirablePosition() {
		return _desirablePosition;
	}
	/**
         * @return the tile's image string represantation
         */
	@Override
	public String content() {
		return _content;
	}

}
