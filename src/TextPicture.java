import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Foram Patel
 * Date: May 23, 2021
 * Description: Draws The text on the JFrame window
 * Methods / Constructors: public TextPicture(String text): default constructor to initialize the variables of this class and super class.
 * 	public TextPicture(String text, int x, int y): overloaded constructor to initialize the variables of this class and super class.
 * 	public void setText(String text): Method to set the text to a String variable.
 * 	public void setFont(Font newfont): Method to set new font.
 * 	public void paint(Graphics g): Method to paint the new text on the JFrame window.
 * 	public static void main(String[] args): A self testing main method
 */
public class TextPicture extends Picture{
	
	/**
	 * Declare instance Variables
	 */
	private String text;
	private Font newfont;
	
	/**
	 * default constructor
	 */
	public TextPicture(String text) {
		super();	//calls the picture default constructor
		this.text = text;
		this.newfont = new Font("Times New Roman", Font.PLAIN, 18);	//sets the font
		//calls the paint method
		repaint();
	}
	
	/**
	 * second overloaded constructor
	 */
	public TextPicture(String text, int x, int y) {
		super();
		setxPos(x);
		setyPos(y);
		this.text = text;
		this.newfont = new Font("Times New Roman", Font.PLAIN, 18);	//sets the font
		repaint();
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
		repaint();
	}

	/**
	 * @param newfont the newfont to set
	 */
	public void setFont(Font newfont) {
		this.newfont = newfont;
		repaint();
	}

	/**
	 *  override paint from Picture
	 */
	public void paint(Graphics g) {
		//setting the color of the text
		g.setColor(getC());
		g.setFont(newfont);	//setting the font of the text
		g.drawString(this.text, getxPos(), getyPos());	//drawing the text
	}

	/**
	 * @param args
	 * A self testing main method
	 */
	public static void main(String[] args) {
		//create the JFrame
		JFrame f = new JFrame("Testing my class");
		
		//create an TextPicure object
		TextPicture i = new TextPicture("My Title", 30, 50);
		
		f.setSize(400, 350);
		f.add(i);
		f.setVisible(true);
		
		//pause
		JOptionPane.showMessageDialog(null, "Enter OK to get the text in new position");
		
		//move the text
		i.setxPos(80);
		i.setyPos(100);
		
		//pause
		JOptionPane.showMessageDialog(null, "Enter OK to get the text in new color");
		
		i.setColor(Color.DARK_GRAY);	//changing the color of the text
		f.setVisible(true);
		
		//pause
		JOptionPane.showMessageDialog(null, "Enter OK to get the text in new color and new font");
		
		//changing the text
		i.setText("New Title");
		Font newFont = new Font("Comic Sans MS", Font.ITALIC, 36);	//changing the font of the new text
		i.setFont(newFont);	//setting the font of the text
		i.setColor(Color.ORANGE);	//changing the color
	}

}
