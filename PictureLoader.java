// List of imports
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * This class creates an ArrayList of BufferedImages from an ArrayList of PictureData objects
 * @author Matthew Senese
 */
public class PictureLoader {
	
	/**
	 * This function takes in the picture data and extracts the picture files to convert them into BufferedImages
	 * @param pictures ArrayList of the PictureData objects
	 * @return ArrayList of the BufferedImage objects 
	 */
	public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pictures) {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>(); // Create a new ArrayList of BufferedImages
		try { // Put code in a try catch block because working with the files is a bit sketchy
			BufferedImage img; // Declare a BufferedImage
			for (int i = 0; i < pictures.size(); i ++) { // For every item in the PictureData ArrayList
				 img = ImageIO.read(new File(pictures.get(i).getFilename())); // Make the file a BufferedImage
				 images.add(img); // Add that BufferedImage to the ArrayList to return
			}
			return images; // Return the BufferedImages
		} catch (Exception ex) {
			System.out.println("Something went wrong loading the images");
			return null; // Return null if the file can't be read properly
		}

	}
}