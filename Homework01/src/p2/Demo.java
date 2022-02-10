package p2;

import p1.Student;

public class Demo {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		students[0] = new Student("John Doe", 21, 4.0, 4568324);
		students[1] = new Student("Jane Doe", 22, 3.9, 2973456);
		students[2] = new Student("Jack Doe", 23, 3.8, 3458823);

		showStudents(students);
	}

	/**
	 * displays information of students from an array of students
	 * @param students the students to print
	 */
	private static void showStudents(Student[] students) {
		for (int i = 0; i < 3; i++) {
			System.out.printf("%s\t%d\t%.1f\t%d", students[i].getName(), students[i].getAge(),students[i].getGpa(),
					students[i].getPhoneNumber());
			System.out.println();
		}
	}
}
