package p4;

import p1.Analyzable;
import p1.GpaAnalyzable;
import p1.IdAnalyzable;
import p1.RankAnalyzable;
import p2.Person;
import p3.Instructor;
import p3.Student;

import java.util.Arrays;
import java.util.function.Predicate;

public class PersonBag implements IdAnalyzable {
    private final Person[] people;
    private int elements;

    public PersonBag(int size) {
        this.people = new Person[size];
    }

    public void insert(Person person) {
        people[elements++] = person;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, people[i]);
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

    public Person[] search(RankAnalyzable rankAnalyzable) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (people[i] instanceof Instructor instructor) {
                Instructor analyzed = rankAnalyzable.analyzeRank(instructor);
                if (analyzed != null) {
                    out[count++] = analyzed;
                }
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Person[] search(GpaAnalyzable gpaAnalyzable) {
        Person[] out = new Person[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (people[i] instanceof Student student) {
                Student analyzed = gpaAnalyzable.analyzeGpa(student);
                if (analyzed != null) {
                    out[count++] = analyzed;
                }
            }
        }

        return Arrays.copyOf(out, count);
    }

    public Person[] search(Analyzable analyzable) {
        return analyzable.analyze(people);
    }

    @Override
    public Person getPersonWithHighestId() {
        Person max = people[0];
        for (int i = 0; i < elements; i++) {
            Person curr = people[i];
            if (Integer.parseInt(curr.getId()) > Integer.parseInt(max.getId())) {
                max = curr;
            }
        }

        return max;
    }
}
