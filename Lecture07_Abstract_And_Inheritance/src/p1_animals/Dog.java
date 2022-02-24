package p1_animals;

public class Dog extends Pet {
    private String breed;

    public Dog(String name, int weight, String breed) {
        super(name, weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void move() {
        System.out.println("[dog] moved!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                "} " + super.toString();
    }
}
