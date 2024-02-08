/**
 * 
 */

/**
 * @author Foram Patel
 * Date: May 18, 2021
 * Description: A class to create dice, roll them and compare the values.
 * Methods or constructors: public Die(): a default constructor to initialize the faces of the die and roll it.
 * 	public Die(int faces): an overloaded constructor to initialize the faces of the die and roll it.
 * 	public void rollDie(): an non-static method to roll a die and store the value of the die to a variable.
 * 	public int getValue(): an non-static method to return the value of the die that was stored in a variable during the time of roll.
 * 	public boolean CompareTo(Die d): an non-static method that takes an object as an argument and compare the values of the passed die 
 * 			with the other die and returns true of the value is same otherwise false.
 * 	public static void main(String[] args): A self testing main method
 */
public class Die {

	/**
	 * Data/Attributes/Instances Variables
	 */
	private int faces;
	private int value;

	/**
	 * Default constructor for die
	 * Creates a normal die
	 */
	public Die() {
		// initialize the attributes or your data
		faces = 6;
		//roll my die to fill in a value
		rollDie();
	}

	/**
	 * Create a new overloaded constructor
	 * Polymorphism
	 */
	public Die(int faces) {
		//initialize my instance variables
		this.faces = faces;
		// roll die
		rollDie();
	}

	/**
	 * Method to roll a die
	 */
	public void rollDie() {	
		//generates a random number from 1 to the value of faces
		this.value = (int)(Math.random() * this.faces + 1);
	}

	/**
	 * A method to get the value
	 */
	public int getValue(){
		return this.value;
	}

	/**
	 * This method compares the value of the dice and returns true if both has same value, else false.
	 */
	public boolean CompareTo(Die d) {
		//comparing the value of the die passed as argument with the another die
		if(this.value == d.getValue()) {
			return true;	//returns true if value for both dice is same.
		}
		else {
			return false;
		}

	}

	/**
	 * @param args
	 * A self testing main method
	 */
	public static void main(String[] args) {
		//create one die
		Die d; //declares d as a Die
		d = new Die(); // calls the constructor
		
		System.out.println("Displaying the values of the dice");
		System.out.println(d.getValue());	//reads its value

		//create a second Die
		Die d1 = new Die();

		System.out.println(d1.getValue());	//reads its value
		
		System.out.println();
		System.out.println("Displaying the value of two dice that were rolled 10 times:");
		//roll the dice 10 times
		for (int i = 1; i <= 10; i++){
			d.rollDie();
			d1.rollDie();

			System.out.println(d.getValue() + " " + d1.getValue());
		}
		
		System.out.println();
		System.out.println("Displaying the value of two dice that has 12 sides:");
		//test the new constructor
		Die d2 = new Die(12);
		//get the value
		System.out.println(d2.getValue());

		//roll the new Die
		d2.rollDie();
		//get the value
		System.out.println(d2.getValue());
		
		System.out.println();
		System.out.println("Comparing the values of two dice that has 6 sides, 10 times:");
		
		//running loop for 10 times to see how many times does both the dice has same value
		int count = 0;
		for(int i=0;i<10;i++) {
			
			//rolling the dice
			d.rollDie();
			d1.rollDie();
			
			//comparing the value, if same than adding the variable count by 1
			if(d.CompareTo(d1)) {
				count++;
			}
			//displaying the values for both dice and whether it is same or not.
			System.out.println(d.CompareTo(d1) + " " + d.getValue() + " " + d1.getValue());
		}
		System.out.println("Both the Dice has same value for " + count + " times in 10 trys.");

	}

}
