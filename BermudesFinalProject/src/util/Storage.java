package util;

import model.bag.PersonBag;
import model.bag.TextbookBag;
import model.person.Person;

import java.io.*;

public class Storage {
    protected static final File TEXTBOOKS_FILE = new File("data/textbooks.dat");
    protected static final File PEOPLE_FILE = new File("data/people.dat");

    public static void backup(TextbookBag textbookBag, PersonBag personBag) {
        backup(textbookBag);
        backup(personBag);
    }

    public static void backup(TextbookBag textbookBag) {
        System.out.printf("[storage]: backing up %d textbooks...%n", textbookBag.getElementCount());
        try {
            FileOutputStream fos = new FileOutputStream(TEXTBOOKS_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(textbookBag.getElementCount());
            oos.writeObject(textbookBag);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void backup(PersonBag personBag) {
        System.out.printf("[storage]: backing up %d people...%n", personBag.getElementCount());
        try {
            FileOutputStream fos = new FileOutputStream(PEOPLE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(personBag.getElementCount());
            oos.writeObject(personBag);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static TextbookBag restoreTextbooks() {
        try {
            FileInputStream fisTextbooks = new FileInputStream(TEXTBOOKS_FILE);
            ObjectInputStream oisTextbooks = new ObjectInputStream(fisTextbooks);

            int textbooksElementCount = oisTextbooks.readInt();
            TextbookBag textbookBag = (TextbookBag) oisTextbooks.readObject();
            textbookBag.setElementCount(textbooksElementCount);

            System.out.printf("[storage]: restoring %d textbooks...%n", textbooksElementCount);
            return textbookBag;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static PersonBag restorePeople() {
        try {
            FileInputStream fisPeople = new FileInputStream(PEOPLE_FILE);
            ObjectInputStream oisPeople = new ObjectInputStream(fisPeople);

            int peopleElementCount = oisPeople.readInt();
            PersonBag personBag = (PersonBag) oisPeople.readObject();
            personBag.setElementCount(peopleElementCount);
            Person.setIdCount(peopleElementCount);

            System.out.printf("[storage]: restoring %d people...%n", peopleElementCount);
            return personBag;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
