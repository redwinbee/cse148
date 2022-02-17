package p2;

import java.util.Objects;

public class Student {
    private Name name;
    private double gpa;

    public Student(Name name, double gpa) {
        this.name = new Name(name);
        this.gpa = gpa;
    }

    /**
     * create a deep-copy of another student
     *
     * @param student the student to copy
     */
    public Student(Student student) {
        this.name = new Name(student.getName());
        this.gpa = student.getGpa();
    }

    public Name getName() {
        return new Name(name); // deep-copy
    }

    public void setName(Name name) {
        this.name = new Name(name); // deep-copy
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
                "name=" + name +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }
}
