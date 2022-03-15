package p2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Bag {
    private final ArrayList<Student> students;

    /**
     * Generates a new bag backed by an ArrayList.
     * @param initialCapacity The initial capacity of the list.
     */
    public Bag(int initialCapacity) {
        students = new ArrayList<>(initialCapacity);
    }

    public void insert(Student student) {
        students.add(student);
    }

    public ArrayList<Student> search(Predicate<Student> predicate) {
        ArrayList<Student> out = new ArrayList<>(students.size());
        for (Student student : students) {
            if (predicate.test(student)) {
                out.add(student);
            }
        }

        out.trimToSize();
        return out;
    }

    public ArrayList<Student> remove(Predicate<Student> predicate) {
        ArrayList<Student> out = new ArrayList<>(students.size());
        for (Student student : students) {
            if (predicate.test(student)) {
                out.add(student);
                students.remove(student);
            }
        }

        out.trimToSize();
        return out;
    }

    public void display() {
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("[%d]: %s%n", i, students.get(i));
        }
    }
}
