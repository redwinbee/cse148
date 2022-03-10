package p2_function_injection;

public class DemoCalculator {
    public static void main(String[] args) {
        /*
        with Calculator taking a Computable in the constructor we can specify
        at object creation time how this calculator should compute the values using
        the methods declared in Computable.
         */
        Calculator c1Normal = new Calculator(new Computable() {
            @Override
            public double add(double a, double b) {
                return a + b;
            }

            @Override
            public double sub(double a, double b) {
                return a - b;
            }
        });

        /*
        for example here we can specify this calculator should do what the c1Normal
        calculator does, except add an extra 1. this is all possible thanks to
        interfaces and functions as data.
         */
        Calculator c1Extra1 = new Calculator(new Computable() {
            @Override
            public double add(double a, double b) {
                return (a + b) + 1;
            }

            @Override
            public double sub(double a, double b) {
                return (a - b) + 1;
            }
        });

        System.out.println("c1Normal (5 + 6): " + c1Normal.addThem(5, 6));
        System.out.println("c1Normal (5 - 6): " + c1Normal.subThem(5, 6));
        System.out.println("c1Extra1 (5 + 6): " + c1Extra1.addThem(5, 6));
        System.out.println("c1Extra1 (5 - 6): " + c1Extra1.subThem(5, 6));
    }
}
