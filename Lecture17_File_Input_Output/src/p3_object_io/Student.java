package p3_object_io;

import java.io.Serializable;
import java.util.StringJoiner;

public class Student implements Serializable {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        super();
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("gpa=" + gpa)
                .toString();
    }
}
