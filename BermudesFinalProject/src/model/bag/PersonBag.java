package model.bag;

import model.Person;

import java.io.Serializable;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Represents a bag of Person objects with an array as the underlying
 * data structure. Methods provided are the usual create, read, update, delete
 * methods.
 */
public class PersonBag implements Serializable {
    private Person[] people;
    private int elements;

    /**
     * Creates a new bag that can hold Person objects, optionally with given
     * size to initial the backing array with.
     *
     * @param initialCapacity The initial size of the backing array.
     */
    public PersonBag(int initialCapacity) {
        this.people = new Person[initialCapacity];
    }

    /**
     * Inserts a person into the array. If the backing array is at max
     * capacity it will automatically be expanded by 10; this is done by
     * copying the array to a new array with the capacity set to:
     * <p>
     * newArray[oldArray + 10]
     * <p>
     * with all contents being copied over to the new array and the person
     * to be inserted at the end.
     *
     * @param person The person to add to the bag.
     */
    public void insert(Person person) {
        if (elements >= people.length) {
            people = resize();
        }

        people[elements++] = person;
    }

    /**
     * Inserts the given array of people into the backing array. This method
     * called the inner method {@link #insert(Person)} which handles the resizing
     * of the array if necessary.
     *
     * @param people The array of people to add to the bag.
     */
    public void insertAll(Person... people) {
        for (Person person : people) {
            insert(person);
        }
    }

    /**
     * Searches the backing array for a person that returns true for the
     * given predicate. If the array does not contain any such person objects,
     * the result is an empty array, otherwise the results.
     *
     * @param predicate The predicate to test each person with.
     * @return An array list of people found, can be empty.
     */
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


    /**
     * Deletes all person objects from the backing array that match
     * the given predicate. The array is modified after each removal to
     * avoid nulls in between data and truncated. The result is returned
     * as an array of Person objects that can potentially contain zero values
     * if the predicate returned false for all elements in the array.
     *
     * @param predicate The predicate to test each element with.
     * @return The people deleted from the bag, if any.
     */
    @SuppressWarnings("ManualArrayCopy")
    public Person[] delete(Predicate<Person> predicate) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(people[i])) {
                out[count++] = people[i];
                for (int j = 0; j < elements - 1; j++) {
                    people[j] = people[j + 1];
                }

                elements--;
                i--;
            }
        }

        return Arrays.copyOf(out, count);
    }

    /**
     * Display the contents of the bag.
     */
    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, people[i]);
        }
    }

    private Person[] resize() {
        Person[] out = new Person[people.length + 10];
        System.arraycopy(people, 0, out, 0, people.length);
        return out;
    }

    public int getElementCount() {
        return elements;
    }

    public void setElementCount(int elementCount) {
        this.elements = elementCount;
    }

    public int capacity() {
        return people.length;
    }
}
