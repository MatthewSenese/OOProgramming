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

// This is the base for the picture frame
public class PictureFrame extends JFrame {
	
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		JMenuItem miSave = new JMenuItem("Save");
		mnuFile.add(miSave);
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
					JOptionPane.showMessageDialog(null, "Created by Matthew Senese");
				}
			}
		);
	}
	
	public void setupGUI() {
		setTitle("Picture Frame");
		setBounds(100,100,290,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupMenu();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnNext = new JButton("Next");
		JButton btnPrev = new JButton("Prev");
		JButton btnSave = new JButton("Save");
		panSouth.add(btnPrev);
		panSouth.add(btnSave);
		panSouth.add(btnNext);
		c.add(panSouth, BorderLayout.SOUTH);
		PicturePanel panCenter = new PicturePanel();
		c.add(panCenter, BorderLayout.CENTER);
		
		
	}
	
	public PictureFrame() {
		setupGUI();
	}
}