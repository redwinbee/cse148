package p1.course;

public class CourseBag {
	private Course[] courses;
	private int elems;

	public CourseBag(int size) {
		courses = new Course[size];
	}

	public void add(Course course) {
		courses[elems++] = course;
	}

	public void remove(Course course) {
		courses[elems--] = course;
	}

	public int getSize() {
		return elems;
	}
}
