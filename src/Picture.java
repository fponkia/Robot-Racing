import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Foram Patel
 * Date: May 23, 2021
 * Description: Creates a Picture that can be drawn on a window
 * Methods / Constructors: public Picture(): default constructor to initialize the variables.
 * 	public Picture(int x, int y, int w, int h): overloaded constructor to initialize the variables.
 *	public void setColor(Color c): Method to set color.
 *	public void setxPos(int xPos): Method to set x position.
 *	public void setyPos(int yPos): Method to set y position.
 *	public void setMyWidth(int myWidth): Method to set width of the picture.
 *	public void setMyHeight(int myHeight): Method to set height of the picture.
 *	public Color getC(): Method to get the color of the pixture.
 *	public int getxPos(): Method to get the x position.
 *	public int getyPos(): Method to get the y position.
 *	public int getMyWidth(): Method to get the width.
 *	public int getMyHeight(): Method to get the height.
 *	public void paint(Graphics g): Method to print on the JFrame.
 *	public static void main(String[] args): A self testing main method.
 */
public class Picture extends JComponent {
	
	//Instance Variables
	private Color c;
	private int xPos, yPos, myWidth, myHeight;
	
	/**
	 * default constructor
	 */
	public Picture() {
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		repaint();	//call my paint method
	}
	
	/**
	 * Overloaded Constructor
	 */
	public Picture(int x, int y, int w, int h) {
		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}
	
	/**
	 * Method to set a new Color
	 */
	public void setColor(Color c) {
		this.c = c;
		repaint();
	}
	
	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	}

	/**
	 * @param myWidth the myWidth to set
	 */
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	/**
	 * @param myHeight the myHeight to set
	 */
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}
	
	/**
	 * @return the c
	 */
	public Color getC() {
		return c;
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @return the myWidth
	 */
	public int getMyWidth() {
		return myWidth;
	}

	/**
	 * @return the myHeight
	 */
	public int getMyHeight() {
		return myHeight;
	}

	/**
	 * Paint Method / overriding from JComponent
	 */
	public void paint(Graphics g) {
		g.setColor(this.c);  //set my own color
		//draws the picture
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.drawOval(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.fillOval(this.xPos + (this.myWidth/3), this.yPos, (this.myWidth/3), this.myHeight);
	}
	
	/**
	 * @param args
	 * A self Testing main method
	 */
	public static void main(String[] args) {
		//create a window to try my picture
		JFrame f = new JFrame("Testing Window");
		
		//create an object of Picture
		Picture p = new Picture();
		
		//set the size of the JFrame.
		f.setSize(400, 350);
		
		f.add(p);	//add p to the frame
		
		f.setVisible(true);  // paints the JFrane and anything in it.
		
		// call A dialog Box to wait
		JOptionPane.showMessageDialog(null, "Wait");
		
		//Create a second picture using the new constructor
		Picture p1 = new Picture(200, 50, 100, 150);
		
		f.add(p1);	//add it to the JFrame
		f.setVisible(true);
		
		// call A dialog Box to wait
		JOptionPane.showMessageDialog(null, "Wait");
		p1.setColor(Color.BLUE);
		
		// call A dialog Box to wait
		JOptionPane.showMessageDialog(null, "Wait");
		
		//set dimensions
		p.setxPos(0);
		p.setyPos(0);
		p.setMyWidth(300);
		p.setMyHeight(50);
		
	}

}
