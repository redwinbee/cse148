package p2;

import java.util.StringJoiner;

public class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        super();
        this.name = name;
        if (gpa > 4.0 || gpa < 0.0) {
            throw new IllegalArgumentException("The GPA entered is not valid: [0.0 < GPA < 4.0]");
        }
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
