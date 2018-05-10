package GameFrame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * @throws IOException 
	 */
	public static String[][] squareCut(String toCut, int length) {
		return Cut(toCut,length,length);
	}
	
	/**
	 * return an 2D array of the picture that are already saved, by size and name
	 * @param size the size of the board we want
	 * @param pic the name of the picture we want
	 * @return a 2d array of the paths to the requested images
	 */
	public static String[][] BuildImagesMap(int size, String pic) {	
		
		if(size < 3)
			throw new IllegalArgumentException("Illegal size!");
		
		if(pic == null)
			throw new IllegalArgumentException("path can't be null!");
		
		String[][] temp = new String[size][size];		
		File tFile; 
		
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				int t = size*i +j +1;
				temp[i][j] = "images/" + pic +"/"+ pic +"_" + size + "x" + size + "/" + t + ".jpeg";
				
				tFile = new File(temp[i][j]);

			}
		}
		return temp;
	}
	
	/**
	 * Cut an image to chunks (with the specified amount of pictures in the rows and columns)
	 * @param toCut the image to cut
	 * @param rows the amount of images on a row
	 * @param cols the amount of images on a column
	 * @return 2D array of the chucks of the image 
	 */
	private static String[][] Cut(String toCut, int rows, int cols) {
		
		if(toCut == null)
			throw new IllegalArgumentException("Image ti cut is null!");
		
		if(rows <= 0 | cols <= 0)
			throw new IllegalArgumentException("num of chuncks must be grater than 0!");
		
		String[][] toReturn = new String[rows][cols];
		int chunks = rows * cols;
		int count = 0;
		String name;
		
		File file = new File(toCut);
        
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			throw new IllegalArgumentException("The recivig image was not found!");
		}
		
        BufferedImage image;
		try {
			image = ImageIO.read(fis); //reading the image file 
		} 
		catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage());
		}      

        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;   
       
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }

        //writing mini images into image files
        for (int i = 0; i < imgs.length; i++) {
           
        	name = "img" + i + 1 + ".jpg";
        	
        	try {
				ImageIO.write(imgs[i], "jpg", new File(name));
			} 
        	catch (IOException e) {
        		throw new RuntimeException("Faild to serialze images!");
			}
        	
        	toReturn[ i / rows][i % cols] = name;
        }
       
        return toReturn;
    }
}
