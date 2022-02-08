package p1.course;

import java.util.Random;

import p1.Util;

public class CourseHelper {
	private static final String[] COURSES =
		{ "CSE", "CST", "MAT", "ENG", "PHY", "PED", "BUS", "PSY" };
	private static Random random = new Random();

	public static String generateCourse() {
		String course = COURSES[random.nextInt(COURSES.length)];
		course += random.nextInt(300) + 100;

		return course;
	}

	public static String generateCourseTitle() {
		return Util.generateRandomString(random.nextInt(21) + 10, false);
	}

	public static CourseBag generateCourseBag(int size) {
		CourseBag courses = new CourseBag(size);
		for (int i = 0; i < size; i++) {
			courses.add(new Course(generateCourse(), generateCourseTitle(), random.nextInt(4) + 1));
		}

		return courses;
	}
}
