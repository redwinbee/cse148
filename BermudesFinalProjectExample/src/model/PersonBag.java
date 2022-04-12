package model;

import java.io.Serializable;

public class PersonBag implements Serializable {
    private final Person[] people;
    private int elements;

    public PersonBag(int size) {
        people = new Person[size];
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
