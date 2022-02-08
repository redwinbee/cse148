package p1;

import static p1.NameHelper.generateFullName;
import static p1.course.CourseHelper.generateCourse;
import static p1.course.CourseHelper.generateCourseTitle;

import java.util.Random;

import p1.course.Course;
import p1.course.CourseBag;

public class Demo {
	private static final int STUDENT_COUNT = 50;
	private static final int COURSE_COUNT = 4;
	private static Random random = new Random();

	public static void main(String[] args) {
		Student[] students = new Student[STUDENT_COUNT];
		CourseBag courses = new CourseBag(COURSE_COUNT);

		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(generateFullName(5), Math.random() * 3.0);
		}

		for (int i = 0; i < courses.getSize(); i++) {
			courses.add(new Course(generateCourse(), generateCourseTitle(), random.nextInt(5) + 1));
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
