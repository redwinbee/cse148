package hw08;

import hw08.objects.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        Student s1 = createStudent();
        Student s2 = null;
        Student s3 = null;
        try {
            s2 = new Student(new Name("jane", "doe"), 4.0);
            s3 = new Student(new Name("jack", "doe"), 3.9);
        } catch (IncorrectGPAException ex) {
            ex.printStackTrace();
        }
        Instructor i1 = createInstructor();
        Instructor i2 = null;
        Instructor i3 = null;
        try {
            i2 = new Instructor(new Name("A", "1"), "Lecturer");
            i3 = new Instructor(new Name("B", "1"), "Professor");
        } catch (IncorrectRankException ex) {
            ex.printStackTrace();
        }

        PersonBagList peopleList = new PersonBagList(6);
        PersonBagArray peopleArray = new PersonBagArray(6);
        peopleList.insert(s1);
        peopleList.insert(s2);
        peopleList.insert(s3);
        peopleList.insert(i1);
        peopleList.insert(i2);
        peopleList.insert(i3);
        peopleArray.insert(s1);
        peopleArray.insert(s2);
        peopleArray.insert(s3);
        peopleArray.insert(i3);
        peopleArray.insert(i1);
        peopleArray.insert(i2);

        // DISPLAY
        System.out.println("== DISPLAY (ARRAYLIST) ==");
        peopleList.display();
        System.out.println("== DISPLAY (ARRAY) ==");
        peopleArray.display();

        // SEARCH
        System.out.println("== SEARCH (ARRAYLIST) FOR GPA >= 4.0");
        ArrayList<Person> above4Oh = peopleList.search(person -> {
            if (person instanceof Student student) {
                return student.getGpa() >= 4.0;
            }

            return false;
        });
        display(above4Oh);
        System.out.println("== SEARCH (ARRAY) FOR GPA <= 3.9");
        Person[] below39 = peopleArray.search(person -> {
            if (person instanceof Student student) {
                return student.getGpa() <= 3.9;
            }

            return false;
        });
        display(below39);

        // SORT
        System.out.println("== SORTED (ALL) BY LAST NAME (DEFAULT) ==");
        ArrayList<Person> sortedPeopleList = peopleList.sort(above4Oh);
        Person[] sortedPeopleArray = peopleArray.sort(below39);
        display(sortedPeopleList);
        display(sortedPeopleArray);

        // REMOVE
        // ConcurrentModificationException ??

//        System.out.println("== REMOVE (ARRAYLIST) FOR ID == 1");
//        ArrayList<Person> idsOf1List = peopleList.remove(person -> person.getId().equals("1"));
//        display(idsOf1List);
//        System.out.println("== REMOVE (ARRAY) FOR ID == 1");
//        Person[] idsOf1Array = peopleArray.remove(person -> person.getId().equals("1"));
//        display(idsOf1Array);


        scanner.close();
    }

    public static Student createStudent() {
        System.out.println("== Create a student ==");

        System.out.print("enter a first name: ");
        String firstName = scanner.nextLine();
        System.out.print("enter a last name: ");
        String lastName = scanner.nextLine();


        Student student = null;
        System.out.print("enter a gpa: ");
        while (student == null) {
            double gpa = Double.parseDouble(scanner.nextLine());
            try {
                student = new Student(new Name(firstName, lastName), gpa);
            } catch (IncorrectGPAException ex) {
                System.err.println(ex.getMessage());
                System.out.print("enter a gpa: ");
            }
        }

        System.out.println("created: " + student);
        return student;
    }

    public static Instructor createInstructor() {
        System.out.println("== Create an instructor ==");

        System.out.print("enter a first name: ");
        String firstName = scanner.nextLine();
        System.out.print("enter a last name: ");
        String lastName = scanner.nextLine();

        Instructor instructor = null;
        System.out.print("enter a rank: ");
        while (instructor == null) {
            String rank = scanner.nextLine();
            try {
                instructor = new Instructor(new Name(firstName, lastName), rank);
            } catch (IncorrectRankException ex) {
                System.err.println(ex.getMessage());
                System.out.print("enter a rank: ");
            }
        }

        System.out.println("created: " + instructor);
        return instructor;
    }

    public static void display(Person... array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d] %s%n", i, array[i]);
        }
    }

    private static void display(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.printf("[%d]: %s%n", i, people.get(i));
        }
    }
}
