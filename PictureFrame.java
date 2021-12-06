import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;

// Ask about picture dimensions bc confusing
// Ask about what it wants to save, and how to show text automatically in JTextField

// This is the base for the picture frame
public class PictureFrame extends JFrame {
	
	private ArrayList<PictureData> picDescriptions;
	private ArrayList<BufferedImage> images;
	private PicturePanel panNorth;
	private int picTracker;
	private JTextField panCNorth;
	private JTextArea panCCenter;
	
	public void savePicture() {
		ArrayList<PictureData> pictures = panNorth.getPictureData();
		/*
		JFileChooser jfc = new JFileChooser();
		PictureDataWriter.writePictureDataToFile(jfc.getDescription(new File("descriptions.txt")), pictures);
		*/
	}
	
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		JMenuItem miSave = new JMenuItem("Save");
		mnuFile.add(miSave);
		miSave.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						ArrayList<PictureData> pictures = panNorth.getPictureData();
						JFileChooser jfc = new JFileChooser();
						if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							PictureDataWriter.writePictureDataToFile(jfc.getSelectedFile().getName(), pictures);
						}
						*/
						savePicture();
					}
				});
		JMenuItem miExit = new JMenuItem("Exit");
		mnuFile.add(miExit);
		miExit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
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
	
	public void setupGUI() {
		setTitle("Picture Frame");
		setBounds(100,100,290,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupMenu();
		picDescriptions = PictureDataReader.readPictureDataFromFile("descriptions.txt");
		images = PictureLoader.loadImagesFromPictureData(picDescriptions);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		panCNorth = new JTextField(20);
		panCenter.add(panCNorth, BorderLayout.NORTH);
		panCNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picDescriptions.get(0).getDate();
			}
		});
		panCCenter = new JTextArea();
		panCenter.add(panCCenter, BorderLayout.CENTER);
		panCCenter.setText(picDescriptions.get(0).getDescription());
		JPanel panCSouth = new JPanel();
		panCSouth.setLayout(new FlowLayout());
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
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePicture();
			}
		});
		panCSouth.add(btnNext);
		panCSouth.add(btnPrev);
		panCSouth.add(btnSave);
		panCenter.add(panCSouth, BorderLayout.SOUTH);
		c.add(panCenter, BorderLayout.CENTER);
		panNorth = new PicturePanel();
		c.add(panNorth, BorderLayout.NORTH);
		picTracker = 0;
		panNorth.setPicture(images.get(picTracker));
	}
	
	public PictureFrame() {
		setupGUI();
	}
}