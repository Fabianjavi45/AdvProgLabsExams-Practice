package Exam3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Wrapper class used to enclose all classes used by the University app as static nested classes.
 * These classes would normally be top-level classes, but are enclosed
 * for compatibility with the Moodle JUnit plugin which at this time (2016) does not support
 * multiple classes.
 * 
 * @author Bienvenido.Velez@upr.edu
 *
 */
class UniversityWrapper {
	
	
	//For this question your job is to add a Person interface to the UniversityWrapper class to represent any type of 
	//person related with the university (students, professors and staff).  
	//The interface should have three methods: getFullName(), getType() add getID().  
	//The method getFullName() should return the name of the person including first and last name. 
	//The method getType() should return one of the String's "Professor", "Student" or "StaffMember" 
	//depending on the class of the target object. The methods getID() should return the ID for the person.

	//After defining the interface modify the Professor, StaffMember and Student classes to implement this new interface.

	//YOUR SOLUTION MUST AVOID ADDING FUNCTIONALITY THAT IS ALREADY IMPLEMENTED BY THE CLASS.
	
	
	 interface Person{
		 String getFullName();
		 String getType();
		 int getID();
		 
		
	}
	
	
	
	
	
	

	/**
	 * Represents a University consisting of a set of courses and a set of student 
	 * taking some of these courses.
	 * 
	 * @author Bienvenido.Velez@upr.edu, CSE Department, UPR Mayag�ez 
	 *
	 */
	public static class University {
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Professor> professors = new ArrayList<Professor>();
		ArrayList<StaffMember> staff = new ArrayList<StaffMember>();

		public University() {}  // Null constructor does nothing

		public void addCourse(Course course) {
			courses.add(course);
		}

		public void addStudent(Student student) {
			students.add(student);
		}

		public void addProfessor(Professor professor) {
			professors.add(professor);
		}

		public void addStaffMember(StaffMember staffMember) {
			staff.add(staffMember);
		}

		public boolean hasSomeCourse(Professor p) {
			for(int i=0; i< courses.size(); i++) {
				if(courses.get(i).getProfessor().equals(p)) {
					return true;
				}
				
			}
			return false; // Dummy return to avoid compiler error. Modify appropriately
		}
		//For this question your job is to add a takeSameCourse(Student s1, Student s2) method to 
		//the University class that returns true if and only iff students s1 and s2 take at least one course together. 
		
		public boolean takeSameCourse(Student s1, Student s2) {
			for (int i = 0; i < courses.size(); i++) {
				if(s1.isEnrolled(courses.get(i)) && s2.isEnrolled(courses.get(i))){
					return true;
				}
				//if(courses.get(i).isEnrolled(s1) && courses.get(i).isEnrolled(s2)) {
				//	return true;
				//}
			}
			return false;
			
			
			
			
		}
		
		
		
	}

	/**
	 * Represents a non-teaching member of the university staff
	 */
	public static class StaffMember implements Person {
		private int ID;
		String name;
		String department;

		public StaffMember(int iD, String name, String department) {
			super();
			ID = iD;
			this.name = name;
			this.department = department;
		}

		public int getID() {
			return ID;
		}

		public String getName() {
			return name;
		}

		public String getDepartment() {
			return department;
		}

		@Override
		public String getFullName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public String getType() {
			// TODO Auto-generated method stub
			return "Staff";
		}
		
	}

	/**
	 * Represents a faculty member at the university
	 */
	public static class Professor implements Person {
		private int ID;
		String firstName;
		String lastName;
		String department;

		public Professor(int iD, String firstName, String lastName, String department) {
			super();
			ID = iD;
			this.firstName = firstName;
			this.lastName = lastName;
			this.department = department;
		}

		public int getID() {
			return ID;
		}

		public String getLastName() {
			return lastName;
		}

		public String getFirstName() {
			return firstName;
		}
		public String getDepartment() {
			return department;
		}

		@Override
		public String getFullName() {
			return this.getFirstName() + " " + this.getLastName();
		}

		@Override
		public String getType() {
			return "Professor";
		}

		
	}

	/**
	 * Represents a student attending the university. 
	 * Every students has a unique ID, name and the number of credits that he is currently taking.
	 */
	public static class Student implements Person {

		private int studentID;
		private String first;
		private String last;
		private int credits;
		private boolean graduate;

		public Student(int id, String first, String last, boolean graduate) {
			this.studentID = id;
			this.first = first;
			this.last = last;
			this.graduate = graduate;
		}

		public int getID() { return studentID; }

		public String getFirstName() { return first; }

		public String getLastName() { return last; }

		public int getCredits() { return credits; }

		public boolean isGraduate() { return graduate; }

		public void setCredits(int credits) { this.credits = credits; }

		public String toString() { return "[" + studentID + "] " + first + " " + last; }

		public boolean isEnrolled(Course c) {
			return (c.findRollBookEntry(this.getID()) != null);
		}
		
		//For this question your job is to add a drop(Course c) method to the Student class
		//that removes the target student from course c. 
		public void drop(Course c) {
			
			for (int i = 0; i < c.numStudents; i++) {
				if(c.getRollBook()[i].getStudent().equals(this)) {
					for (int j = i+1; j < c.numStudents; j++) {
						c.getRollBook()[j-1]=c.getRollBook()[j];
					}
					
				}
				c.numStudents-=1;
			}
			 
			
		}

		@Override
		public String getFullName() {
		
			return this.getFirstName() + " " + this.getLastName();
		}

		@Override
		public String getType() {
			// TODO Auto-generated method stub
			return "Student";
		}

	}

	/**
	 * Represents a course offered at the university. Each course as a "rollbook"
	 * holding the list of students taking that course and their grades.
	 * 
	 * @author Bienvenido.Velez@upr.edu, CSE Department, UPR Mayag�ez 
	 *
	 */
	public static class Course {

		private String title;
		private String code;
		private int credits;
		private Professor professor;

		private RollBookEntry[] rollBook;
		private int numStudents;
		private final short MAX_STUDENTS_PER_COURSE = 50;

		public Course(String code, String title, int credits, Professor professor) {
			this.title = title;
			this.code = code;
			this.professor = professor;
			this.credits = credits;
			this.rollBook = new RollBookEntry[MAX_STUDENTS_PER_COURSE];
			this.numStudents = 0; // Initially no students are registered
		}

		public String getTitle() { return title; }

		public String getCode() { return code; }

		public int getCredits() { return credits; }

		public RollBookEntry[] getRollBook() { return rollBook; }

		public int getNumStudents() { return numStudents; }

		public Professor getProfessor() { return professor; }

		public void setNumStudents(int numStudents) { this.numStudents = numStudents; }

		public boolean isGraduate() { return false; }

		public void enroll(Student s) {
			if (this.getNumStudents() < getRollBook().length) {
				getRollBook()[numStudents++] = new RollBookEntry(s);
				s.setCredits(s.getCredits()+getCredits());
			}
			else {
				System.out.println("Fatal internal error: Attemp to register student in full course"); 
				System.exit(1);
			}
		}

		public RollBookEntry findRollBookEntry(int studentID) {
			for (int i=0; i< numStudents; i++) {
				if (rollBook[i].getStudent().getID() == studentID) { return rollBook[i]; }
			}
			return null; // return null if student not registered in the course
		}	

		public void setGrade(Student student, String gradeCode, double gradeValue) {
			RollBookEntry rbe = findRollBookEntry(student.getID());
			if (rbe == null) {
				System.err.println("Fatal internal error: Attempt to register grade for unregistered student");
				System.exit(1);
			}
			else {
				rbe.setGrade(gradeCode, gradeValue);
			}
		}

		public boolean isEnrolled(Student s) {
			return (this.findRollBookEntry(s.getID()) != null);
		}

		private Grade findGradeObject(Student s, String code) {
			if (!this.isEnrolled(s)) {
				return null;
			}
			else {
				RollBookEntry rbe = this.findRollBookEntry(s.getID());
				return (rbe.findGrade(code));
			}
		}

		public double findGrade(Student s, String code) {
			Grade g = findGradeObject(s,code);
			if (g == null) {
				return -1.0;
			}
			else {
				return (g.getValue());
			}
		}

		public String toString() { return code + ": " + title; }

	}
	
	
	
	
	//For this question your job is to add a GradCourse subclass of the Course class to represent graduate courses.  
	//The class should have a new constructor GradCourse and should override the isGraduate() and enroll(Student s)methods.  
	//The isGraduate()method should return true.  The enroll(Student s) method should make sure the student s is a graduate student 
	//before enrolling it in the course.  If the student is not a graduate student the method should simple return without enrolling 
	//the student.

     //YOUR SOLUTION MUST AVOID ADDING FUNCTIONALITY THAT CAN BE INHERITED FROM THE SUPERCLASS.
	
	public static class GradCourse extends Course{
		private int numStudents;

		public GradCourse(String code, String title, int credits, Professor professor) {
			super(code, title, credits, professor);
			this.numStudents= 0;
		}
		
		@Override
		public boolean isGraduate() {
			return true;
		}
		
		@Override
		public void enroll(Student s) {
			if(s.isGraduate()) {
				getRollBook()[numStudents++] = new RollBookEntry(s);
				s.setCredits(s.getCredits()+getCredits());
			}
		}
		
		
		
		
	}
	
	
	
	

	/**
	 * Represents the grade or score obtained in some test by a student.  
	 * Each such test is identified by a code String such as: "Exam1", "Project", 
	 * "Attendance", etc.
	 * 
	 * @author Bienvenido.Velez@upr.edu, CSE Department, UPR Mayag�ez 
	 *
	 */
	public static class Grade {

		private String code;
		private double value;

		public Grade(String code, double value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() { return code; }

		public double getValue() { return value; }

		public void setValue(double value) { this.value = value; }

	}

	/**  
	 * Every course has an associated list of RollBookEntry's, one for each student 
	 * currently taking the course. The entry holds the student ID and a list of grades 
	 * registered so far for the student.
	 * 
	 * @author Bienvenido.Velez@upr.edu, CSE Department, UPR Mayag�ez 
	 *
	 */
	public static class RollBookEntry {

		private Student student;
		private Grade[] grades;
		private int numGrades = 0;

		private final static short MAX_GRADES_PER_STUDENT = 25;

		public RollBookEntry(Student student) {

			this.student = student;
			this.grades = new Grade[MAX_GRADES_PER_STUDENT];

		}

		public Student getStudent() { return student; }

		public Grade[] getGrades() { return grades; }

		public int getNumGrades() { return numGrades; }

		public Grade findGrade(String gradeCode) {
			Grade[] grades = this.getGrades();
			for (int i=0; i < this.getNumGrades(); i++) {
				if (grades[i].getCode() == gradeCode) {
					return grades[i];
				}
			}
			return null;
		}

		public void setGrade(String gradeCode, double gradeValue) {

			// If grade with provided code exists, change the value, otherwise add grade with value
			Grade g = this.findGrade(gradeCode);
			if (g != null) {
				g.setValue(gradeValue);
				return;
			}
			if (numGrades == MAX_GRADES_PER_STUDENT) {
				System.err.println("Internal error: Too many grades");
				System.exit(1);
			}
			else {
				this.grades[numGrades++] = new Grade(gradeCode, gradeValue);
			}
		}
	}
	
	 

}