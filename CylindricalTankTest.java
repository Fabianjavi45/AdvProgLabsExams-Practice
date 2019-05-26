package Exam1;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CylindricalTankTest {
	
	private static double epsilon = 1; // Tolerance allowed when comparing doubles
	
	private static CylindricalTank emptyTank;
	private static CylindricalTank bigFullTank;
	private static CylindricalTank smallFullTank;
	private static CylindricalTank halfFullTank;
	private static CylindricalTank lessThanTenLittersLeftTank;
	private static CylindricalTank containsTwentyLittersTank;
	
	//CylindricalTank(String tag, double radius, double height, double liquidLevel)
	
	@Before
	public void setUp() {
		emptyTank = new CylindricalTank("1", 10.0, 10.0, 0.0);
		bigFullTank = new CylindricalTank("2", 50.0, 100.0, 100.0);
		smallFullTank = new CylindricalTank("3", 5.0, 5.0, 5.0);
		halfFullTank = new CylindricalTank("4", 50.0, 100.0, 50.0);
		lessThanTenLittersLeftTank = new CylindricalTank("5", 50.0, 100.0, 99.9);
		containsTwentyLittersTank = new CylindricalTank("6", 50.0, 100.0, 99.9);
	}
	
	@Test
	public void testCopyConstructor() {
		CylindricalTank ct1 = new CylindricalTank(emptyTank);
		assertEquals(emptyTank, ct1);
		assertEquals(emptyTank.getHeight(), ct1.getHeight(), epsilon);
		assertEquals(emptyTank.getRadius(), ct1.getRadius(), epsilon);
		assertEquals(emptyTank.getLiquidLevel(), ct1.getLiquidLevel(), epsilon);
		
		CylindricalTank ct2 = new CylindricalTank(lessThanTenLittersLeftTank);
		assertEquals(lessThanTenLittersLeftTank, ct2);
		assertEquals(lessThanTenLittersLeftTank.getHeight(), ct2.getHeight(), epsilon);
		assertEquals(lessThanTenLittersLeftTank.getRadius(), ct2.getRadius(), epsilon);
		assertEquals(lessThanTenLittersLeftTank.getLiquidLevel(), ct2.getLiquidLevel(), epsilon);
	}
	
	@Test
	public void testGetLiquidVolumeInGallons() {
		assertEquals(0, emptyTank.getLiquidVolumeInGallons(), epsilon);
		assertEquals(103672, smallFullTank.getLiquidVolumeInGallons(), epsilon);
		assertEquals(103672557, halfFullTank.getLiquidVolumeInGallons(), epsilon);
		assertEquals(207137770, lessThanTenLittersLeftTank.getLiquidVolumeInGallons(), epsilon);

	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, emptyTank.compareTo(emptyTank));
		assertEquals(0, halfFullTank.compareTo(halfFullTank));
		assertEquals(1, lessThanTenLittersLeftTank.compareTo(emptyTank));
		assertEquals(1, lessThanTenLittersLeftTank.compareTo(smallFullTank));
		assertEquals(-1, emptyTank.compareTo(bigFullTank));
		assertEquals(-1, smallFullTank.compareTo(containsTwentyLittersTank));
	}
	
	@Test
	public void testGetPercentFilled1() {
		assertEquals("Empty", emptyTank.getPercentFilled());
		assertEquals("100% Full", smallFullTank.getPercentFilled());
		assertEquals("100% Full", bigFullTank.getPercentFilled());
		assertEquals("50% Full", halfFullTank.getPercentFilled());
		assertEquals("99% Full", lessThanTenLittersLeftTank.getPercentFilled());
	}
	
	@Test
	public void testAdd() {
		assertEquals(0,emptyTank.add(0).getLiquidVolume(), epsilon);
		assertEquals(10,emptyTank.add(10).getLiquidVolume(), epsilon);
		assertEquals(30,emptyTank.add(10).add(10).getLiquidVolume(), epsilon);
		assertEquals(emptyTank.getCapacity(),emptyTank.add(5000).add(10).getLiquidVolume(), epsilon);
	}	

}