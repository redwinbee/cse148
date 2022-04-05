package p1;

import java.util.StringJoiner;

public class Student extends Person {
    private double gpa;

    public Student(Name name, double gpa) {
        super(name);
        this.gpa = gpa;
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
                .add("name='" + this.getName().toString() + "'")
                .add("gpa=" + gpa)
                .toString();
    }
}
