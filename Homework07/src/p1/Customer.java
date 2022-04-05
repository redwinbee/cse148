package p1;

import java.util.StringJoiner;

public class Customer {
    private String name;
    private double sale;

    public Customer(String name, double sale) {
        this.name = name;
        this.sale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("sale=" + sale)
                .toString();
    }
}
