package p2_function_injection;

public class Calculator {
    private final Computable computable;

    public Calculator(Computable computable) {
        this.computable = computable;
    }

    public double addThem(double a, double b) {
        return computable.add(a, b);
    }

    public double subThem(double a, double b) {
        return computable.sub(a, b);
    }
}
