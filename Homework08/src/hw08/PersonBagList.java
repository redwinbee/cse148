package hw08;

import hw08.objects.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class PersonBagList {
    private final ArrayList<Person> people;

    public PersonBagList(int size) {
        people = new ArrayList<Person>(size);
    }
    public void insert(Person person) {
        people.add(person);
    }

    public void display() {
        for (int i = 0; i < people.size(); i++) {
            System.out.printf("[%d] %s%n", i, people.get(i));
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

    public ArrayList<Person> remove(Predicate<Person> predicate) {
        ArrayList<Person> removed = new ArrayList<>();
        for (Person person : people) {
            if (predicate.test(person)) {
                removed.add(person);
                people.remove(person);
            }
        }

        removed.trimToSize();
        return removed;
    }

    public ArrayList<Person> sort(ArrayList<Person> list) {
        ArrayList<Person> out = new ArrayList<>(list.size());
        for (Person person : list) {
            try {
                out.add(person.clone());
            } catch (CloneNotSupportedException ex) {
                System.err.println("[ex]: failed to clone object!");
                ex.printStackTrace();
            }
        }

        out.trimToSize();
        Collections.sort(out);
        return out;
    }
}
