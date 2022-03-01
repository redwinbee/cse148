package hw5;

import java.util.Arrays;

public class Demo {
    private static final int PERSON_BAG_COUNT = 10;

    public static void main(String[] args) {
        PersonBag personBag = new PersonBag(PERSON_BAG_COUNT);
        Person p1 = new Student(new Name("John", "Doe"), "8888888888", "CS", 3.9);
        Person p2 = new Instructor(new Name("Jane", "Doe"), "7777777777", 55_555.0, "9999999999");
        personBag.insert(p1);
        personBag.insert(p2);
        personBag.display();

        // search
        Person[] sameLastNamePeople = personBag.searchByLastName("Doe");
        System.out.println(Arrays.toString(sameLastNamePeople));
    }
}
