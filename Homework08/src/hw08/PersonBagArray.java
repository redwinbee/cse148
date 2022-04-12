package hw08;

import hw08.objects.Person;

import java.util.Arrays;
import java.util.function.Predicate;

public class PersonBagArray {
    private final Person[] people;
    private int elements;

    public PersonBagArray(int size) {
        people = new Person[size];
    }

    public void insert(Person person) throws IndexOutOfBoundsException {
        people[elements++] = person;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d] %s%n", elements, people[i]);
        }
    }

    public Person[] search(Predicate<Person> predicate) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(people[i])) {
                out[count++] = people[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    @SuppressWarnings("ManualArrayCopy")
    public Person[] remove(Predicate<Person> predicate) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(people[i])) {
                out[count++] = people[i];
                for (int j = i; j < elements - 1; j++) {
                    people[j] = people[j+1];
                }

                elements--;
                i--;
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Person[] sort(Person[] array) {
        Person[] out = new Person[array.length];
        for (int i = 0; i < array.length; i++) {
            try {
                out[i] = array[i].clone();
            } catch (CloneNotSupportedException ex) {
                System.err.println("[ex]: failed to clone object!");
                ex.printStackTrace();
            }
        }

        Arrays.sort(out);
        return out;
    }
}
