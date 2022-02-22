package p1_intro;

public class Student extends Person {
    private double gpa;

    public Student(Name name, double gpa) {
        super(name);
        this.gpa = gpa;
    }

    public Student(Name name) {
        super(name);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{} " + super.toString();
    }
}
