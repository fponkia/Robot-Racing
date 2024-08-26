import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Foram Patel
 * Date: 2021/06/02
 * Description: The droid class for the unit 2 summative
 * Methods: public Droid(ImageIcon img): A constructor to initialize the variables.
 * public int getNumberofsteps(): returns the number of steps the droid moved.
 * public void setNumberofsteps(int numberofsteps): sets the number of steps the droid moved.
 * public static void main(String[] args): A self testing main method.
 */
public class Droid extends ImagePicture {
	
	//variable to hold how many "steps" the droid moved
	private int numberofsteps;

	//Droid class constructor
	public Droid(ImageIcon img) {
		super(img);
		this.numberofsteps = 0;
	}

	
	//returns the number of steps the droid moved
	 
	public int getNumberofsteps() {
		return numberofsteps;
	}


	//sets the number of steps the droid moved
	public void setNumberofsteps(int numberofsteps) {
		this.numberofsteps = numberofsteps;
	}

	//testing the class in main function
	public static void main(String[] args) {

		//Creating a Droid Object
		Droid droid = new Droid(new ImageIcon("C3PO.png"));
		
		//Creating a JFrame to display
		JFrame f = new JFrame("Testing");
		
		//Configuring JFrame settings
		f.add(droid);
		f.setSize(400, 500);
		f.setVisible(true);
		f.setLocation(500, 100);

		//testing the get and set methods of the droid class
		System.out.println("Value of the numberofsteps Variable is: "+droid.getNumberofsteps());
		
		droid.setNumberofsteps(200);	//reassign the value to the variable stepsToMove
		System.out.println("New Value of the numberofsteps Variable is: "+droid.getNumberofsteps());


	}

}
