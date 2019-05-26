package Exam2;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LineAL {

	private double slope;
	private double yIntercept;

	/*
	 * Constructs a Line object with the givel slope and y intercept
	 */
	public LineAL(double slope, double yIntercept) {
		this.slope = slope;
		this.yIntercept = yIntercept;
	}

	/*
	 * Constucts a Line object with the same properties as the parameter Line l
	 */
	public LineAL(LineAL l) {
		this.slope = l.slope;
		this.yIntercept = l.yIntercept;
	}

	/*
	 * Constructs a Line object that intersects both points p1 and p2
	 * HiNT: slope is given by deltay / deltax, and yIntercept = y - slope * x
	 */
	public LineAL(Point2D.Double p1, Point2D.Double p2) {
		slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		yIntercept = p1.getY() - slope * p1.getX();
	}

	// Getters and Setters
	public double getSlope() {
		return slope;
	}

	public double getYIntercept() {
		return yIntercept;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public void setYIntercept(double intercept) {
		this.yIntercept = intercept;
	}

	// Instance methods

	public boolean equals(Object o) {
		if (!(o instanceof LineAL)) return false;
		LineAL l = (LineAL) o;
		return (l.getSlope() == this.getSlope()) && (l.getYIntercept() == this.getYIntercept());
	}

	/*
	 * Returns the xIntercept of the target Line
	 * HINT: xIntercept = - yIntercept / slope
	 */
	public double xIntercept() {
		return (-yIntercept / slope);
	}

	/*
	 * Returns true iff the target Line is perpendicular to Line l2
	 * HINT: Two lines are perpendicular if slope1 = - (1 / slope2)
	 */
	public boolean isPerpendicular(LineAL l2) {
		double epsilon = 1e-10;
		double perpendicularSlope = - ( 1 / this.slope);
		return (Math.abs(perpendicularSlope - l2.slope) < epsilon);
	}

	/*
	 * Returns a new Line object representing the translation of the target Line
	 * by deltaX units horizontally and deltaY units vertically.
	 */
	public LineAL translate(double deltaX, double deltaY) {
		return new LineAL(this.slope, this.yIntercept + deltaY - (slope * deltaX));
	}

	/*
	 * Returns true if and only if some Line from the given list have the same slope as the target Line
	 */
	public boolean hasWithSameSlope(ArrayList<LineAL> list) {
		for (int i = 0; i < list.size(); i++) {
			if(this.getSlope()==list.get(i).getSlope())
				return true;
		}
		return false; // Dummy return
	}

	/*
	 * Adds the target Line at the end of the given list of Line's
	 * if the Line is not already in the list.
	 * If a Line with the same slope and intercept already exists, 
	 * then the list remains unchanged.
	 * Returns the unchanged or modified list
	 */
	public ArrayList<LineAL> addTo(ArrayList<LineAL> lines) {
	
		if(lines.contains(this)){
			return lines;
			}
		lines.add(this);
		
		return lines; //Dummy return
	}

	/*
	 * Returns true iff the given list of lines contains at least one
	 * pair of lines that are parallel.
	 * Remember that two lines are parallel if they have equal slopes
	 */
	public static boolean hasParellels(ArrayList<LineAL> lines) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i+1; j < lines.size(); j++) {
				if(lines.get(i).slope==lines.get(j).slope)
					return true;
			}
		}
		return false; // Dummy return
	}

	/* 
	 * Returns a new list of Line's containing all the Line's from the original
	 * list that are not horizontal.
	 * Remember that horizontal lines have slopes equal to zero.
	 */
	public static ArrayList<LineAL> notHorizontal(ArrayList<LineAL> lines) {
		ArrayList<LineAL> answer = new ArrayList<LineAL>();
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).slope!=0)
				answer.add(lines.get(i));
				
		}
		return answer; // Dummy return
	}

}