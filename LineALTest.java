package Exam2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LineALTest {

	LineAL lineM0B0;
	LineAL lineM0B1;
	LineAL lineM1B0;
	LineAL lineM1B3;
	LineAL lineM2B0;
	LineAL lineM2B1;
	LineAL lineMn1B0;
	LineAL lineMn1Bn1;

	ArrayList empty;
	ArrayList allDifferent;
	ArrayList allEqual;
	ArrayList onlyOne;
	ArrayList posNegMix;
	ArrayList allNegative;
	ArrayList hasParallels1;
	ArrayList hasParallels2;
	ArrayList someHorizontals;
	ArrayList allHorizontals;
	ArrayList noHorizontals;


	// Methods annotated with @Before are repeatedly executed once before running each test method
	@Before
	public void setupTest() {
		lineM0B0 = new LineAL(0,0);
		lineM0B1 = new LineAL(0,1);
		lineM1B0 = new LineAL(1,0);
		lineM1B3 = new LineAL(1,3);
		lineM2B0 = new LineAL(2,0);
		lineM2B1 = new LineAL(2,1);
		lineMn1B0 = new LineAL(-1,0);
		lineMn1Bn1 = new LineAL(-1,-1);

		empty = new ArrayList();
		allDifferent = new ArrayList(Arrays.asList( lineM0B0, lineM1B3, lineM2B1));
		allEqual = new ArrayList(Arrays.asList(lineM0B0, lineM0B0, lineM0B0, lineM0B0));
		onlyOne = new ArrayList(Arrays.asList(lineM1B3));
		posNegMix = new ArrayList(Arrays.asList(lineM0B0, lineM1B3,lineMn1B0, lineMn1Bn1, lineM2B1));
		allNegative = new ArrayList(Arrays.asList(lineMn1B0, lineMn1Bn1));
		hasParallels1 = new ArrayList(Arrays.asList(lineM0B0, lineMn1Bn1, lineMn1B0, lineM1B3, lineM1B0));
		hasParallels2 = new ArrayList(Arrays.asList(lineM0B0, lineMn1Bn1, lineM1B3, lineMn1B0, lineM1B3));
		someHorizontals = new ArrayList(Arrays.asList(lineMn1Bn1, lineM1B3, lineM0B0, lineMn1B0, lineM1B3));
		allHorizontals = new ArrayList(Arrays.asList(lineM0B0, lineM0B1));
		noHorizontals = new ArrayList(Arrays.asList(lineMn1Bn1, lineM1B3, lineMn1B0, lineMn1B0));

	}

	@Test
	public void testHasWithSameSlope() {
		assertFalse(lineM0B0.hasWithSameSlope(empty));
		assertFalse(lineM0B0.hasWithSameSlope(allNegative));
		assertTrue(lineM0B0.hasWithSameSlope(posNegMix));
		assertFalse(lineM0B0.hasWithSameSlope(onlyOne));
		assertTrue(lineM1B3.hasWithSameSlope(onlyOne));
	}

	@Test
	public void testAddTo() {
		
		//Add to empty list
		ArrayList result1 = lineM0B0.addTo(empty);
		assertFalse(result1 == null);
		assertTrue(result1 == empty);
		assertEquals(1, result1.size());
		assertEquals(lineM0B0, result1.get(result1.size()-1));

		//Attempt to add already existing line
		ArrayList result2 = lineM1B3.addTo(allDifferent);
		assertFalse(result2 == null);
		assertTrue(result2 == allDifferent);
		assertEquals(3, result2.size());
		assertEquals(result2, allDifferent);

		//Add non-existent Line to list
		ArrayList result3 = lineM1B3.addTo(allNegative);
		assertFalse(result3 == null);
		assertTrue(result3 == allNegative);
		assertEquals(3, result3.size());
		assertEquals(lineM1B3, result3.get(2));
}

	@Test
	public void testHasParellels() {
		assertFalse(LineAL.hasParellels(empty));
		assertFalse(LineAL.hasParellels(onlyOne));
		assertTrue(LineAL.hasParellels(hasParallels1));
		assertTrue(LineAL.hasParellels(hasParallels2));
	}

	@Test
	public void testNonHorizontal() {
		//Filter non-horizontal from empty list
		ArrayList result1 = LineAL.notHorizontal(empty);
		assertFalse(result1 == null);
		assertTrue(result1 != empty);
		assertEquals(0, result1.size());

		//Filter non-horizontal from all-horizontal list
		ArrayList result2 = LineAL.notHorizontal(allHorizontals);
		assertFalse(result2 == null);
		assertFalse(result2 == allHorizontals);
		assertTrue(result2 instanceof ArrayList);
		assertEquals(0, result2.size());

		//Filter non-horizontals from no-horizontal list
		ArrayList result3 = LineAL.notHorizontal(noHorizontals);
		assertFalse(result3 == null);
		assertFalse(result3 == noHorizontals);
		assertTrue(result3 instanceof ArrayList);
		assertEquals(4, result3.size());
		assertEquals(noHorizontals, result3);
		
	}

}