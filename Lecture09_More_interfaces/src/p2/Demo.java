package p2;

public class Demo {
    public static void main(String[] args) {
        /*
        interfaces as data allow us to put off the implementation of a function until
        the very last moment when we actually need it, very useful for defining a method
        that will have different behaviours
         */
        Worker w1 = new Worker("Adam", (hours, rate) -> hours * rate);
        System.out.println("w1 name: " + w1.getName());
        System.out.println("w1 pay: " + w1.getPay(5.1, 15.25));

        Worker w2 = new Worker("Bill", (hours, rate) -> hours * rate * 1.1);
        System.out.println("w2 name: " + w2.getName());
        System.out.println("w2 pay: " + w2.getPay(5.1, 15.25));
    }
}
