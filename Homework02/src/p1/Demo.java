package p1;

import static p1.NameHelper.generateFullName;
import static p1.course.CourseHelper.generateCourse;
import static p1.course.CourseHelper.generateCourseTitle;

import java.util.Random;

import p1.course.Course;

public class Demo {
	private static final int STUDENT_COUNT = 50;
	private static Random random = new Random();
	
	public static void main(String[] args) {
		Student[] students = new Student[STUDENT_COUNT];
		for (int i = 0 ; i < students.length; i++) {
			students[i] = new Student(generateFullName(5), Math.random() * 3.0);
			students[i].setCourses(new Course[random.nextInt(5) + 1]);
			
			for (int j = 0; j < students[i].getCourses().length; j++) {
				students[i].getCourses()[j] = new Course(generateCourse(),
						generateCourseTitle(), random.nextInt(5) + 1);
			}
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
