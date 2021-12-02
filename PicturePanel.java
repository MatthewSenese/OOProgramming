import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.awt.Dimension;

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener {
	private String coords;
	private int msgX, msgY;

	
	public PicturePanel() {
		msgX = 0;
		msgY = 0;
		coords = String.format("(x=%d, y=%d)", msgX, msgY);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(200,200));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(coords, msgX, msgY);
	}
	
	public void mouseClicked(MouseEvent e) {
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