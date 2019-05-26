package Exam1;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/*
 * A soldier needs our help!
 * Find the methods below and implement them in order to support him.
 */

public class Soldier {
	private String firstName;
	private String lastName;
	private String tag;
	private String rank;
	private Point position;

	public Soldier(String firstName, String lastName, String tag, String rank, Point position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tag = tag;
		this.rank = rank;
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTag() {
		return tag;
	}

	public String getRank() {
		return rank;
	}

	public Point getPosition() {
		return position;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNumberTag(String tag) {
		this.tag = tag;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	/* You must return the distance of the target soldier to the point battle given as a parameter.
	 * the formula of distance of two points P1(X1,Y1) and P2(X2,Y2) is ((Y2 - Y1)^2 + (X2 - X1)^2) ^1/2 
	 * Hint: Look for the Point class in the Java 8 API and observe the predefined methods.
	 */

	public double distanceToBattle(Point battle) {

		return battle.distance(position.getX(), position.getY());
		// Dummy return.
	}

	/* Using the enemyZone parameter and the soldiers position determine if the soldier is inside
	 * or in the edge of the danger zone.
	 * Hint: Look for the Rectangle class in the Java 8 API and observe the predefined methods.
	 */
	public boolean inDanger(Rectangle enemyZone) {
		if(position.getX()<=enemyZone.getWidth()+enemyZone.getX() 
		&& position.getX()>=enemyZone.getX() 
		&& position.getY()<=enemyZone.getHeight()+ enemyZone.getY() && position.getY()>=enemyZone.getY()){
			return true;
		}
		else return false;
		// WRITE YOUR CODE HERE
		// Dummy return.
	}

	/*
	 * The soldier has setup the radio to communicate with his base, but after a while the
	 * radio stopped working. He suspects that he needs to change the frequency in order to make
	 * it work again. Help him find the right frequency. Remember that the formula for sinusoidal
	 * functions is y = A*sin(2*PI*f*t + theta).
	 * Hint: Look for the Math class in the Java 8 API and observe the predefined methods and fields.
	 */
	public double getRadioFrequency(double y, double amplitude, double time, double theta) {
		return (Math.asin(y/amplitude)-theta)/(2*Math.PI*time); 
	}

	/*
	 * The Soldier lost his tag in battle and he needs to get a new one.
	 * All tags are numbers of 6 digits. Generate a new tag changing the last
	 * 3 digits with random numbers.
	 * Hint: Look for the Random class in the Java 8 API and observe the predefined methods.
	 */
	public void newTag(){
		Random rand= new Random();
		int randNum1= rand.nextInt(10);
		int randNum2= rand.nextInt(10);
		int randNum3= rand.nextInt(10);

		this.tag = tag.substring(0,3).concat(String.valueOf(randNum1) +
				String.valueOf(randNum2)+ 
				String.valueOf(randNum3));
		// WRITE YOUR CODE HERE

	}

	/*
	 * A newly formed squad is looking for a leader. Decide who has more experience
	 * on their hands between the target and parameter soldier, then return their last
	 * name so the new squad know who he is. The name parameter has the following format: S.Rodriguez.
	 * Where S is the initial of the first name and Rodriguez is the last name. Also, for the sake
	 * of this exercise we will assume that there are three ranks: Captain, Major and Sergeant.
	 * Captain is the highest rank, then Major and then Sergeant.
	 * Hint: Ranks are in lexicographical order.
	 */
	public String teamLeader(String rank, String name) {
		
		if(rank.compareTo(this.rank)<0){
		return name.substring(2);
		}
		else {
			return this.lastName;
		}
		 // Dummy return
	}
}
