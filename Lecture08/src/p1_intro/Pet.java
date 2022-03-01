package p1_intro;

public abstract class Pet {
    private String name;
    private int weight;

    public Pet(String name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    /*
    an abstract method can be defined *only* inside an abstract class and states that,
    classes that extend Pet *must* have an implementation of the move() function since it
    is not implemented here, only declared.
     */
    public abstract void move();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
