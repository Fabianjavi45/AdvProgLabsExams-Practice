package Exam1;
/*
 * The soldier now needs you help in order to build his new Weapon.
 */

public class Weapon {
	private String name;
	private char type;		// 'M' = Manual, 'S' = Semi-Automatic and 'A' = Automatic
	private int damage;
	private int ammo;

	/* In order to construct a new Weapon for the soldier you will need to implement
	 * it's constructor. Make sure to initialize every instance variable.
	 * IMPORTANT: IN ORDER TO TEST THE CONSTRUCTOR YOU NEED TO IMPLEMENT THE GETTERS.
	 */
	public Weapon(String name, char type, int damage, int ammo) {
		this.name=name;
		this.type=type;
		this.damage=damage;
		this.ammo=ammo;
		
		
	}

	/* 
	 * Implement getters and setters.
	 */
	public String getName() {
		return name; // Dummy return.
	}

	public char getType() {
		// WRITE YOUR CODE HERE
		return type; // Dummy return.
	}

	public int getDamage() {
		// WRITE YOUR CODE HERE
		return damage; // Dummy return.
	}

	public int getAmmo() {
		// WRITE YOUR CODE HERE
		return ammo; // Dummy return.
	}

	public void setName(String name) {
		this.name=name;
		
	}

	public void setType(char type) {
		this.type=type;
		
	}

	public void setDamage(int damage) {
		this.damage=damage;// WRITE YOUR CODE HERE
		
	}

	public void setAmmo(int ammo) {
		this.ammo=ammo;
		// WRITE YOUR CODE HERE
	}

	/* Your partner needs a copy of the weapon that you have. Create the new weapon by 
	 * completing the method below.
	 * Hint: You need to create a new Weapon, you cannot edit your own.
	 */
	
	public Weapon craftACopy() {
		
		Weapon copy = new Weapon(this.name, this.type, this.damage, this.ammo);
		// WRITE YOUR CODE HERE
		return copy; // Dummy return.
	}
	
	/* Return true if the target and parameter objects are the same, return false otherwise.
	 * Two objects are considered equal if their instance variables are the same.
	 * Hint #1: Use the variable weapon to compare against the target object.
	 * Hint #2: Compare primitive data types with == and classes with its respective equals method.
	 */
	@Override
	public boolean equals(Object w) {
		Weapon weapon = (Weapon) w;// <== Make sure to use this variable.
		if(!(w instanceof Weapon)) {
			return false;
			}
		
		else if (weapon.getName().equals(name) && this.ammo==weapon.getAmmo() 
				&& this.type==weapon.getType() 
				&& this.damage==weapon.getDamage()) {
			return true;
		}
		else return false;
	
		
	}

	/* Return the instance variables in a String.
	 * The format should be something like the following:
	 * Name: <name>, Type: <type>, Damage: <damage>, Ammo: <ammo>
	 * IMPORTANT: BE SURE TO TYPE IT EXACTLY AS SHOWN AND ONLY CHANGE WHAT IS INSIDE DE ANGLE BRACKETS.
	 */
	@Override
	public String toString() { 
		return "Name: " + this.getName().toString() + ", " + "Type: " + this.type + 
				", " + "Damage: " + this.damage + ", " + "Ammo: " + this.getAmmo(); // Dummy return.
	}


	/* The soldier needs your help to reload his Weapon.
	 * In the following method you will receive an amount of ammo
	 * and a exponent. This amount you will need to elevate it with
	 * the exponent variable provided and assign it to the ammo instance variable.
	 * The formula is: amount ^(exponent).
	 * Hint #1: Look for the Math class in the Java 8 API and observe the predefined methods.
	 * Hint #2: Be sure to add the old amount of ammo too.
	 */ 

	public void reload(int amount, double exponent) {
	this.ammo+=Math.pow(amount, exponent);
		// WRITE YOUR CODE HERE
	}
}