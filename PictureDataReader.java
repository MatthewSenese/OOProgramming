// List of imports
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * This class reads the PictureData information from an external file and creates an ArrayList of PictureData objects from it
 * @author Matthew Senese
 */
public class PictureDataReader {
	
	/**
	 * This function takes in a file name, and reads it to put the information into an ArrayList of PictureData objects
	 * @param fname Name of the file containing PictureData information
	 * @return ArrayList of PictureData objects to work with
	 */
	public static ArrayList<PictureData> readPictureDataFromFile(String fname) {
		try { // Puts reading code in a try-catch block because reading files is sketchy
			// Creates a scanner for the file
			Scanner fsc = new Scanner(new File(fname));
			// Initialize the ArrayList and other useful variables
			ArrayList<PictureData> pictures = new ArrayList<PictureData>();
			String line;
			String[] parts;
			PictureData picture;
			while (fsc.hasNextLine()) { 
				// While there is another line in the file, split the line and create a PictureData object from the info
				// Then add that object to the ArrayList
				line = fsc.nextLine();
				parts = line.split("\t");
				picture = new PictureData(parts[0], parts[1], parts[2]);
				pictures.add(picture);
			}
			fsc.close(); // Close the file scanner
			return pictures; // Return the ArrayList
		} catch (Exception ex) {
			System.out.println("Something went wrong reading the file.");
			return null; // Return null if unable to read the file
		}
	}
}