package p1;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student("Edwin Bermudes", 24, 3.9);
		student1.setMajor("IT");

		Student student2 = new Student("John Doe", 19, 4.0);

		System.out.println("student1 name: " + student1.getName());
		System.out.println("student1 age: " + student1.getAge());
		System.out.println("student1 major: " + Student.getMajor());
		System.out.println("student2 name: " + student2.getName());
		System.out.println("student2 age: " + student2.getAge());
		System.out.println("student2 major: " + Student.getMajor());
	}
}
