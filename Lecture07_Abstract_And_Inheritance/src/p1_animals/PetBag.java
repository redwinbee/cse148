package p1_animals;

import java.util.Arrays;

public class PetBag {
    private final Pet[] pets;
    private int elements;

    public PetBag(int size) {
        this.pets = new Pet[size];
    }

    public void insert(Pet pet) {
        pets[elements++] = pet;
    }

    public Pet[] searchBy(String name) {
        Pet[] out = new Pet[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (pets[i].getName().equals(name)) {
                out[count++] = pets[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Pet[] searchBy(int weight) {
        Pet[] out = new Pet[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (pets[i].getWeight() >= weight) {
                out[count++] = pets[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Pet[] searchByColour(String colour) {
        Pet[] out = new Pet[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (pets[i] instanceof Cat cat) {
                if (cat.getColour().equals(colour)) {
                    out[count++] = pets[i];
                }
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Pet[] searchByBreed(String breed) {
        Pet[] out = new Pet[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (pets[i] instanceof Dog dog) {
                if (dog.getBreed().equals(breed)) {
                    out[count++] = pets[i];
                }
            }
        }

        return Arrays.copyOf(out, count);
    }

    @SuppressWarnings("ManualArrayCopy")
    public Pet[] removeBy(String name) {
        Pet[] out = new Pet[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (pets[i].getName().equals(name)) {
                out[count++] = pets[i];
                for (int j = i; j < elements - 1; j++) {
                    pets[j] = pets[j + 1];
                }

                i--;
                elements--;
            }
        }

        return Arrays.copyOf(out, count);
    }


    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%s]: %s%n", i, pets[i]);
        }
        System.out.println();
    }
}
