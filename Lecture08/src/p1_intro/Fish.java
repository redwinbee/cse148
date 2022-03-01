package p1_intro;

public class Fish implements Animal, Edible {
    private String colour;
    private double length;

    public Fish(String colour, double length) {
        this.colour = colour;
        this.length = length;
    }

    @Override
    public void fly() {
        System.out.println("this is a flying fish.");
    }

    @Override
    public void walk() {
        System.out.println("fish cannot walk.");
    }

    @Override
    public void swim() {
        System.out.println("the fish is swimming.");
    }

    @Override
    public void cook() {
        System.out.println("cooking the fish...");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "colour='" + colour + '\'' +
                ", length=" + length +
                '}';
    }
}
