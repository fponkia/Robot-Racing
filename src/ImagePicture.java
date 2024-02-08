import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author foram
 * Description: Draws Pictures using Image files
 */
public class ImagePicture extends Picture{
	
	/**
	 * Declare instance Variables
	 */
	private ImageIcon image;
	
	/**
	 * default constructor
	 */
	public ImagePicture(ImageIcon img) {
		super();	//calls the picture default constructor
		this.image = img;
		//calls setters to set my width and height
		super.setMyWidth(img.getIconWidth());
		super.setMyHeight(img.getIconHeight());
		repaint();
	}
	
	/**
	 * second overloaded constructor
	 */
	public ImagePicture(ImageIcon img, int x, int y) {
		super(x, y, img.getIconWidth(), img.getIconHeight());
		this.image = img;
		repaint();
	}
	/**
	 *  override paint from Picture
	 */
	public void paint(Graphics g) {
		//draws the image
		this.image.paintIcon(this, g, getxPos(), getyPos());
	}

	/**
	 * @param args
	 * A self testing main method
	 */
	public static void main(String[] args) {
		//create the JFrame
		JFrame f = new JFrame("Testing my class");
		
		//create an ImagePicure object
		ImagePicture i = new ImagePicture(new ImageIcon("galaxy.jpg"));
		
		f.setSize(400, 350);
		f.add(i);
		f.setVisible(true);
		
		//pause
		JOptionPane.showMessageDialog(null, "Wait");
		
		//move the minion
		i.setxPos(200);
		i.setyPos(70);
		
		//pause
		JOptionPane.showMessageDialog(null, "Wait");
		
		//create a new imageIcon in a new place
		ImagePicture i1 = new ImagePicture(new ImageIcon("r2d2.jpg"), 20, 30);
		f.add(i1);
		f.setVisible(true);
	}

}
