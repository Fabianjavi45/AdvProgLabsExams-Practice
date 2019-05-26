package Exam2;
import java.util.ArrayList;

public class StudentRecordSystem {

	private static StudentRecordSystem studentRecordSystem;
	private StudentRecord[] studentRecords;
	private int totalStudentRecords;	// Actual number of student records currently in the system.
	
	static {
		studentRecordSystem = new StudentRecordSystem();
	}
	
	private StudentRecordSystem() {}
	
	public static StudentRecordSystem initializeInstance(int maxNumberOfStudentRecords){
		studentRecordSystem.studentRecords = new StudentRecord[maxNumberOfStudentRecords];
		studentRecordSystem.totalStudentRecords = 0;
        return studentRecordSystem;
    }
	
	// Getters
	public StudentRecord[] getStudentRecords() {
		return studentRecords;
	}
	
	public int getTotalStudentRecords() {
		return totalStudentRecords;
	}
	
	public void addAllStudents(StudentRecord[] sr) {
		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
		for(int i = 0; i<totalStudentRecords; i++) {
			list.add(studentRecords[i]);
		}
		for(StudentRecord s: sr) {
			list.add(s);
		}
		studentRecords = list.toArray(new StudentRecord[0]);
		totalStudentRecords += sr.length;
	}
	
    /*
	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
	 * 
	 * Adds a new student record with the given parameters.
	 * 
	 * HINT: Create a new array twice the size of the original array and move 
	 * all the elements to this mew array if the totalStudentRecords exceeds 
	 * the capacity of the current array.
	 */
	public void addStudentRecord(String id, String name, Gender gender, double gpa) {
		//WRITE CODE HERE	
	}
	
	/*
	 * Enum of type Gender representing male or female.
	 */
	public enum Gender {
		MALE('M'), FEMALE('F');
		private final char letter;
		Gender(char letter) { this.letter = letter; }
		public char genderLetter() { return letter; }
	}
	
	/*
	 * Inner class representing student records in the student record system.
	 */
	public static class StudentRecord {
		
		private String id;
		private String name;
		private Gender gender;
		private double gpa;
		
		public StudentRecord(String id, String name, Gender gender, double gpa) {
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.gpa = gpa;
		}

		public String toString() {
			return String.format("ID: " + id + ", Name: " + name + ", Gender: " + gender.genderLetter() + ", GPA: %.2f", gpa);
		}
		
		// Getters
		public String getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public Gender getGender() {
			return gender;
		}
		
		public double getGPA() {
			return gpa;
		}
	}
}
