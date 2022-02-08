package p1;

import static p1.NameHelper.generateFullName;
import static p1.course.CourseHelper.generateCourseBag;

import p1.course.CourseBag;

public class Demo {
	private static final int STUDENT_COUNT = 50;
	private static final int COURSE_COUNT_MAX = 4;

	public static void main(String[] args) {
		Student[] students = new Student[STUDENT_COUNT];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(generateFullName(5), Math.random() * 4.0);
			students[i].setCourses(generateCourseBag((int) (Math.random() * COURSE_COUNT_MAX) + 1));
		}
		
		display(students);
	}
	
	private static void display(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			System.out.printf("[%d] %s\n", i, students[i]);
			CourseBag courses = students[i].getCourses();
			for (int j = 0; j < courses.getSize(); j++) {
				System.out.printf("\t[%d] %s\n", j, courses.get(j));
			}
		}
	}	
}
