package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Importer {
    public static final String[] EMPTY_ARRAY = {};

    private static String[] majors;
    private static String[] firstNames;
    private static String[] lastNames;
    private static String[] textbookIsbns;
    private static String[] textbookTitles;

    static {
        run();
    }

    private static void run() {
        System.out.println("[importer]: running initial data load");
        majors = importMajors();
        firstNames = importFile(new File("import/names/first_names.txt"));
        lastNames = importFile(new File("import/names/last_names.txt"));
        textbookIsbns = importFile(new File("import/textbooks/textbook_isbns.txt"));
        textbookTitles = importFile(new File("import/textbooks/textbook_titles.txt"));
    }

    private static String[] importMajors() {
        File majorsFile = new File("import/majors/majors.txt");
        String[] out;
        try (BufferedReader reader = new BufferedReader(new FileReader(majorsFile))) {
            out = reader.readLine().split(",");
            return out;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return EMPTY_ARRAY;
    }

    // TODO: 4/21/22 Maybe avoid creating the temp ArrayList?
    private static String[] importFile(File file) {
        ArrayList<String> out = new ArrayList<>();
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String curr;
            while ((curr = reader.readLine()) != null) {
                out.add(curr);
                count++;
            }

            return out.toArray(new String[count]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return EMPTY_ARRAY;
    }

    protected static String[] getMajors() {
        return majors;
    }

    protected static String[] getFirstNames() {
        return firstNames;
    }

    protected static String[] getLastNames() {
        return lastNames;
    }

    protected static String[] getTextbookIsbns() {
        return textbookIsbns;
    }

    protected static String[] getTextbookTitles() {
        return textbookTitles;
    }
}
