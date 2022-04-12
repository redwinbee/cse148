package model;

import java.io.Serializable;

public class PersonBagSingleton implements Serializable {
    private static PersonBagSingleton personBag;
    private final Person[] people;
    private int elements;

    private PersonBagSingleton(int size) {
        people = new Person[size];
    }

    public static PersonBagSingleton getInstance(int size) {
        return personBag == null ? personBag = new PersonBagSingleton(size) : personBag;
    }

    public void insert(Person person) {
        people[elements++] = person;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, people[i]);
        }
    }
}
