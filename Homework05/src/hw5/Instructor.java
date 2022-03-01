package hw5;

public class Instructor extends Person {
    private double salary;
    private String phoneNumber;

    public Instructor(Name name, String phone, double salary, String phoneNumber) {
        super(name, phone);
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public Instructor(Instructor instructor) {
        super(instructor.getName(), instructor.getPhone());
        this.salary = instructor.getSalary();
        this.phoneNumber = instructor.getPhoneNumber();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                "} " + super.toString();
    }
}
