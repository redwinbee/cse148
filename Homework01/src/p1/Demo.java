package p1;

public class Demo {
	public static void main(String[] args) {
		Student student1 = new Student("John Doe", 20, 3.9, 4769345);
		Student student2 = new Student("Jane Doe", 21, 4.0, 8451234);

		System.out.println("student1's name: " + student1.getName());
		System.out.println("student2's name: " + student2.getName());
	}
}