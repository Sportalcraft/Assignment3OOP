import java.awt.Image;

/**
 * This interface represent a tile in the board
 */
public interface ITile 
{
	/**
	 * Get the desirable position of this tile in the board - where it need to be locate at the end of the game. a number between 1 and N^2-1 when N is the board size
	 * @return tile desirable position of this tile on the board
	 */
	int desirablePosition();
	
	/**
	 * get the Image of this tile
	 * @return the image of this tile
	 */
	Image content();
	
	
	// In doubt :
	
	/**
	 * Get the position of this tile in the board. a number between 1 and N^2-1 when N is the board size
	 * @return tile position of this tile on the board
	 */
	int position();
	
	/**
	 * Move this tile to a given place
	 * @param newPos the place to move this tile to
	 */
	void moveTo(int newPos);
		
	/**
	 * return true if this tile is on it's right place, false otherwise
	 * @return id this tile on the right place
	 */
	boolean isInPlace();	
}
