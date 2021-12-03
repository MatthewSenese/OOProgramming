import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PictureDataWriter {
	
	public static boolean writePictureDataToFile(String fname, ArrayList<PictureData> images) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			for (PictureData image : images) {
				pw.println(image);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			System.out.println("Something went wrong writing new data");
			return false;
		}
	}
}