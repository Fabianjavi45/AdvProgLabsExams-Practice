package Exam2;
import static org.junit.Assert.*;

import org.junit.Test;

public class StudentRecordSystemTest {

	@Test
	public void addStudentRecordTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		studentRecordSystem.addStudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00);
		StudentRecordSystem.StudentRecord[] studentRecords1 = studentRecordSystem.getStudentRecords();
		assertEquals("The totalStudentRecords variable is not being updated.", 1, studentRecordSystem.getTotalStudentRecords());
		assertEquals("Student record ID is incorrect.", "802113679", studentRecords1[0].getID());
		assertEquals("Student record name is incorrect.", "Pedro", studentRecords1[0].getName());
		assertEquals("Student record gender is incorrect.", StudentRecordSystem.Gender.MALE, studentRecords1[0].getGender());
		assertEquals("Student record GPA is incorrect.",  3.00, studentRecords1[0].getGPA(), 1e-10);
		studentRecordSystem.addStudentRecord("802174579", "Juan", StudentRecordSystem.Gender.MALE, 3.40);
		assertEquals("The totalStudentRecords variable is not being updated.", 2, studentRecordSystem.getTotalStudentRecords());
		assertTrue("The arrays are different instances.", studentRecords1 == studentRecordSystem.getStudentRecords());
		studentRecordSystem.addStudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
		studentRecordSystem.addStudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
		StudentRecordSystem.StudentRecord[] studentRecords2 = studentRecordSystem.getStudentRecords();
		assertEquals("Student record name is incorrect.", "Pedro", studentRecords2[0].getName());
		assertEquals("Student record name is incorrect.", "Juan", studentRecords2[1].getName());
		assertEquals("Student record name is incorrect.", "Julia", studentRecords2[2].getName());
		assertEquals("Student record name is incorrect.", "Eliezer", studentRecords2[3].getName());
		assertFalse("The arrays are the same instance.", studentRecords1 == studentRecordSystem.getStudentRecords());
		assertEquals("The size of student records is not twice the size.", 6, studentRecordSystem.getStudentRecords().length);
	}
}