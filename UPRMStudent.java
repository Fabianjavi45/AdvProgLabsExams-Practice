package Exam2;

import java.util.ArrayList;
import java.util.Arrays;

public class UPRMStudent {

	private String studentId;
	private String firstName;
	private String lastName;
	private String academicProgram;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private double gpa;

	public UPRMStudent(String studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAcademicProgram() {
		return academicProgram;
	}

	public int getBirthDate() {
		return birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public double getGpa() {
		return gpa;
	}

	public void setAcademicProgram(String academicProgram) {
		this.academicProgram = academicProgram;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setBirthDate(int day, int month, int year) {
		this.birthDay = day;
		this.birthMonth = month;
		this.birthYear = year;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UPRMStudent) {
			UPRMStudent s = (UPRMStudent) o;
			return s.getStudentId().equals(this.getStudentId());
		}
		return false;
	}

	/*
	 * Returns the UPRMStudent with the highest GPA among all students in the given roster.
	 * Returns null if the roster is empty
	 */
	public static UPRMStudent maxGPA(UPRMStudent[] roster) {
		if(roster.length==0){
			return null;
		}
		double max= roster[0].gpa;
		int idx=0;
		for (int i = 0; i < roster.length; i++) {
			if(roster[i].gpa>max){
				max= roster[i].gpa;
				idx= i;
			}
		}
		return roster[idx]; // dummy return
	}

	/*
	 * Returns true if all students in the roster have a GPA higher or equal that that of the target student
	 * Stops searching as soon as a student is found with lower GPA than the target
	 */
	public boolean allWithHigherGPA(UPRMStudent[] roster) {
		//YOUR CODE
		for (int i = 0; i < roster.length; i++) {
			if(this.gpa>roster[i].gpa){
				return false;
			}


		}
		return true; // Dummy return
	}

	/*
	 * Returns a new array of students containing only those students from the given roster that belong
	 * to the given academic program
	 * The resulting array must not contain any null entries
	 * Returns empty array (length == 0) if no students belong to the program
	 */
	public static UPRMStudent[] filterByProgram(String program, UPRMStudent[] roster) {
		ArrayList<UPRMStudent> arr= new ArrayList<UPRMStudent>();
		int count =0;
		for (int i = 0; i < roster.length; i++) {
			if(roster[i].academicProgram.equals(program)){
				arr.add(roster[i]);
				count++;
			}
		}
		UPRMStudent[] arr1= new UPRMStudent[count];


		//YOUR CODE
		return arr.toArray(arr1); // Dummy return
	}

	/* Returns the new course roster resulting from adding the
	 * target student at the end of the original roster
	 * You may assume that the target student is not already in 
	 * the course.
	 */
	public UPRMStudent[] append(UPRMStudent[] courseRoster) {
		//YOUR CODE
		ArrayList<UPRMStudent> arr=  new ArrayList<UPRMStudent>(Arrays.asList(courseRoster));
		arr.add(this);
		

		return arr.toArray(courseRoster); //Dummy return
	}
}