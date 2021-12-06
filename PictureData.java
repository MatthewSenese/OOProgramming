/**
 * This is a Model class to provide information regarding an image
 * @author Matthew Senese
 */
public class PictureData {
	// Declaration of variables
	private String fname;
	private String date;
	private String description;
	
	// Getters and Setters
	public String getFilename() {
		return fname;
	}
	public void setFilename(String fname) {
		this.fname = fname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	// Generic Constructor
	public PictureData() {
		fname = "";
		date = "";
		description = "";
	}
	
	// Non-default Constructor
	public PictureData(String fname, String date, String desc) {
		setFilename(fname);
		setDate(date);
		setDescription(desc);
	}
	
	// toString implementation
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s", fname, date, description);
	}

}