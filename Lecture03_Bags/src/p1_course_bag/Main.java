package p1_course_bag;

public class Main {
	public static void main(String[] args) {
		CourseBag bag = new CourseBag(10);
		Course c1 = new Course("CSE148", "OOP", 4);
		Course c2 = new Course("CSE110", "CS College Seminar", 1);
		Course c3 = new Course("MAT141", "Calculus I", 4);
		Course c4 = new Course("PHY130", "Physics I", 4);
		bag.add(c1);
		bag.add(c2);
		bag.add(c3);
		bag.add(c4);
		bag.display();

		System.out.println();

//		// will display the course just like above or null if not found
//		Course courseFound = bag.searchBy("MAT142");
//		System.out.println(courseFound);
//
//		System.out.println();
//
//		// search and remove a course from the bag (assuming it exists)
//		System.out.println("before removal:");
//		bag.display();
//		bag.removeBy("PHY130");
//		System.out.println("after removal:");
//		bag.display();
//
//		System.out.println();
//
//		// will display the courses that match the number of credits we're looking for
//		Course[] matchedCourses = bag.searchBy(1);
//		System.out.println(Arrays.toString(matchedCourses));
//
//		System.out.println();
//
//		// search and remove courses from the bag (via credits)
//		System.out.println("remove by credits:");
//		Course[] matchedCoursesCredits = bag.removeBy(4);
//		System.out.println(Arrays.toString(matchedCoursesCredits));
//
//		// change the title
//		Course match = bag.searchBy("CSE148");
//		if (match != null) {
//			match.setCourseTitle("Object Oriented Programming");
//		}
//
//		// change all courses with 4 credits to 3
//		Course[] matches = bag.searchBy(4);
//		if (matches.length > 0) {
//			for (int i = 0; i < matches.length; i++) {
//				matches[i].setCredits(3);
//			}
//		}

		// find CSE148 and change the title back to OOP, don't change the bag, only the object
		Course cse148 = bag.searchBy("CSE148");
		Course newCse148 = new Course(cse148.getCourseNumber(), "Object Oriented Programming", cse148.getCredits());

		System.out.println("copy:");
		System.out.println(newCse148);

		System.out.println("after copy was changed:");
		bag.display();
	}
}
