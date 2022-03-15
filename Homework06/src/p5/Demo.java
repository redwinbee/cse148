package p5;

import p1.GpaAnalyzable;
import p1.Name;
import p1.RankAnalyzable;
import p2.Person;
import p3.Instructor;
import p3.Student;
import p4.PersonBag;

import java.util.function.Predicate;

public class Demo {
    private static final int MAX_PEOPLE = 50;

    public static void main(String[] args) {
        PersonBag personBag = generatePersonBag();

        // search all people with the same last name
        Person[] matchingLastName = personBag.search((Predicate<Person>) person -> person.getName().getLastName().equals("Doe"));
        System.out.println("=== PEOPLE WITH LAST NAMES 'Doe' ===");
        display(matchingLastName);

        // search all people with the same rank
        Person[] matchingRank = personBag.search((RankAnalyzable) instructor -> instructor.getRank().equals("Professor") ? instructor : null);
        System.out.println("=== PEOPLE WITH RANK 'Professor' ===");
        display(matchingRank);

        // search all people with the same ranks
        Person[] matchingRanks = personBag.search((RankAnalyzable) instructor ->
                instructor.getRank().equals("Associate Professor") || instructor.getRank().equals("Lecturer") ? instructor : null);
        System.out.println("=== PEOPLE WITH RANKS 'Associate Professor' AND 'Lecturer' ===");
        display(matchingRanks);

        // search all people with a gpa of < 3.9
        Person[] gpaLessThan39 = personBag.search((GpaAnalyzable) student -> student.getGpa() < 3.9 ? student : null);
        System.out.println("=== PEOPLE WITH GPA LESS THAN '3.9' ===");
        display(gpaLessThan39);
    }

    private static PersonBag generatePersonBag() {
        PersonBag personBag = new PersonBag(MAX_PEOPLE);
        personBag.insert(new Student(new Name("John", "Doe"), 4.0));
        personBag.insert(new Student(new Name("Jane", "Doe"), 3.5));
        personBag.insert(new Student(new Name("Jack", "Frost"), 3.7));
        personBag.insert(new Student(new Name("Ana", "Frost"), 3.9));
        personBag.insert(new Instructor(new Name("Frank", "Connors"), "Lecturer"));
        personBag.insert(new Instructor(new Name("Alex", "Doe"), "Professor"));
        personBag.insert(new Instructor(new Name("Julia", "Frost"), "Associate Professor"));
        personBag.insert(new Instructor(new Name("Chris", "Byers"), "Assistant Professor"));
        personBag.insert(new Instructor(new Name("Felix", "Connors"), "Professor"));


        return personBag;
    }

    private static void display(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.printf("[%d]: %s%n", i, people[i]);
        }
    }
}
