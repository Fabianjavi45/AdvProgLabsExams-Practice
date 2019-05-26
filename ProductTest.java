package Exam1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private static final double EPSILON = 0.0001;
	
	private Product p1;
	private Product p2;
	private Product p3;
	private Product p4;
	private Product p5;
	
	@Before
	public void setUP() {
		p1 = new Product(100, 400, 200);
		p2 = new Product(200, 200, 100);
		p3 = new Product(.5, .75, 50);
		p4 = new Product(10, -10, 100);
		p5 = new Product(215,645, 25);
	}
	
	// #1
	@Test
	public void testGetTotalCostWithTax(){
		p1.setSellingPrice(400);
		p2.setSellingPrice(200);
		p3.setSellingPrice(.75);
		p4.setSellingPrice(-10);
		p5.setSellingPrice(645);
		
		assertEquals("The total with tax should be 446.",446,p1.getTotalCostWithTax(),EPSILON);
		assertEquals("The total with tax should be 223.",223,p2.getTotalCostWithTax(),EPSILON);
		assertEquals("The total with tax should be 0.836.",0.83625,p3.getTotalCostWithTax(),EPSILON);
		assertEquals("The total with tax should be -11.15.",-11.15,p4.getTotalCostWithTax(),EPSILON);
		assertEquals("The total with tax should be 719.175.",719.175,p5.getTotalCostWithTax(),EPSILON);
	}

	
	// #2
	@Test
	public void testSetPriceBeforeTax(){
		p1.setPriceBeforeTax(475);
		p2.setPriceBeforeTax(225);
		p3.setPriceBeforeTax(0.97);
		p4.setPriceBeforeTax(-11);
		p5.setPriceBeforeTax(725);
		
		assertEquals("New price should be 426.00897.",426.00897,p1.getSellingPrice(),EPSILON);
		assertEquals("New price should be 201.79372.",201.79372,p2.getSellingPrice(),EPSILON);
		assertEquals("New price should be 0.86995.",0.86995,p3.getSellingPrice(),EPSILON);
		assertEquals("New price should be -9.865471.",-9.865471,p4.getSellingPrice(),EPSILON);
		assertEquals("New price should be 650.22422.",650.22422,p5.getSellingPrice(),EPSILON);
	}

	// #3
	@Test
	public void testGetNetProfit(){
		p1.setSellingPrice(400);
		p2.setSellingPrice(200);
		p3.setSellingPrice(.75);
		p4.setSellingPrice(-10);
		p5.setSellingPrice(645);
		
		assertEquals("The net profit should be 297.",297,p1.getNetProfit(),EPSILON);
		assertEquals("The net profit should be -6.",-6,p2.getNetProfit(),EPSILON);
		assertEquals("The net profit should be 0.235.",0.235,p3.getNetProfit(),EPSILON);
		assertEquals("The net profit should be -20.3.",-20.3,p4.getNetProfit(),EPSILON);
		assertEquals("The net profit should be 423.55.",423.55,p5.getNetProfit(),EPSILON);	
	}
	
	// #4
	@Test
	public void testSubtractInventory(){
		p1.subtractInventory(100);
		p2.subtractInventory(150);
		p4.subtractInventory(-10);
		
		assertEquals("Inventory should be 100.",100,p1.getInventory(),EPSILON);
		assertEquals("Inventory can't be negative",0,p2.getInventory(),EPSILON);
		assertEquals("Inventory can be returned.",110,p4.getInventory(),EPSILON);	
	}
	
	// #5
	@Test
	public void testGetPotentialProfit(){
		p3.setSellingPrice(.75);
		p5.setSellingPrice(645);
		p3.getPotentialProfit();
		p5.getPotentialProfit();
		
		assertEquals("Potential profit should be 11.75.",11.75,p3.getPotentialProfit(),EPSILON);
		assertEquals("Potential profit should be 10,588.75.",10588.75,p5.getPotentialProfit(),EPSILON);	
	}	
}