package p1.course;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private int credits;
	
	/**
	 * creates a course
	 * 
	 * @param courseNumber the course number
	 * @param courseTitle the title of the course
	 * @param credits the amount of credits for passing the course
	 */
	public Course(String courseNumber, String courseTitle, int credits) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return String.format("course={%s, %s, %d}", courseNumber, courseTitle, credits);
	}
	
}
