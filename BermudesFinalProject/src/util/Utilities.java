package util;

import model.person.Instructor;
import model.person.Name;
import model.person.Student;
import model.Textbook;
import model.bag.PersonBag;
import model.bag.TextbookBag;

public class Utilities {
    public static Name emitName() {
        String[] firstNames = Importer.getFirstNames();
        String[] lastNames = Importer.getLastNames();
        String randFirstName = firstNames[(int) ((Math.random() * firstNames.length))];
        String randLastName = lastNames[(int) ((Math.random() * lastNames.length))];
        return new Name(randFirstName, randLastName);
    }

    public static String[][] emitTitleAndIsbn() {
        String[] titles = Importer.getTextbookTitles();
        String[] isbns = Importer.getTextbookIsbns();

        String[][] arr = new String[titles.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = titles[i];
            arr[i][1] = isbns[i];
        }

        return arr;
    }

    public static double emitPrice() {
        return Math.random() * 200.0;
    }

    /**
     * Generates a {@link TextbookBag} with the given size and randomized
     * data. If there exists a previously backed up textbook bag, that data
     * is de-serialized back into a TextbookBag and returned.
     *
     * @param size The size of the new textbook bag.
     * @return The restored textbook bag, otherwise a new one.
     */
    public static TextbookBag importTextbooks(int size) {
        if (Storage.TEXTBOOKS_FILE.exists()) {
            return Storage.restoreTextbooks();
        }
        TextbookBag textbookBag = new TextbookBag(size);
        String[][] titleAndIsbn = emitTitleAndIsbn();
        for (int i = 0; i < textbookBag.capacity(); i++) {
            textbookBag.insert(new Textbook(titleAndIsbn[i][0], titleAndIsbn[i][1], emitName(), emitPrice()));
        }

        return textbookBag;
    }

    public static Student[] importStudents(int size) {
        Student[] out = new Student[size];
        String[] majors = Importer.getMajors();
        for (int i = 0; i < size; i++) {
            Name name = emitName();
            out[i] = new Student(name, (Math.random() * 4.0), majors[(int) (Math.random() * majors.length)]);
        }

        return out;
    }

    public static Instructor[] importInstructors(int size) {
        Instructor[] out = new Instructor[size];
        for (int i = 0; i < size; i++) {
            Name name = emitName();
            double salary = (Math.random() * 100_000) + 10_000;
            out[i] = new Instructor(name, Instructor.RANKS[(int) (Math.random() * Instructor.RANKS.length)], salary);
        }

        return out;
    }

    public static PersonBag importPeople(int numStudents, int numInstructors) {
        if (Storage.PEOPLE_FILE.exists()) {
            return Storage.restorePeople();
        }

        PersonBag personBag = new PersonBag(numStudents + numInstructors);
        personBag.insertAll(importStudents(numStudents));
        personBag.insertAll(importInstructors(numInstructors));

        return personBag;
    }
}
