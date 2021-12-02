
public class PictureData {
	private String fname;
	private String date;
	private String description;
	
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
	
	public PictureData() {
		fname = "";
		date = "";
		description = "";
	}
	
	public PictureData(String fname, String date, String desc) {
		setFilename(fname);
		setDate(date);
		setDescription(desc);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s", fname, date, description);
	}

}