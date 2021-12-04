import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class APP {
	public static void main(String[] args) {
		PictureFrame pf = new PictureFrame();
		pf.setVisible(true);
		
		ArrayList<PictureData> picDescriptions;
		ArrayList<BufferedImage> images;
		
		picDescriptions = PictureDataReader.readPictureDataFromFile("descriptions.txt");
		images = PictureLoader.loadImagesFromPictureData(picDescriptions);
	}
}