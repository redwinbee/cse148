package p2;

public class Worker {
    private String name;
    private final Payable payable;

    public Worker(String name, Payable payable) {
        this.name = name;
        this.payable = payable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay(double hours, double rate) {
        return payable.earn(hours, rate);
    }
}
