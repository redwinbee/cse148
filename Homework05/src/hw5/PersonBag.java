package hw5;

import java.util.Arrays;

public class PersonBag {
    private final Person[] people;
    private int elements;

    public PersonBag(int size) {
        this.people = new Person[size];
    }

    public Person[] searchByLastName(String lastName) {
        Person[] out = new Person[elements];
        int matches = 0;
        for (Person person : people) {
            if (person != null) {
                if (person instanceof Student student) {
                    out[matches++] = new Student(student);
                } else if (person instanceof Instructor instructor) {
                    out[matches++] = new Instructor(instructor);
                }
            } else {
                break;
            }
        }

        return Arrays.copyOf(out, matches);
    }

    public Person searchById(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }

        return null;
    }

    public Person[] removeByLastName(String lastName) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (people[i].getName().getLastName().equals(lastName)) {
                out[count++] = people[i];
                for (int j = i; j < elements - 1; j++) {
                    people[j] = people[j + 1];
                }

                i--;
                elements--;
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Person removeById(String id) {
        int i;
        for (i = 0; i < elements; i++) {
            if (people[i].getId().equals(id)) {
                break;
            }
        }

        if (i == elements) {
            return null;
        } else {
            Person bak = people[i];
            for (int j = i; j < elements - 1; j++) {
                people[j] = people[j + 1];
            }

            elements--;
            return bak;
        }
    }

    public void insert(Person person) {
        people[elements++] = person;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%s] %s: %n", i, people[i]);
        }
        System.out.println();
    }
}
