package p3_interfaces;

public class DemoMoveable {
    public static void main(String[] args) {
        Moveable m1 = new DemoMoveable().new Dog();
        m1.move();
    }

    /*
    this is what is called a "private inner class"
     */
    private class Dog implements Moveable {
        @Override
        public void move() {
            System.out.println("the dog moves");
        }
    }
}
