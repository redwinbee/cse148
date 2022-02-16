package p1.objects;

import java.util.Arrays;

public class Student {
    private static int idCount = 0;

    private Name name;
    private String major;
    private Course[] courses;
    private double gpa;
    private String id;

    public Student(Name name, String major, Course[] courses, double gpa) {
        super();
        this.name = name;
        this.major = major;
        this.courses = courses;
        this.gpa = gpa;
        this.id = String.valueOf(idCount++);
    }

    public Student(Name name) {
        super();
        this.name = name;
        this.id = String.valueOf(idCount++);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", id='" + id + '\'' +
                '}';
    }
}
