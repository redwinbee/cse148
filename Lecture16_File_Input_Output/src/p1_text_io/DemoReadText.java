package p1_text_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoReadText {
    public static void main(String[] args) {
        File file = new File("data.txt");
        try {
            Scanner fileScanner = new Scanner(file);

            int lineCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");
                System.out.printf("line%d: %s%n", lineCount++, Arrays.toString(words));
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("no such line to read!");
        }

        System.out.println("done!");
    }
}
