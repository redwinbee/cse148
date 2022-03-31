package p3;

import java.util.StringJoiner;

@SuppressWarnings("unused")
public class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) throws IncorrectGPAException {
        super();
        this.name = name;
        if (gpa > 4.0 || gpa < 0.0) {
            throw new IncorrectGPAException("The GPA entered is not valid: [0.0 < GPA < 4.0]");
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
