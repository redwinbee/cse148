package p1_intro;

public class DemoAnimalInterface {
    public static void main(String[] args) {
        Fish f1 = new Fish("Blue", 10.5);
        f1.fly();
        f1.walk();
        f1.swim();
        f1.cook();
        Animal.jump();
        /*
        remember we can still use sayHi() even though we haven't implemented it in Fish
        because of the default method implementation in the interface Animal.
         */
        f1.sayHi();
    }
}
