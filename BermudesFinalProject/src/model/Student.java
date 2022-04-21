package model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Represents a student that contains data about a students current gpa and
 * major.
 */
public class Student extends Person implements Serializable {
    private double gpa;
    private String major;

    /**
     * Creates a new student with the given name, gpa, and major.
     *
     * @param name  The name to give this student.
     * @param gpa   The gpa of the student.
     * @param major The major of the student.
     */
    public Student(Name name, double gpa, String major) {
        super(name);
        this.gpa = gpa;
        this.major = major;
    }

    /**
     * Gets this student's current GPA.
     *
     * @return The current GPA.
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets this student's GPA.
     *
     * @param gpa The new GPA.
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Gets this student's current major.
     *
     * @return THe current major.
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets this student's major.
     *
     * @param major The new major.
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Returns a string representation of this student. Contains their name, ID number,
     * GPA, and major.
     *
     * @return This student in string format.
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("id=" + this.getId())
                .add("name=" + this.getName())
                .add("gpa=" + gpa)
                .add("major='" + major + "'")
                .toString();
    }
}
