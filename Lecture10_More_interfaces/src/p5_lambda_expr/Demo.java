package p5_lambda_expr;

public class Demo {
    public static void main(String[] args) {
        Computable add = (x, y) -> x + y;
        Computable sub = (x, y) -> x - y;
        Computable mul = (x, y) -> x * y;
        Computable div = (x, y) -> x / y;

        System.out.println("add (5 + 4): " + add.compute(5 ,4));
        System.out.println("sub (5 - 4): " + sub.compute(5 ,4));
        System.out.println("mul (5 * 4): " + mul.compute(5 ,4));
        System.out.println("div (5 / 4): " + div.compute(5 ,4));
    }
}
