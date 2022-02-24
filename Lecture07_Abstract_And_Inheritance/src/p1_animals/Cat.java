package p1_animals;

public class Cat extends Pet {
    private String colour;

    public Cat(String name, int weight, String colour) {
        super(name, weight);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void move() {
        System.out.println("[cat] moved!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "colour='" + colour + '\'' +
                "} " + super.toString();
    }
}
