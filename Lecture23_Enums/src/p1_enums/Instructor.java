package p1_enums;

import java.util.StringJoiner;

public class Instructor {
    private String name;
    private Rank rank;
    private double salary;

    public Instructor(String name, Rank rank, double salary) {
        this.name = name;
        this.rank = rank;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Instructor.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("rank=" + rank)
                .add("salary=" + salary)
                .toString();
    }
}
