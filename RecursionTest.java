package Exam3;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecursionTest {
	
	private int[] sorted;
	private int[] reversed;
	private int[] random;
	
	@Before
	public void setup() {
		sorted = new int[] { 1, 2, 3, 4, 5, 6 };
		reversed = new int[] { 6, 5, 4, 3, 2, 1 };
		random = new int[] { 5, 3, 4, 7, 6, 5, 2 };
	}
	
	@Test
	public void testExistsZero() {
		assertEquals(false, Recursion.exists(sorted, 2, 1, 1));
		assertEquals(false, Recursion.exists(reversed, 2, 1, 0));
		assertEquals(true, Recursion.exists(random, 2, 0, 7));
	}
	
	@Test
	public void testExistsAll() {
		assertEquals(false, Recursion.exists(sorted, 10, 0, sorted.length));
		assertEquals(true, Recursion.exists(reversed, 2, 0, reversed.length));
		assertEquals(true, Recursion.exists(random, 2, 0, random.length));
		assertEquals(true, Recursion.exists(random, 5, 0, random.length));
	}
	
	@Test
	public void testExistsOne() {
		assertEquals(true, Recursion.exists(sorted, 1, 0, 1));
		assertEquals(true, Recursion.exists(reversed, 2, 4, 5));
		assertEquals(true, Recursion.exists(random, 4, 2, 3));
		assertEquals(false, Recursion.exists(sorted, 2, 0, 1));
		assertEquals(false, Recursion.exists(reversed, 4, 4, 5));
		assertEquals(false, Recursion.exists(random, 7, 2, 3));
		assertEquals(false, Recursion.exists(random, 3, 2, 3));
	}
	
	@Test
	public void testDivZeroX() {
		assertEquals(0, Recursion.div(0L,1L));
		assertEquals(0, Recursion.div(0L,10L));
		assertEquals(0, Recursion.div(0L,1000L));
	}
	
	@Test
	public void testDivZeroResult() {
		assertEquals(0, Recursion.div(0L,1L));
		assertEquals(0, Recursion.div(5L,10L));
		assertEquals(0, Recursion.div(10L,100L));
		assertEquals(0, Recursion.div(2L,3L));
	}
	
	@Test
	public void testDivOneM() {
		assertEquals(1, Recursion.div(1L,1L));
		assertEquals(2, Recursion.div(2L,1L));
		assertEquals(12, Recursion.div(12L,1L));
		assertEquals(521, Recursion.div(521L,1L));
	}
	
	@Test
	public void testDivSmallPositives() {
		assertEquals(12/5, Recursion.div(12L,5L));
		assertEquals(12/7, Recursion.div(12L,7L));
		assertEquals(50/43, Recursion.div(50L,43L));
		assertEquals(25/4, Recursion.div(25L,4L));
		assertEquals(5/3, Recursion.div(5L,3L));
	}
	
	@Test(expected = StackOverflowError.class)
	public void testDivStackOverflow() {
		assertEquals(100, Recursion.div(10000000L,251L));
	}
	
	@Test
	public void testDivLargePositives() {
		assertEquals(1123345L/254L, Recursion.div(1123345L,254L));
		assertEquals(999999L/9999L, Recursion.div(999999L,9999L));
		assertEquals(43987687/448732, Recursion.div(43987687,448732));
	}
}