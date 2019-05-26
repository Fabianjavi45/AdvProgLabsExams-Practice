package Exam2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UPRMStudentTest {

	UPRMStudent s1;
	UPRMStudent s2;
	UPRMStudent s3;
	UPRMStudent s4;
	UPRMStudent s5;
	UPRMStudent s6;


	UPRMStudent[] empty;
	UPRMStudent[] onlyOne;
	UPRMStudent[] allDifferent;
	UPRMStudent[] allTheSame;
	UPRMStudent[] maxAtBeginning;
	UPRMStudent[] maxAtEnd;
	UPRMStudent[] allINSO;
	UPRMStudent[] allCSE;
	UPRMStudent[] noINSO;
	UPRMStudent[] all;
	UPRMStudent[] allDroppeds4;
	UPRMStudent[] allDroppeds1;
	UPRMStudent[] allDroppeds6;
	UPRMStudent[] allDroppeds1s5;

	@Before
	public void setUp() {
		s1 = new UPRMStudent("012-82-0101", "Student", "One");
		s1.setGpa(4.0);
		s1.setAcademicProgram("CSE");
		s2 = new UPRMStudent("012-82-0102", "Student", "Two");
		s2.setGpa(3.5);
		s2.setAcademicProgram("MATE");
		s3 = new UPRMStudent("012-88-0103", "Student", "Three");
		s3.setGpa(3.0);
		s3.setAcademicProgram("INSO");
		s4 = new UPRMStudent("012-82-0104", "Student", "Four");
		s4.setGpa(2.8);
		s4.setAcademicProgram("FISI");
		s5 = new UPRMStudent("012-82-0105", "Student", "Five");
		s5.setGpa(3.8);
		s5.setAcademicProgram("INSO");
		s6 = new UPRMStudent("012-85-0106", "Student", "Six");
		s6.setGpa(2.5);
		s6.setAcademicProgram("CSE");

		empty = new UPRMStudent[]{};
		onlyOne = new UPRMStudent[]{ s1 };
		allDifferent = new UPRMStudent[]{ s1, s2, s3 };
		allTheSame = new UPRMStudent[]{ s1, s1, s1 };
		maxAtBeginning = new UPRMStudent[]{ s1, s3, s5 };
		maxAtEnd = new UPRMStudent[]{ s3, s5, s1 };
		allINSO = new UPRMStudent[]{ s3, s5 };
		allCSE = new UPRMStudent[]{ s1, s6 };
		noINSO = new UPRMStudent[]{ s1, s2, s4, s6 };
		all = new UPRMStudent[]{ s1, s2, s3, s4, s5, s6 };
		allDroppeds4 = new UPRMStudent[]{ s1, s2, s3, s5, s6 };
		allDroppeds1 = new UPRMStudent[]{ s2, s3, s4, s5, s6 };
		allDroppeds6 = new UPRMStudent[]{ s1, s2, s3, s4, s5 };
		allDroppeds1s5 = new UPRMStudent[]{ s2, s3, s4, s6 };

	}

	@Test
	public void testMaxGPA() {
		assertTrue(null == UPRMStudent.maxGPA(empty));
		assertFalse(null==UPRMStudent.maxGPA(onlyOne));
		assertEquals(s1, UPRMStudent.maxGPA(onlyOne));
		assertFalse(null==UPRMStudent.maxGPA(allDifferent));
		assertEquals(s1, UPRMStudent.maxGPA(allDifferent));
		assertFalse(null==UPRMStudent.maxGPA(allDroppeds1));
		assertEquals(s5, UPRMStudent.maxGPA(allDroppeds1));
	}

	@Test
	public void testAllWithHigherGPA() {
		assertTrue(s1.allWithHigherGPA(empty));
		assertTrue(s1.allWithHigherGPA(onlyOne));
		assertTrue(s1.allWithHigherGPA(allTheSame));		
		assertTrue(s6.allWithHigherGPA(allDifferent));
		assertFalse(s5.allWithHigherGPA(allDifferent));
	}
	
	@Test
	public void testFilterByProgram() {
		UPRMStudent[] r1 = UPRMStudent.filterByProgram("CSE", empty);
		assertFalse(null == r1);
		assertEquals(0, r1.length);
		
		UPRMStudent[] r2 = UPRMStudent.filterByProgram("CSE", onlyOne);
		assertFalse(null == r2);
		assertEquals(1, r2.length);
		assertEquals(s1, r2[0]);
		
		UPRMStudent[] r3 = UPRMStudent.filterByProgram("INSO", onlyOne);
		assertFalse(null == r3);
		assertEquals(0, r3.length);
		
		UPRMStudent[] r4 = UPRMStudent.filterByProgram("INSO", all);
		assertFalse(null == r4);
		assertEquals(2, r4.length);
		assertTrue(Arrays.asList(r4).contains(s3));
		assertTrue(Arrays.asList(r4).contains(s5));
		
		UPRMStudent[] r5 = UPRMStudent.filterByProgram("INSO", noINSO);
		assertFalse(null == r5);
		assertEquals(0, r5.length);
		
	}
	
	@Test
	public void testAppend() {
		UPRMStudent[] r1 = s2.append(empty);
		assertFalse(null == r1);
		assertFalse(r1 == empty);
		assertEquals(1, r1.length);
		assertTrue(Arrays.asList(r1).contains(s2));
		
		UPRMStudent[] r2 = s2.append(onlyOne);
		assertFalse(null == r2);
		assertFalse(r2 == onlyOne);
		assertEquals(2, r2.length);
		assertTrue(Arrays.asList(r2).contains(s1));
		assertTrue(Arrays.asList(r2).contains(s2));
		
		UPRMStudent[] r3 = s4.append(allDroppeds4);
		assertFalse(null == r3);
		assertFalse(r3 == allDroppeds4);
		assertEquals(6, r3.length);
		assertTrue(Arrays.asList(r3).contains(s1));
		assertTrue(Arrays.asList(r3).contains(s2));
		assertTrue(Arrays.asList(r3).contains(s3));
		assertTrue(Arrays.asList(r3).contains(s4));
		assertTrue(Arrays.asList(r3).contains(s5));
		assertTrue(Arrays.asList(r3).contains(s6));
		
	}
}