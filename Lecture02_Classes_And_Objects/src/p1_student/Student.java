package p1_student;

public class Student {
	private static String major = "Computer Science";
	
	private String name;
	private int age;
	private double gpa;
	
	
	/**
	 * creates a student with the given attributes
	 * 
	 * @param name name of the student
	 * @param age age of the student
	 * @param gpa gpa of the student
	 */
	public Student(String name, int age, double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}

	/**
	 * creates a student with the given attributes
	 * 
	 * @param name name of the student
	 * @param gpa gpa of the student
	 * @param age age of the student
	 */
	public Student(String name, double gpa, int age) {
		this.name = name;
		this.gpa = gpa;
		this.age = age;
	}
	
	// getters/setters
	
	public static String getMajor() {
		return major;
	}


	public static void setMajor(String major) {
		Student.major = major;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return name + ":" + age + ":" + gpa + ":" + major;
	}
}
