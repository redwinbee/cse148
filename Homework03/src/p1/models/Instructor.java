package p1.models;

public class Instructor {
    private Name name;
    private String officeNumber;
    private String rank;
    private int id;
    private double salary;

    public Instructor(Name name, String officeNumber, String rank, int id, double salary) {
        this.name = name;
        this.officeNumber = officeNumber;
        this.rank = rank;
        this.id = id;
        this.salary = salary;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name=" + name +
                ", officeNumber='" + officeNumber + '\'' +
                ", rank='" + rank + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
