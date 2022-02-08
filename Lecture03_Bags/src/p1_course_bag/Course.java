package p1_course_bag;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private int credits;

	public Course(String courseNumber, String courseTitle, int credits) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	/* Constructors */

	public Course(String courseNumber, int credits) {
		super();
		this.courseNumber = courseNumber;
		this.credits = credits;

	}

	public Course(String courseNumber) {
		super();
		this.courseNumber = courseNumber;
	}

	public Course(int credits) {
		super();
		this.credits = credits;
	}

	/* Getters/Setters */

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

	/* Overrides */

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", credits=" + credits + "]";
	}
}
