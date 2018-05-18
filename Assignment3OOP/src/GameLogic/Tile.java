package GameLogic;

/**
 * This class represent a tile
 */
public class Tile extends AbstractTile
{	
	/**
	 * The constructor of Tile class
	 * @param desirablePosition the position if this tile on a solved board
	 * @param content the image of this tile
	 */
	public Tile(int desirablePosition, String content){
		super(desirablePosition, content);	
	}	
}
