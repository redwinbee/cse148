package p1_intro;

public interface Animal {
    /*
    every variable you specify in interfaces take on the following
    signature:
        public static final T varName = initialValue; // T == some type
     */
    int WEIGHT = 0;

    void fly();

    void walk();

    void swim();

    /*
    interfaces don't allow for methods with completed bodies, however,
    the exception is that you *can* complete a method here so long as it is
    marked with the keyword 'default'.

    same thing with methods marked with 'static' but of course you have to use
    it in a static way -> Animal.jump()
     */
    default void sayHi() {
        System.out.println("hi!");
    }

    static void jump() {
        System.out.println("the animal jumps.");
    }
}
