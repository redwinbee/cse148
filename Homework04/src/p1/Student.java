package p1;

import java.util.Arrays;

public class Student {
    private Name name;
    private Course[] courses;

    public Student(Name name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public Student(Student student) {
        this.name = new Name(student.getName());
        this.courses = student.getCourses();
    }

    public Name getName() {
        return new Name(name);
    }

    public void setName(Name name) {
        this.name = new Name(name);
    }

    public Course[] getCourses() {
        Course[] copy = new Course[courses.length];
        System.arraycopy(courses, 0, copy, 0, copy.length);
        return copy;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
