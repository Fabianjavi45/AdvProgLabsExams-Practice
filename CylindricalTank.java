package Exam1;
public class CylindricalTank {

	private String idTag;			// Unique String identifying the tank
	private double radius;			// The non-negative radius of the base of the tank in meters
	private double height;			// The non-negative height of the tank in meters
	private double liquidLevel;		// The current height of the liquid in the tank in meters

	/**
	 * CylindricalTank General Constructor
	 */
	public CylindricalTank(String tag, double radius, double height, double liquidLevel) {
		super();
		this.idTag = tag;
		this.radius = radius;
		this.height = height;
		this.liquidLevel = liquidLevel;
	}

	/**
	 * Exercise #1
	 * Copy Constructor creates a tank with the same properties as the parameter tank.
	 */
	public CylindricalTank(CylindricalTank t) {
		return;
	}

	// Getters
	public String getIdTag() { return idTag; }
	public double getRadius() { return radius; }
	public double getHeight() { return height; }
	public double getLiquidLevel() { return liquidLevel; }

	// Setters
	public void setRadius(double radius) { this.radius = radius; }
	public void setHeight(double height) { this.height = height; }
	public void setLiquidLevel(double liquidLevel) { this.liquidLevel = liquidLevel; }

	// Instance Methods

	/**
	 * Returns true if both the target and parameter tanks have the same id
	 */
	public boolean equals(Object t2) {
		if (t2 instanceof CylindricalTank) {
			CylindricalTank ct = (CylindricalTank) t2;
			return this.getIdTag().equals(ct.getIdTag());
		}
		return false;
	}

	/**
	 * Returns the Cylindrical Tank as a string.
	 */
	public String toString() {
		return "CylindricalTank[id=" + this.getIdTag() + "]";
	}

	/**
	 * Returns the maximum volume of liquid that the tank can hold in cubic meters.
	 */
	public double getCapacity() {
		return Math.PI * this.radius * this.radius * this.height;
	}

	/**
	 * Returns the current volume of liquid that the tank holds in cubic meters.
	 */
	public double getLiquidVolume() {
		return Math.PI * this.radius * this.radius * this.liquidLevel; 
	}

	/**
	 * Exercise #2
	 * Returns the current volume of liquid that the tank can hold in gallons.
	 * 
	 * Hint: 1 Cubic Meter is equivalent to 264 US Gallons.
	 */
	public double getLiquidVolumeInGallons() {
		return 0; 
	}
	
	/**
	 * Exercise #3
	 * Compares the capacity (volume) of the target tank and the parameter tank.  
	 * Returns 0 if they have the same capacity, 1 if the target tank has larger capacity
	 * and -1 otherwise.
	 */
	public int compareTo(CylindricalTank t) {
		return 0; 
	}

	/**
	 * Exercise #4
	 * Modifies the target tank and add to it as much of the volume of liquid specified 
	 * by the cubicMeters parameters as possible.  If the tank cannot hold all the liquid then it
	 * should become full and the remainder of the liquid should be simply ignored. 
	 * 
	 * Note: This method must return the instance object (this).
	 */
	public CylindricalTank add(double cubicMeters) {
		// YOUR CODE HERE
		
		return this; // Leave return as is as the method should return target object
	}

	
	/**
	 * Exercise #5
	 * Returns a string indicating the percent of its volume that the tank is full ignoring 
	 * any fractional part. For instance if the tank is exactly half way full the method should return the
	 * String "50% Full".  If the tank is exactly one third full the method should return the
	 * String "33% Full".  If the tank is empty the method should return the String "Empty".
	 * HINT: To convert a double to an int you can cast it as follows (int)5.3 yields 5.
	 */
	public String getPercentFilled() {
		return null;
	}
}