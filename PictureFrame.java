// List of imports
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * This is the class that creates the main frame for viewing the pictures
 * It is a descendant of JFrame, and it also implements a menu bar and buttons for convenience
 * @author Matthew Senese
 */
public class PictureFrame extends JFrame {
	
	// Declaration of variables
	private ArrayList<PictureData> picDescriptions;
	private ArrayList<BufferedImage> images;
	private PicturePanel panNorth;
	private int picTracker = 0;
	private JTextField panCNorth;
	private JTextArea panCCenter;
	
	// This function will save the changes made to the picture dates and descriptions
	public void savePicture() {
		// Gets the information from the JText panels and creates a new date and description for the picture shown
		// Then it creates a new PictureData object and replaces the old one in the picDescriptions ArrayList
		String newDate = panCNorth.getText();
		String newDescription = panCCenter.getText();
		String fname = picDescriptions.get(picTracker).getFilename();
		PictureData picture = new PictureData(fname, newDate, newDescription);
		picDescriptions.add(picTracker, picture);
		picDescriptions.remove(picTracker + 1);
		// Writes the current information on the picture shown to the descriptions.txt file
		PictureDataWriter.writePictureDataToFile("descriptions.txt", picDescriptions);
	}
	
	// This function sets up the menu bar on the frame
	public void setupMenu() {
		// Declaration of variables
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		
		// Adds menu items to the menubar
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		
		// Implements a save option for the file menu item
		JMenuItem miSave = new JMenuItem("Save");
		mnuFile.add(miSave);
		miSave.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						savePicture();
					}
				});
		
		// Implements an exit option for the file menu item
		JMenuItem miExit = new JMenuItem("Exit");
		mnuFile.add(miExit);
		miExit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		
		// Implements an about option for the help menu item
		JMenuItem miAbout = new JMenuItem("About");
		mnuHelp.add(miAbout);
		setJMenuBar(mbar);
		miAbout.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Created by Matthew Senese in December 2021");
				}
			}
		);
	}
	
	// This function sets up the panels, menu, and buttons for the frame
	public void setupGUI() {
		// Sets up some default information for the frame
		setTitle("Picture Frame");
		setBounds(100,100,290,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Calls setupMenu function to implement menubar
		setupMenu();
		
		// Initializes picDescriptions and images
		picDescriptions = PictureDataReader.readPictureDataFromFile("descriptions.txt");
		images = PictureLoader.loadImagesFromPictureData(picDescriptions);
		
		// Sets up container for panels and sets up layout
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		
		// Sets up a panel for the date of the image
		panCNorth = new JTextField(20);
		panCNorth.setText(picDescriptions.get(picTracker).getDate());
		panCenter.add(panCNorth, BorderLayout.NORTH);
		
		// Sets up a panel for the description of the image
		panCCenter = new JTextArea();
		panCCenter.setText(picDescriptions.get(picTracker).getDescription());
		panCenter.add(panCCenter, BorderLayout.CENTER);
		
		// Sets up a panel for the buttons
		JPanel panCSouth = new JPanel();
		panCSouth.setLayout(new FlowLayout());

		// Implements the prev button that moves back in the list to the previous picture
		JButton btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picTracker --;
				if (picTracker < 0) {
					picTracker = 3;
				}
				panNorth.setPicture(images.get(picTracker));
				panCCenter.setText(picDescriptions.get(picTracker).getDescription());
				panCNorth.setText(picDescriptions.get(picTracker).getDate());
			}
		});
		panCSouth.add(btnPrev);
		
		// Implements the save button that saves the current image's adjusted date and description
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePicture();
			}
		});
		panCSouth.add(btnSave);
		
		// Implements the next button that moves forward in the list to the next picture
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picTracker ++;
				if (picTracker > 3) {
					picTracker = 0;
				}
				panNorth.setPicture(images.get(picTracker));
				panCCenter.setText(picDescriptions.get(picTracker).getDescription());
				panCNorth.setText(picDescriptions.get(picTracker).getDate());
			}
		});
		panCSouth.add(btnNext);
		
		// Adds the buttons to the frame
		panCenter.add(panCSouth, BorderLayout.SOUTH);
		c.add(panCenter, BorderLayout.CENTER);
		
		// Creates a new panel for viewing the picture
		panNorth = new PicturePanel();
		c.add(panNorth, BorderLayout.NORTH);
		panNorth.setPicture(images.get(picTracker));
	}
	
	// This constructor calls the setupGUI function to create the PictureFrame
	public PictureFrame() {
		setupGUI();
	}
}