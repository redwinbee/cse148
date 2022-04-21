package sandbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoBufferedReader {
    public static void main(String[] args) {
        // more efficient than reading using a Scanner
        try {
            FileReader fr = new FileReader("data/textbook_isbns.txt");
            BufferedReader br = new BufferedReader(fr);

            String curr;
            int count = 0;
            while ((curr = br.readLine()) != null) {
                System.out.printf("[%d]: %s%n", count++, curr);
            }

            System.out.println("Total ISBN count: " + count);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
