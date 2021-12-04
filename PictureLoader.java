import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PictureLoader {
	
	public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pictures) {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		try {
			BufferedImage img;
			for (int i = 0; i < pictures.size(); i ++) {
				 img = ImageIO.read(new File(pictures.get(i).getFilename()));
				 images.add(img);
			}
			return images;
		} catch (Exception ex) {
			System.out.println("Something went wrong loading the images");
			return null;
		}

	}
}