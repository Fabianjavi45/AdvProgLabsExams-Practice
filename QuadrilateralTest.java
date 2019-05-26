package Exam1;
import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

public class QuadrilateralTest {
	
	private static double epsilon = 1; // Tolerance allowed when comparing doubles
	
	private Point2D.Double zeroZero;
	private Point2D.Double zeroHundred;
	private Point2D.Double hundredZero;
	private Point2D.Double hundredHundred;
	
	private Point2D.Double fiftyZero;
	private Point2D.Double hundredFifty;
	private Point2D.Double fiftyHundred;
	private Point2D.Double zeroFifty;
	private Point2D.Double fiftyFifty;
	
	private Quadrilateral square1;
	private Quadrilateral diamond1;
	
	private Quadrilateral upperLeft;
	private Quadrilateral upperRight;
	private Quadrilateral lowerRight;
	private Quadrilateral lowerLeft;

	@Before
	public void setUp() {
		zeroZero = new Point2D.Double(0,0);
		zeroHundred = new Point2D.Double(0,100);
		hundredZero = new Point2D.Double(100,0);
		hundredHundred = new Point2D.Double(100,100);
		fiftyZero = new Point2D.Double(50,0);
		hundredFifty = new Point2D.Double(100,50);
		fiftyHundred = new Point2D.Double(50,100);
		zeroFifty = new Point2D.Double(0,50);
		fiftyFifty = new Point2D.Double(50,50);
		
		square1 = new Quadrilateral(zeroZero, hundredZero, hundredHundred, zeroHundred);
		diamond1 = new Quadrilateral(fiftyZero, hundredFifty, fiftyHundred, zeroFifty);
		
		upperLeft = new Quadrilateral(zeroZero, fiftyZero, fiftyFifty, zeroFifty);
		upperRight = new Quadrilateral(fiftyZero, hundredZero, hundredFifty, fiftyFifty);
		lowerRight = new Quadrilateral(fiftyFifty, hundredFifty, hundredHundred, fiftyHundred);
		lowerLeft = new Quadrilateral(zeroFifty, fiftyFifty, fiftyHundred, zeroHundred);
	}
	
	@Test
	public void testCopyContructor() {
		Quadrilateral newSquare1 = new Quadrilateral(square1);
		assertEquals(square1, newSquare1);
		assertFalse(square1.getP1() == newSquare1.getP1());
		assertFalse(square1.getP2() == newSquare1.getP2());
		assertFalse(square1.getP3() == newSquare1.getP3());
		assertFalse(square1.getP4() == newSquare1.getP4());
		
		Quadrilateral newDiamond1 = new Quadrilateral(square1);
		assertEquals(diamond1, new Quadrilateral(diamond1));
		assertFalse(diamond1.getP1() == newSquare1.getP1());
		assertFalse(diamond1.getP2() == newSquare1.getP2());
		assertFalse(diamond1.getP3() == newSquare1.getP3());
		assertFalse(diamond1.getP4() == newSquare1.getP4());
	}
	
	@Test
	public void testRectangleConstructor() {
		assertEquals(square1, new Quadrilateral(new Rectangle(0,0,100,100)));
		assertEquals(upperLeft, new Quadrilateral(new Rectangle(0,0,50,50)));
	}
	
	@Test
	public void testMove() {
		assertEquals(lowerRight, upperRight.move(0, 50));
		assertEquals(lowerLeft, upperRight.move(-50, 0));
		assertEquals(lowerRight, upperRight.move(50, 0));
		assertEquals(upperLeft, upperRight.move(-50, -50));
	}
	
	@Test
	public void testGetPerimeter() {
		assertEquals(400,square1.getPerimeter(),epsilon);
		assertEquals(200,upperLeft.getPerimeter(),epsilon);
		assertEquals(4*50*Math.sqrt(2.0),diamond1.getPerimeter(),epsilon);
	}

	@Test
	public void testGetArea() {
		assertEquals(10000,square1.getArea(),epsilon);
		assertEquals(2500,upperLeft.getArea(),epsilon);
		assertEquals(5000,diamond1.getArea(),epsilon);
	}
	
}