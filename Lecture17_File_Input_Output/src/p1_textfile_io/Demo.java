package p1_textfile_io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        try {
            /*
            FileWriter optionally will rewrite the file (append) with the same information
            if we keep rerunning the program. PrintWriter will not rewrite the file, it will
            instead delete the contents and write the contents again.
             */
            FileWriter fw = new FileWriter("text_files/data_fw.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.printf("%10S%10.2f%n", "Adam", 3.65666);
            pw.printf("%10S%10.2f%n", "Bill", 3.2344);
            pw.printf("%10S%10.2f%n", "Cathy", 3.9133);

            // will write 'A' to the text file because 65 -> binary -> character (as interpreted by OS)
            char[] arr = {66, 67, 68};
            pw.write(65);
            pw.write(arr);
            // will print '65' as we would expect, it's very literal
            pw.print(65);

            pw.close();
        } catch (IOException ex) {
            System.err.println("[ex]: failed to access file!");
            ex.printStackTrace();
        }

        File file = new File("text_files/data_f.txt");
        try {
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                String next = scanner.nextLine();
                if (next.contains(" ")) {
                    String[] strings = next.split(" ");
                    System.out.printf("line%d: %s%n", lineCount++, Arrays.toString(strings));
                } else {
                    System.out.printf("line%d: %s%n", lineCount++, scanner.nextLine());
                }
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.err.println("[ex]: failed to access/open file!");
            ex.printStackTrace();
        }

    }
}
