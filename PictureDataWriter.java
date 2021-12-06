// List of imports
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class allows new data to be written to the file containing the picture information
 * @author Matthew Senese
 */
public class PictureDataWriter {
	
	/**
	 * This function writes an ArrayList of PictureData objects to a file
	 * @param fname Name of the file to write to
	 * @param images ArrayList of the PictureData objects
	 * @return True if done successfully, false otherwise
	 */
	public static boolean writePictureDataToFile(String fname, ArrayList<PictureData> images) {
		try { // Try catch block because writing to files is sketchy 
			// Creates a PrintWriter/BufferedWriter/FileWriter to print to the file
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			// Loop to print information for every image
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