import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PictureDataReader {
	
	public ArrayList<PictureData> readPictureDataFromFile(String fname) {
		try {
		Scanner fsc = new Scanner(new File(fname));
		ArrayList<PictureData> pictures = new ArrayList<PictureData>();
		String line;
		String[] parts;
		PictureData picture;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			picture = new PictureData(parts[0], parts[1], parts[2]);
			pictures.add(picture);
		}
		return pictures;
		} catch (Exception ex) {
			System.out.println("Something went wrong reading the file.");
			return null;
		}
	}
}