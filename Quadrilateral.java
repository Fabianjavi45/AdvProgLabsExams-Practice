package Exam1;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

/**
 * Mutable class to represent Quadrilaterals in the real plane.
 * 
 * A Quadrilateral is represented by four points in the plane 
 * p1, p2, p3 and p4. Each point in the plane has two coordinates 
 * <x,y> as usual. The four edges of the Quadrilateral are 
 * given by the segments <p1,p2>, <p2,p3>, <p3, p4> and <p4,p1>.
 * 
 * IMPORTANT: Quadrilaterals DO NOT share Point objects among 
 * themselves.  Every Quadrilaral must have its own set of Points 
 * that are separate instances from the points of other Quadrilaterals.
 */
public class Quadrilateral {
	
	private Point2D.Double p1;
	private Point2D.Double p2;
	private Point2D.Double p3;
	private Point2D.Double p4;
	
	// Constructors
	public Quadrilateral(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, Point2D.Double p4) {
		super();
		this.p1 = (Point2D.Double) p1.clone();
		this.p2 = (Point2D.Double) p2.clone();
		this.p3 = (Point2D.Double) p3.clone();
		this.p4 = (Point2D.Double) p4.clone();
	}
	
	/**
	 * Exercise #1 
	 * Returns a copy of the parameter Quadrilateral with COPIES
	 * of its points.  
	 * Note: The new Quadrilateral should not share any
	 * instances of Points with the original (parameter) Quadrilateral.
	 */
	public Quadrilateral(Quadrilateral q) {
		this.p1 = (Point2D.Double)q.p1.clone();
		this.p2 = (Point2D.Double)q.p2.clone();  
		this.p3 = (Point2D.Double)q.p3.clone();
		this.p4 = (Point2D.Double)q.p4.clone();
	}
	
	/**
	 * Exercise #2 
	 * Returns a new Quadrilateral equivalent to the parameter
	 * Rectangle.  
	 * The four points of the Quadrilateral should
	 * coincide with the four points of the Rectangle.  
	 * In
	 * particular point p1 in the Quadrilateral should coincide
	 * with the upper left corner point in the Rectangle.
	 */
	public Quadrilateral(Rectangle r) {
		Point2D.Double P1= new Point2D.Double(r.x, r.y);
		Point2D.Double P2= new Point2D.Double(r.x+r.width,r.y);
		Point2D.Double P3= new Point2D.Double(r.x+r.width,r.y+r.height);
		Point2D.Double P4= new Point2D.Double(r.x, r.y+r.height);
		this.p1=P1;
		this.p2=P2;
		this.p3=P3;
		this.p4=P4;
	}

	// Getters
	public Point2D.Double getP1() { return p1; }
	public Point2D.Double getP2() { return p2; }
	public Point2D.Double getP3() { return p3; }
	public Point2D.Double getP4() { return p4; }

	// Instance Methods
	
	public String toString() {
		return "<" + this.getP1() + this.getP2() + this.getP3() + this.getP4() + " >";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Quadrilateral) {
			Quadrilateral q = (Quadrilateral) o;
			return q.getP1().equals(this.getP1()) &&
					q.getP2().equals(this.getP2()) &&
					q.getP3().equals(this.getP3()) &&
					q.getP4().equals(this.getP4());
		}
		return false;
	}
	
	/**
	 * Exercise #3
	 * Returns the perimeter of the target Quadrilateral
	 * 
	 * The perimeter is the sum of the lengths of the four
	 * edges of the Quadrilateral.
	 */
	public double getPerimeter() {
		double p1p2=  Point2D.distance(this.p1.x, this.p1.y, this.p2.x, this.p2.y);
		double p2p3=  Point2D.distance(this.p2.x, this.p2.y, this.p3.x, this.p3.y);
		double p3p4=  Point2D.distance(this.p3.x, this.p3.y,this.p4.x, this.p4.y);
		double p1p4=  Point2D.distance(this.p1.x, this.p1.y, this.p4.x, this.p4.y);
		return p1p2+ p2p3+ p3p4 +p1p4; // Dummy return
	}
	
	/**
	 * Exercise #4
	 * Modifies the target Quadrilateral by moving all its Points by deltaX 
	 * units horizontally and deltaY unit vertically.  Both deltas
	 * can be either positive, negative or zero.
	 * 
	 */
	public Quadrilateral move(double deltaX, double deltaY) {
		this.p1.x+=deltaX;
		this.p1.y+=deltaY;
		this.p2.x+=deltaX;
		this.p2.y+=deltaY;
		this.p3.x+=deltaX;
		this.p3.y+=deltaY;
		this.p4.x+=deltaX;
		this.p4.y+=deltaY;
		
		return this; // Leave this return as is since method should return target object
	}
	
	/**
	 * Returns the area of a triangle given the lengths of its three sides
	 * using Heron's formula.
	 */
	private static double triangleArea(double s1, double s2, double s3) {
		double s = (s1 + s2 + s3) / 2.0;
		return Math.sqrt(s * (s-s1) * (s-s2) * (s-s3));
	}
	
	/**
	 * Exercise #5
	 * Returns the area of the target quadrilateral by dividing it in two
	 * triangles <p1, p3, p4> and <p1, p2, p3>.  You may assume that the
	 * target Quadrilateral is convex, that is, it can be divided in two
	 * triangles by adding a segment from opposite points.
	 */
	public double getArea() {
		double p1p2=  Point2D.distance(this.p1.x, this.p1.y, this.p2.x, this.p2.y);
		double p2p3=  Point2D.distance(this.p2.x, this.p2.y, this.p3.x, this.p3.y);
		double p1p3=  Point2D.distance(this.p1.x, this.p1.y, this.p3.x, this.p3.y);
		double Area1= triangleArea(p1p2,p2p3,p1p3);
		double p3p4=  Point2D.distance(this.p3.x, this.p3.y,this.p4.x, this.p4.y);
		double p1p4=  Point2D.distance(this.p1.x, this.p1.y, this.p4.x, this.p4.y);
		double Area2= triangleArea(p1p3,p1p4,p3p4);

		return Area1+ Area2; // Dummy return
	}	
	
}