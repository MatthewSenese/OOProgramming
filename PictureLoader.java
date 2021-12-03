import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PictureLoader {
	
	public ArrayList<BufferedImage> loadImagesFromPictureData(PictureData image) {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		try {
		BufferedImage img = ImageIO.read(new File(image.getFilename()));
		images.add(img);
		} catch (Exception ex) {
			System.out.println("Something went wrong loading the images");
			return null;
		}
		return images;
	}
}