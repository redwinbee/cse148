package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Importer {
	private static final String[] EMPTY_ARRAY = {};
	
	private static String[] lastNames;
	
	static {
		run();
	}
	
	private static void run() {
		lastNames = importFile(new File("last_names.txt"));
	}
	
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
    
    public static String[] getLastNames() {
    	return lastNames;
    }
}
