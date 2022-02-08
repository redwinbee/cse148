package p1.course;

import java.util.Random;

import p1.Helper;

public class CourseHelper {
	private static final String[] COURSES =
		{ "CSE", "CST", "MAT", "ENG", "PHY", "PED", "BUS", "PSY" };
	private static Random random = new Random();
	
	/**
	 * generates a random course from the list of available courses
	 * with the 3 digits ranging from 100 to 299 (inclusive).
	 * 
	 * example: CSE148
	 * 
	 * @return the course string
	 */
	public static String generateCourse() {
		String course = COURSES[random.nextInt(COURSES.length)];
		course += random.nextInt(300) + 100;
		
		return course;
	}
	
	/**
	 * generates the course title which is a random string of
	 * 10 to 20 characters, inclusive.
	 * 
	 * @return the course title
	 */
	public static String generateCourseTitle() {
		return Helper.generateRandomString(random.nextInt(21) + 10, false);
	}
}
