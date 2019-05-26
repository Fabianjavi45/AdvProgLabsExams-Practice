package Exam2;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DNASequenceTest {

	DNASequence DNASequenceL5;
	DNASequence DNASequenceL5R;
	DNASequence DNASequenceL10;
	DNASequence DNASequenceL15;
	DNASequence DNASequenceL20;
	DNASequence DNASequence5;
	DNASequence DNASequence6;
	DNASequence DNASequence7;
	DNASequence DNASequence8;

	ArrayList empty;
	ArrayList onlyOne;
	ArrayList allSame;
	ArrayList contained1;
	ArrayList contained2;
	ArrayList contained3;
	ArrayList contained4;
	ArrayList contained5;
	ArrayList notContained;

	// Methods annotated with @Before are repeatedly executed once before running each test method
	@Before
	public void setUp() {
		DNASequenceL5 = new DNASequence("AGTCG", "dna");
		DNASequenceL5R = new DNASequence("GCTGA", "dna");
		DNASequenceL10 = new DNASequence("AGTCGGCTGA", "dna");
		DNASequenceL15 = new DNASequence("AGTCGGCTGACCCCC", "dna");
		DNASequenceL20 = new DNASequence("AGTCGGCTGACCCCCATATA", "dna");

		empty = new ArrayList();
		onlyOne = new ArrayList(Arrays.asList(DNASequenceL5));
		allSame = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL10, DNASequenceL10));
		contained1 = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL10));
		contained2 = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL5R, DNASequenceL10));
		contained3 = new ArrayList(Arrays.asList(DNASequenceL5R, DNASequenceL5, DNASequenceL10));
		contained4 = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL5));
		contained5 = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL10));
		notContained = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL5R));
	}

	@Test
	public void testLongestSequence() {
		assertEquals(null, DNASequence.longestSequence(empty));
		assertNotNull(DNASequence.longestSequence(onlyOne));
		assertEquals(onlyOne.get(0), DNASequence.longestSequence(onlyOne));
		assertNotNull(DNASequence.longestSequence(allSame));
		assertEquals(allSame.get(0), DNASequence.longestSequence(allSame));
		assertNotNull(DNASequence.longestSequence(contained2));
		assertEquals(contained2.get(2), DNASequence.longestSequence(contained2));
	}

	@Test
	public void testConcatenate() {
		assertNotNull(DNASequence.concatenate(empty));
		assertEquals(new DNASequence("", "dna"), DNASequence.concatenate(empty));
		assertNotNull(DNASequence.concatenate(onlyOne));
		assertEquals(DNASequenceL5, DNASequence.concatenate(onlyOne));
		assertNotNull(DNASequence.concatenate(notContained));
		assertEquals(DNASequenceL10, DNASequence.concatenate(notContained));
	}


	@Test
	public void testExists() {
		assertFalse(DNASequenceL10.exists(empty));
		assertFalse(DNASequenceL10.exists(onlyOne));
		assertTrue(DNASequenceL5.exists(onlyOne));
		assertTrue(DNASequenceL10.exists(allSame));
		assertTrue(DNASequenceL10.exists(contained3));
	}

	@Test
	public void testPrepend() {
		assertEquals(onlyOne, DNASequenceL5.prepend(empty));
		assertEquals(contained4, DNASequenceL10.prepend(onlyOne));
		assertEquals(allSame, DNASequenceL10.prepend(contained5));
	}

	@Test
	public void testCompletelyContained() {
		assertFalse(DNASequence.someCompletelyContained(empty));
		assertFalse(DNASequence.someCompletelyContained(notContained));
		assertTrue(DNASequence.someCompletelyContained(contained1));
		assertTrue(DNASequence.someCompletelyContained(contained2));
		assertTrue(DNASequence.someCompletelyContained(contained3));
		assertTrue(DNASequence.someCompletelyContained(contained4));
		assertTrue(DNASequence.someCompletelyContained(contained5));
	}
}