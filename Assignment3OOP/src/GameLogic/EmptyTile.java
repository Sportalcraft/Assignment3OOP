package GameLogic;

public class EmptyTile extends AbstractTile
{
	/**
	 * should the image of the tile be displayed?
	 */
	private boolean _displayable;
	
	/**
	 * The constructor of EmptyTile class
	 * @param desirablePosition the position if this tile on a solved board
	  * @param content the image of this tile
	 */
	public EmptyTile(int desirablePosition, String content) {
		super(desirablePosition, content);
		
		_displayable = false;
	}

	@Override
	public String content() {
		
		if(_displayable)
			return super.content();
		return null; //Should not be displayed
	}
	
	/**
	 * change displayable to true;
	 */
	public void gameEnded(){
		_displayable = true;
	}
}
