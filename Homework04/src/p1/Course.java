package p1;

public class Course {
    private String courseNumber;
    private String courseTitle;
    private int credits;

    public Course(String courseNumber, String courseTitle, int credits) {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.credits = credits;
    }

    public Course(Course course) {
        this.courseNumber = course.getCourseNumber();
        this.courseTitle = course.getCourseTitle();
        this.credits = course.getCredits();
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
        return "Course{" +
                "courseNumber='" + courseNumber + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", credits=" + credits +
                '}';
    }
}
