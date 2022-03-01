package hw5;

public class Student extends Person {
    private String major;
    private double gpa;

    public Student(Name name, String phone, String major, double gpa) {
        super(name, phone);
        this.major = major;
        this.gpa = gpa;
    }

    public Student(Student student) {
        super(student.getName(), student.getPhone());
        this.major = student.getMajor();
        this.gpa = student.getGpa();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
                "major='" + major + '\'' +
                ", gpa=" + gpa +
                "} " + super.toString();
    }
}
