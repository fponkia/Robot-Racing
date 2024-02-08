import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author Foram Patel
 * Date: June 4, 2021
 * Description: A user interface class that completes the race of the droids and has a menu screen through which names of the droids and team can be changed.
 * Methods / Constructor: public GalaxyGame(): creates the JFrame and also add its components to the frame, it is the menu part of the game.
 * 	public void addtoframe(String text, String text1, int x, int y): A method that adds the text and JTextField to the menu frame.
 * 	public void addimage(String imageName, int i): A method that adds images of the droid to the new JFrame.
 * 	public void reposition(): A method that reposition the images of droid and also reinitialize its variables.
 * 	public void actionPerformed(ActionEvent e): This method gets called when any of the button got clicked.
 * 	public static void main(String[] args): A method to create the object to call the constructor.
 */
public class GalaxyGame extends JFrame implements ActionListener {

	//Instance Variables
	private JPanel drawingPanel, controlPanel, controlPanel1, drawingPanel1;
	private ImagePicture img, img1, img2;
	private Droid image[];
	private TextPicture text, textarray[];
	private JTextField nameInput[];
	private JButton btncontinue, btnexit, btnstart, btnstop, btnrestart, btnMenu, btnexit1, btnscores;
	private JFrame frame;
	private Die d, d1;
	private int xPos[], count[], i, laps, y, lapscount[];
	private boolean movingLeft[], finish;
	private Timer timer;
	/**
	 * Constructor
	 */
	public GalaxyGame() {
		super("Galaxy Game");
		setLayout(null);	//sets the layout of the frame to null

		drawingPanel = new JPanel();	//creating drawing panel and control panel and setting the boundaries to each
		drawingPanel.setBounds(0, 0, 900, 430);
		drawingPanel.setLayout(null);  // set layout of drawing panel to null
		controlPanel = new JPanel();
		controlPanel.setBounds(0, 430, 900, 70);

		text = new TextPicture("Droid Race", 350, 30);	//creating the title of the menu
		text.setFont(new Font("Comic Sans MS", Font.BOLD , 36));
		text.setColor(Color.CYAN);
		text.setBounds(0, 0, 900, 40);	//setting boundaries of the title
		add(text);	//adding text to the JFrame

		img1 = new ImagePicture(new ImageIcon("r2d2.jpg"));	//creating the image and adding it to the drawing Panel
		img1.setBounds(100, 180, drawingPanel.getWidth(), drawingPanel.getHeight());
		drawingPanel.add(img1);

		img2 = new ImagePicture(new ImageIcon("c2po.jpg"));	//creating another image and adding it to the drawing Panel
		img2.setBounds(540, 180, drawingPanel.getWidth(), drawingPanel.getHeight());
		drawingPanel.add(img2);

		img = new ImagePicture(new ImageIcon("galaxy.jpg"));	//creating the image for the background and adding it to the drawing Panel at the end.
		img.setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());

		textarray = new TextPicture[7];	//creating the array for the TextPicture and JTextField.
		nameInput = new JTextField[7];
		i = 0;	//initializing the variable to 0, as the array index starts from the 0.
		
		//calling the method addtoframe to add text and JTextField to all the location needed, to input the name of the team and players
		//calling methods for both the team one after another, makes sure that information for a team gets created and stored in alternative locations.
		addtoframe("Please Enter the Name of the Team 1 (It has R2D2 Droids)","Team 1", 90, 50);	//gets created and stored in index 0 of both the arrays
		addtoframe("Please Enter the Name of the Team 2 (It has C3PO droids)", "Team 2", 540 , 50 );	//gets created and stored in index 1 of both the arrays
		
		addtoframe("Please Enter the Name of the Player 1","First R2D2", 90, 90);	//gets created and stored in index 2 of both the arrays
		addtoframe("Please Enter the Name of the Player 1","First C3PO", 540 , 90 );	//gets created and stored in index 3 of both the arrays
		
		addtoframe("Please Enter the Name of the Player 2","Second R2D2", 90, 130);	//gets created and stored in index 4 of both the arrays
		addtoframe("Please Enter the Name of the Player 2","Second C3PO", 540 , 130 );	//gets created and stored in index 5 of both the arrays
		addtoframe("Please Enter how many laps do you want", "1", 300 , 150 );	//gets created and stored in index 6 of both the arrays

		//creating the objects of the die class.
		d = new Die();
		d1 = new Die();
		
		//creating and adding button to the controlPanel.
		btncontinue = new JButton("Continue");
		controlPanel.add(btncontinue);
		btnexit = new JButton("Exit");
		controlPanel.add(btnexit);
		
		// add button as a listener in this frame
		btncontinue.addActionListener(this);
		btnexit.addActionListener(this);
		
		//adding panels to the frame
		add(drawingPanel);
		add(controlPanel);
		drawingPanel.add(img);	//adding background image to the drawingPanel.
		
		//setting size, resizable and visibility of the JFrame
		setSize(900, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addtoframe(String text, String text1, int x, int y) {
		textarray[i] = new TextPicture(text, x, y);	//creating the text/title for the information about the JTextField
		textarray[i].setFont(new Font("Comic Sans MS", Font.BOLD , 10));	//setting the font
		textarray[i].setColor(Color.CYAN);	//setting the color.
		textarray[i].setBounds(0, 0, 900, y+5);	//setting the boundaries for the title
		add(textarray[i]);	//adding title to the frame

		nameInput[i] = new JTextField(text1, 15);	//creating the JTextField for the user to enter information, which is asked.
		nameInput[i].setBounds(x, y+10, 150, 20);	//setting boundaries for the JTextField
		drawingPanel.add(nameInput[i]);	//adding JTextField to the frame
		i++;	//makes sure that the next text/title and JTextField gets created and stored in next index.
	}

	public void addimage(String imageName, int i) {
		image[i] = new Droid(new ImageIcon(imageName));	//creating the images of the droids
		image[i].setBounds(0, y, drawingPanel1.getWidth(), drawingPanel1.getHeight());	//setting boundaries for droid
		drawingPanel1.add(image[i]);	//adding images of droid to the drawingPanel of the second JFrame
		
		//setting different variables such as xPos, lapscount, y, count, movingLeft to some initial values, 0 or false.
		xPos[i] = 0;
		lapscount[i] = 0;
		y += image[i].getMyHeight()+15;	//determines how much down the other image has to be created from the top of the drawingPanel1.
		count [i] = 0;	//counts the number of Steps taken by the droid
		movingLeft[i] = false;
	}
	
	public void reposition() {
		//reinitialize the variables to the one that were initially assigned just before starting the race
		for(int i=0;i<4;i++) {
			image[i].setxPos(0);
			count[i] = 0;
			image[i].setNumberofsteps(0);
			lapscount[i] = 0;
			xPos[i] = 0;
			movingLeft[i] = false;	//determines that image is moving towards right
			finish = false;	//determines that race is not complete.
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btncontinue) {	//if button gets clicked
			setVisible(false);	//sets the initial JFrame to not visible.
			frame = new JFrame("Droid Race Game");	//creates new JFrame

			drawingPanel1 = new JPanel();	//creating drawingPanel1 and controlPanel1 for the new Frame and settings boundaries.
			drawingPanel1.setBounds(0, 0, 900, 430);
			drawingPanel1.setLayout(null);
			controlPanel1 = new JPanel();
			controlPanel1.setBounds(0, 430, 900, 70);
			
			//creating and initializing size of the various arrays that are going to be used in race.
			image = new Droid[4];
			xPos = new int[image.length];
			movingLeft = new boolean[image.length];
			lapscount = new int[image.length];
			count = new int [image.length];
			y = 0;	//determines were the initial image of droid is going to get created in y position. 
			
			for(int i=0;i<4;i++) {	//images of the team 1 players are stored in index 0 and 2, while images of team 2 players are stored in index 1 and 3, because of the way the array "textarray" and "nameInput" are used, alternatively.
				addimage("R2D2.png", i);	//creates the image of the player of team 1
				addimage("C3PO.png", ++i);	//creates the image of the player of team 2, ++i determine that image of team 2 players gets stored in the next index.
			}

			img = new ImagePicture(new ImageIcon("galaxy.jpg"));	//creating image for the background and adding it to the drawingPanel1.
			img.setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());	//setting boundaries.
			drawingPanel1.add(img);
			
			//creating various buttons and adding it to the controlPanel1.
			btnstart = new JButton("Start");
			controlPanel1.add(btnstart);
			btnrestart = new JButton("Re-Start");
			controlPanel1.add(btnrestart);
			btnstop = new JButton("Stop");
			controlPanel1.add(btnstop);
			btnexit1 = new JButton("Exit");
			controlPanel1.add(btnexit1);
			btnMenu = new JButton("Go Back To Menu");
			controlPanel1.add(btnMenu);
			btnscores = new JButton("HighScores of the last 5 games");
			controlPanel1.add(btnscores);
			
			// add button as a listener in this frame
			btnstart.addActionListener(this);
			btnrestart.addActionListener(this);
			btnstop.addActionListener(this);
			btnexit1.addActionListener(this);
			btnMenu.addActionListener(this);
			btnscores.addActionListener(this);

			timer = new Timer (200, this);  //creates a timer and this class as the listener. set to fire every 200ms
			timer.setInitialDelay (5); //set the initial delay to 5 ms before it starts
			timer.addActionListener(this);	//adding timer as a listener in this frame

			frame.add(drawingPanel1);	//adding drawingpanel1 and controlPanel1 to the new frame.
			frame.add(controlPanel1);
			frame.setSize(900, 500);	//setting the size, visibility, layout, resizable of the new frame.
			frame.setLayout(null);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else if(e.getSource() == btnexit) { //if button gets clicked
			dispose();	//dispose the menu part of the JFrame, thus program gets end
		}
		else if (e.getSource() == btnstart) {	//if button gets clicked
			timer.start();	//starts the timer.
		}
		else if(e.getSource() == timer) {	//if button gets clicked
			
			laps = Integer.parseInt(nameInput[6].getText());	//stores the number of laps, droids has to run for the race.
			for(int i=0;i<image.length;i++) {	//moving each droids one by one.
				if(finish == false) {	//checks whether race is finish or not, if false then race is not finish.
					
					d.rollDie();	//rolls the die
					d1.rollDie();
					int sum = d.getValue()+d1.getValue();	//calculates the total value of the both the dice.
					
					if(sum != 2 || sum != 3 || sum != 12) {	//if sum is not equal to 2, 3, or 12 then droid gets chance to move.
						if(movingLeft[i] == true) {
							xPos[i] -= sum; //determines the new x-position of the image. -ve sign determines that image will move left.
						}
						else {
							xPos[i] += sum;	//determines the new x-position of the image. +ve sign determines that image will move right.
						}
						image[i].setNumberofsteps(image[i].getNumberofsteps()+sum);	//sets the number of steps the image has taken so far.
						
						if (xPos[i] >= (drawingPanel.getWidth() - image[i].getMyWidth())){
							movingLeft[i] = true;   // reverse the direction and turns moving left variable to true, which means now image is moving left.
							lapscount[i] += 1;	//adds one to the number of laps completed
							int out = xPos[i] - (drawingPanel.getWidth() - image[i].getMyWidth());	//determine how many steps image has to take after hitting the maximum limit of drawing panel.
							xPos[i] = (drawingPanel.getWidth() - image[i].getMyWidth())-out;	//remaining steps were taken in the opposite direction.
						}
						else if (xPos[i]<= 0 ){
							movingLeft[i] = false;   // reverse the direction and turns moving left variable to false, which means now image is moving right.
							lapscount[i] += 1;	//adds one to the number of laps completed
							int out = 0 - xPos[i] ;	//determine how many steps image has to take after hitting 0 x-position of the drawing panel.
							xPos[i] = out;	//remaining steps were taken in the opposite direction.
						}// if x pos
						image[i].setxPos(xPos[i]);	//sets the image to new x-position
					}
					
					if(lapscount[i] == laps) {	//checks whether the image has completed the laps or not.
						String teamwin = "";
						if(i%2==0)	//determines which team has won the game.
							teamwin = nameInput[0].getText();	//if divisible by 2, than team 1 has won the game.
						else
							teamwin = nameInput[1].getText();	//if not divisible by 2, than team 2 has won the game.
						finish = true;	//determines that game/race has completed.
						
						for(int k = 0;k<image.length;k++) {
							count[k] = image[k].getNumberofsteps();	//stores the number of steps taken by each image to a new variable.
						}
						try {
							count = HighScores.scores(count, "HighScores.txt");	//sends the number of steps taken by each image to calculate scores of each and store it to the same variable.
						} 
						catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Sorry File or information not found");
						}
						
						String output="";
						output = output + "Winner of the Game is " + nameInput[i+2].getText() +" of team "+ teamwin + ".\n\n";	//adding information of this game to the String variable. plus 2 in the array is used because first two indexes of the array are for the names of teams.
						for(int j=0;j<4;j++) {
							output = output + "Scores of " + nameInput[j+2].getText() + " in this game is " + count [j] + "\n";	//adding information of this game to the String variable. plus 2 in the array is used because first two indexes of the array are for the names of teams.
						}
						JOptionPane.showMessageDialog(null, output);	//displays the information of who won this game and what were the score of each droids.
						timer.stop();	//stops the timer.
					}
				}
			}
		}
		else if(e.getSource() == btnrestart) {
			reposition();	//reposition the images and reinitialize its data.
			timer.start();	//starts the timer.
		}
		else if(e.getSource() == btnstop) {
			timer.stop();	//stops the timer.
		}
		else if(e.getSource() == btnMenu) {
			setVisible(true);	//set the old JFrame to visible
			frame.setVisible(false);	//sets the new JFrame to not visible.
			reposition();	//reposition the images and reinitialize its data.
			timer.stop();	//stops the timer
		}
		else if(e.getSource() == btnexit1) {
			System.exit(0);	//terminates the program
		}
		else if(e.getSource() == btnscores) {
			int highscores[];
			try {
				highscores = HighScores.loader("HighScores.txt");	//loads the information stored in file to an array
				String output = "";
				output = output + "HighScores for the last five Games are:\n";
				for(int i = 0; i < highscores.length;i++) {
					output = output + highscores [i] + "\n";	//stores each line of the array to a string.
				}
				JOptionPane.showMessageDialog(null, output);	//displays the highscores of the last 5 game through string.
			} 
			catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Sorry File or information not found");
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GalaxyGame game = new GalaxyGame();	//creates the object to run the program.
	}
}
