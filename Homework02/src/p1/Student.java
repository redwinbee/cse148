package p1;

import p1.course.CourseBag;

public class Student {
	private String name;
	private double gpa;
	private CourseBag courses;

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.courses = new CourseBag(4);
	}

	public Student(double gpa, String name) {
		super();
		this.gpa = gpa;
		this.name = name;
		this.courses = new CourseBag(4);
	}

	public Student(String name) {
		super();
		this.name = name;
		this.courses = new CourseBag(4);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public CourseBag getCourses() {
		return courses;
	}

	public void setCourses(CourseBag courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String.format("student=[name: %s, gpa: %.2f]", name, gpa);
	}
}
