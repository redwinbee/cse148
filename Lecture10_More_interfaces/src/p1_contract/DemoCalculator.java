package p1_contract;

public class DemoCalculator {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println("c1 add 5 and 4: " + c1.add(5, 4));
        System.out.println("c1 sub 5 and 4: " + c1.sub(5, 4));
    }
}
