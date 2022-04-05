package p1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PersonBag {
    private final ArrayList<Person> people;

    public PersonBag(int size) {
        people = new ArrayList<>(size);
    }

    public void insert(Person person) {
        people.add(person);
    }

    public void remove(Person person) {
        people.remove(person);
    }

    public void display() {
        for (int i = 0; i < people.size(); i++) {
            System.out.printf("[%d]: %s%n", i, people.get(i));
        }
    }

    public ArrayList<Person> search(Predicate<Person> predicate) {
        ArrayList<Person> out = new ArrayList<>();
        for (Person person : people) {
            if (predicate.test(person)) {
                out.add(person);
            }
        }

        out.trimToSize();
        return out;
    }
}
