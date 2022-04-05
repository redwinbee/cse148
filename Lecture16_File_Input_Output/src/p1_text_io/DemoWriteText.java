package p1_text_io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DemoWriteText {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        try {
            PrintWriter pw = new PrintWriter("data_written.txt");
            pw.println("hi");
            pw.println("bye");
            pw.println("goodbye");
            for (int number : numbers) {
                pw.println(number);
            }

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
