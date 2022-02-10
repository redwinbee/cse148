package p1_course_bag;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		CourseBag myBag = new CourseBag(10);
		Course c1 = new Course("CSE148", "Object Oriented Programming", 4);
		Course c2 = new Course("CSE110", "CS College Seminar", 1);
		Course c3 = new Course("MAT141", "Calculus I", 4);
		Course c4 = new Course("PHY130", "Physics I", 4);
		myBag.add(c1);
		myBag.add(c2);
		myBag.add(c3);
		myBag.add(c4);
		myBag.display();

		System.out.println();

		// will display the course just like above or null if not found
		Course courseFound = myBag.searchBy("MAT142");
		System.out.println(courseFound);

		System.out.println();

		// search and remove a course from the bag (assuming it exists)
		System.out.println("before removal:");
		myBag.display();
		myBag.removeBy("PHY130");
		System.out.println("after removal:");
		myBag.display();

		System.out.println();

		// will display the courses that match the number of credits we're looking for
		Course[] matchedCourses = myBag.searchBy(1);
		System.out.println(Arrays.toString(matchedCourses));
		
		System.out.println();
		
		// search and remove courses from the bag (via credits)
		System.out.println("remove by credits:");
		Course[] matchedCoursesCredits = myBag.removeBy(4);
		System.out.println(Arrays.toString(matchedCoursesCredits));
	}
}
