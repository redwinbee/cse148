package hw08.objects;

import java.util.StringJoiner;

public class Student extends Person {
    private double gpa;

    public Student(Name name, double gpa) throws IncorrectGPAException {
        super(name);
        if (gpa < 1.0 || gpa > 4.0) {
            throw new IncorrectGPAException("GPA must be in the range: 1.0 < GPA < 4.0");
        }
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) throws IncorrectGPAException {
        if (gpa < 1.0 || gpa > 4.0) {
            throw new IncorrectGPAException("GPA must be in the range: 1.0 < GPA < 4.0");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + super.toString() + "'")
                .add("gpa=" + gpa)
                .toString();
    }
}
