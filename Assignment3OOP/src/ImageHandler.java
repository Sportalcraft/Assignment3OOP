import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

/**
 * This class handle the images
 */
class ImageHandler {
	
	/**
	 * Cut an image to chunks in a square (with the specified amount of pictures in the rows and columns)
	 * @param toCut the image to cut
	 * @param length the amount of images on a row an column
	 * @return a matrix of the chucks of the image
	 */
	public static Image[][] squareCut(Image toCut, int length){
		return Cut(toCut,length,length);
	}
	
	/**
	 * Cut an image to chunks (with the specified amount of pictures in the rows and columns)
	 * @param toCut the image to cut
	 * @param rows the amount of images on a row
	 * @param cols the amount of images on a column
	 * @return 2D array of the chucks of the image
	 */
	private static Image[][] Cut(Image toCut, int rows, int cols){
		
		if(toCut == null)
			throw new IllegalArgumentException("Image ti cut is null!");
		
		if(rows <= 0 | cols <= 0)
			throw new IllegalArgumentException("num of chuncks must be grater than 0!");
		
		Image[][] toReturn = new Image[rows][cols];
		int chunks = rows * cols;	
		
		
	}
}
