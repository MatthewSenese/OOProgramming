// List of imports
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This class is a descendant of JPanel and allows images to be viewed in a PictureFrame
 * Also implements MouseListener and MouseMotionListener to show coordinates of mouse on the Panel
 * @author Matthew Senese
 */
public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener {
	// Declaration of variables
	private String coords;
	private int msgX, msgY;
	private BufferedImage picture;
	private ArrayList<PictureData> pictures;
	
	// This function returns the ArrayList of PictureData objects
	public ArrayList<PictureData> getPictureData() {
		return pictures;
	}
	
	// This function sets the ArrayList of PictureData objects
	public void setPictureData(ArrayList<PictureData> pics) {
		pictures = pics;
	}
	
	// Generic constructor of the PicturePanel
	public PicturePanel() {
		msgX = 0;
		msgY = 0;
		coords = String.format("(x=%d, y=%d)", msgX, msgY);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(200,200));
	}
	
	/**
	 * Sets the picture in the PicturePanel to the BufferedImage passed in
	 * @param pic BufferedImage to pass in to change the picture
	 */
	public void setPicture(BufferedImage pic) {
		picture = pic;
		repaint();
	}
	
	// This will draw the image in the panel
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Calls the implementation from the super class for paintComponent
		try { // Puts the code in a try catch block because painting stuff is a bit sketchy
			g.drawImage(picture, 0, 0, null); // Draws the image
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to load image");
		}
		g.drawString(coords, msgX, msgY); // Draws the coordinates
	}
	
	
	// Implementation of MouseListener and MouseMotionListener functions
	public void mouseClicked(MouseEvent e) { // Moves the coordinates of the mouse to where the mouse is clicked
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		msgX = e.getX();
		msgY = e.getY();
		repaint(); 
	}
	
	public void mousePressed(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		coords = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		repaint();
	}

}