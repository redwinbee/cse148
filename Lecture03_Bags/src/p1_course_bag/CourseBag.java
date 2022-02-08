package p1_course_bag;

import java.util.Arrays;

/**
 * A container for managing a group of courses in a controlled
 * manner. Includes the basic methods for a group of objects such as
 * create, read, update, delete (C.R.U.D).
 *
 * @author redwinbee
 */
public class CourseBag {
	private Course[] courses;
	private int nElems;

	/**
	 * Creates a bag of courses with a given size.
	 *
	 * @param size The size of the bag.
	 */
	public CourseBag(int size) {
		courses = new Course[size];
	}

	/**
	 * Adds a course to the bag.
	 *
	 * @param course The course to add.
	 */
	public void add(Course course) {
		courses[nElems++] = course;
	}

	/**
	 * Removes a course from the bag.
	 *
	 * @param course The course to add.
	 */
	public void remove(Course course) {
		courses[nElems--] = course;
	}

	/**
	 * Displays the contents of the bag.
	 */
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(courses[i]);
		}
	}

	/**
	 * Searches the bag for a course using the course
	 * number.
	 *
	 * @param courseNumber The course number of the course to look for.
	 * @return The course if found, otherwise null.
	 */
	public Course searchBy(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (courses[i].getCourseNumber().equals(courseNumber)) {
				return courses[i];
			}
		}

		// nothing found
		return null;
	}

	/**
	 * Searches the bag for courses that offer a certain
	 * amount of credits.
	 *
	 * @param credits The credits a course provides
	 * @return The courses that provide the credits
	 */
	public Course[] searchBy(int credits) {
		Course[] matches = new Course[nElems];
		int count = 0;

		for (int i = 0; i < nElems; i++) {
			if (courses[i].getCredits() == credits) {
				matches[count++] = courses[i];
			}
		}
		
		/**
		 * we only want to return the actual matches we found, not all
		 * the possible nulls after the data.
		 */
		return Arrays.copyOf(matches, count);
	}

	/**
	 * Removes a course from the bag using the course
	 * number. To clarify, assuming the course was found, after this method
	 * completes the course will no longer exist in the bag.
	 *
	 * @param courseNumber The course number of the course to remove
	 * @return The course removed.
	 */
	public Course removeBy(String courseNumber) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (courses[i].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}

		if (i == nElems) {
			return null;
		} else {
			/**
			 * since we want to remove an element from the array, we need to make sure
			 * there are no holes in between the data. the only way to do that is to shift
			 * all the data over so that we leave no holes AND maintain the order of the data.
			 * (assuming that is important)
			 */
			Course temp = courses[i];
			for (int j = 0; j < nElems-1; j++) {
				courses[j] = courses[j+1];
			}

			nElems--;
			return temp;
		}
	}
	
//	/**
//	 * Removes all the courses that match the number of credits.
//	 * @param credits The credits of the courses to be removed.
//	 * 
//	 * @return The courses removed.
//	 */
//	public Course[] removeBy(int credits) {
//		Course[] matches = new Course[nElems];
//	}
}
