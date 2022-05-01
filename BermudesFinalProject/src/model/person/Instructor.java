package model.person;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Represents an instructor that contains data about an instructors current rank
 * and salary.
 */
public class Instructor extends Person implements Serializable {
    public static final String[] RANKS = {"Instructor", "Assistant Professor", "Associate Professor", "Professor"};
    private String rank;
    private double salary;


    /**
     * Creates a new instructor with the given name, rank, and salary.
     *
     * @param name   The name to give this instructor.
     * @param rank   The rank to give this instructor.
     * @param salary The salary to give this instructor.
     */
    public Instructor(Name name, String rank, double salary) {
        super(name);
        this.rank = rank;
        this.salary = salary;
    }

    /**
     * Gets this instructor's current rank.
     *
     * @return The current rank.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets this instructor's rank.
     *
     * @param rank The new rank.
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Gets this instructor's current salary.
     *
     * @return The current salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets this instructor's salary.
     *
     * @param salary The new salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a string representation of this instructor. Contains their name, ID number,
     * rank, and salary.
     *
     * @return This instructor in string format.
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Instructor.class.getSimpleName() + "[", "]")
                .add("id=" + this.getId())
                .add("name=" + this.getName())
                .add("rank='" + rank + "'")
                .add(String.format("salary=%.2f", salary))
                .toString();
    }
}
