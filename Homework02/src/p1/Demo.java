package p1;

import static p1.NameHelper.generateFullName;
import static p1.course.CourseHelper.generateCourseBag;

public class Demo {
	private static final int STUDENT_COUNT = 50;
	private static final int COURSE_COUNT = 4;

	public static void main(String[] args) {
		Student[] students = new Student[STUDENT_COUNT];

		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(generateFullName(5), Math.random() * 3.0);
			students[i].setCourses(generateCourseBag(COURSE_COUNT));
		}

		printStudents(students);
	}

	private static void printStudents(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			System.out.printf("[%d] %s\n", i, students[i].getName());
			System.out.printf("\t- GPA: %.2f\n", students[i].getGpa());
		}
	}
}
