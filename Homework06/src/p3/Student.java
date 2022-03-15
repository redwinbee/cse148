package p3;

import p1.Name;
import p2.Person;

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
        return "Student{" +
                "gpa=" + gpa +
                "} " + super.toString();
    }
}
