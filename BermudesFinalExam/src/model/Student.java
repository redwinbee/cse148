package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
	private static int idCount;
	private String name;
	private String id;
	private double gpa;
	
	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.id = String.valueOf(idCount++);
		this.gpa = gpa;
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

	public String getId() {
		return id;
	}

	public static void setIdCount(int idCount) {
		Student.idCount = idCount;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", gpa=" + String.format("%.2f", gpa) + "]";
	}
}
