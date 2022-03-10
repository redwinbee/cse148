package p4_lambda_expr;

public class DemoFunctionalInterface {
    public static void main(String[] args) {
        // anonymous class
        Computable c1 = new Computable() {
            @Override
            public double compute(double a, double b) {
                return a + b;
            }
        };

        Computable c2 = new Computable() {
            @Override
            public double compute(double a, double b) {
                return a - b;
            }
        };
        System.out.println("c1 (5 + 4): " + c1.compute(5, 4));
        System.out.println("c2 (5 - 4): " + c2.compute(5, 4));

        // lambda expression
        Computable c3 = (a, b) -> a * b;
        System.out.println("c3 (5 * 4): " + c3.compute(5, 4));
    }
}
