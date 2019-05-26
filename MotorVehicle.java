package Exam2;

import java.util.ArrayList;

public class MotorVehicle {

	private String make;
	private String model;
	private String licensePlate;
	private int year;
	private double mileage;

	private int warrantyYears;
	private double warrantyMileage;

	/*
	 * Constructs a new MotorVehicle with the given parameters
	 */
	public MotorVehicle(String make, String model, String licensePlate, int year, double mileage, int wy, double wm) {
		this.make = make;
		this.model = model;
		this.licensePlate = licensePlate;
		this.year = year;
		this.mileage = mileage;
		this.warrantyYears = wy;
		this.warrantyMileage = wm;
	}

	/*
	 * Contructs a new MotorVehicle object with the same properties as parameter mv
	 */
	public MotorVehicle(MotorVehicle mv) {
		this.make = mv.make;
		this.model = mv.model;
		this.licensePlate = mv.licensePlate;
		this.year = mv.year;
		this.mileage = mv.mileage;
		this.warrantyYears = mv.warrantyYears;
		this.warrantyMileage = mv.warrantyMileage;
	}

	// Getters
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public int getYear() {
		return year;
	}
	public double getMileage() {
		return mileage;
	}

	public int getWarrantyYears() {
		return warrantyYears;
	}

	public double getWarrantyMileage() {
		return warrantyMileage;
	}

	// Instance methods

	/*
	 * Add given additionalMileage to the target MotorVehicle. Modifies the target object.
	 * 
	 */
	public void addMileage(double additionalMileage) {
		this.mileage += additionalMileage;
	}

	/*
	 * Returns the average miles per year achieved by the target MotorVehicle
	 * Average Mileage = mileage / (currentYear - VehicleYear)
	 */
	public double milesPerYear(int currentYear) {
		int totalYears = Math.max(currentYear-this.year, 1);
		return this.mileage / totalYears;
	}

	/*
	 * Returns true if the target MotorVehicle is still under warranty
	 * A MotorVehicle is still under warranty if it has NOT surpassed the warranty years NOR the warranty mileage
	 */
	public boolean underWarranty(int currentYear) {
		return ((currentYear - this.year) < this.warrantyYears) && (this.mileage <= this.warrantyMileage);
	}

	/*
	 * Returns the MotorVehicle with the least mileage in the given vehicles list 
	 */
	public static MotorVehicle findLeastMileage(MotorVehicle[] vehicles) {
		MotorVehicle min = vehicles[0];
		for (int i = 1; i < vehicles.length; i++) {
			if(min.mileage>vehicles[i].mileage)
				min=vehicles[i];
		}
		return min; // Dummy return
	}

	/*
	 * Returns the list of vehicles in the given inventory with the same make and model as the target vehicle
	 * The returned array must not contain any empty spaces.
	 * The original inventory should not be modified.
	 */
	public MotorVehicle[] filterByMakeModel(MotorVehicle[] inventory) {
		ArrayList<MotorVehicle> arr= new ArrayList<MotorVehicle>();
		int count=0;
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i].make.equals(this.make)&& inventory[i].model.equals(this.model)){
				arr.add(inventory[i]);
				count++;
			}
		}
		MotorVehicle[] arr1= new MotorVehicle[count];
		arr.toArray(arr1);

		return arr.toArray(arr1); // Dummy return
	}

	/*
	 * Returns true if and only if all cars have less mileage than the target car
	 */
	public boolean allHaveLessMileage(MotorVehicle[] inventory) {
		for (int i = 0; i < inventory.length; i++) {
			if((inventory[i].mileage>this.mileage)){
				return false;
			}
		}
		return true; // Dummy return
	}

	/*
	 * Modifies the inventory array to add the target vehicle 
	 * at the end if the vehicle is not already in the inventory.
	 * Any remaining empty slots must lie at the end of the array.
	 * If cannot add vehicle because the inventory array is full, the 
	 * method returns null.  Otherwise the method returns the modified 
	 * inventory array.
	 */
	public MotorVehicle[] buy(MotorVehicle[] inventory) {

		for (int i = 0; i < inventory.length; i++) {
			if(this.equals(inventory[i])) return inventory;
		}
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i]==null){
				inventory[i]= this;
				return inventory;
			}
		}
		return null;
	}

}