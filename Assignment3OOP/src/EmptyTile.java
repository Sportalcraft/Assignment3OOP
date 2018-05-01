import java.awt.Image;

class EmptyTile extends AbstractTile
{
	/**
	 * The constructor of EmptyTile class
	 * @param desirablePosition the position if this tile on a solved board
	 */
	public EmptyTile(int desirablePosition) {
		super(desirablePosition);
	}

	@Override
	public Image content() {
		return null; //No Image
	}

}
