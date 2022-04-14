package persistence;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static final String BACKUP_PATH = "data/results.dat";

    private Storage() {
    }

    public static void backup(ArrayList<String> list) {
        try {
            FileOutputStream fos = new FileOutputStream(BACKUP_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (String value : list) {
                oos.writeObject(value);
            }

            oos.close();
        } catch (IOException ex) {
            System.err.println("[ex]: failed to write object data!");
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> restore() {
        ArrayList<String> out = new ArrayList<>();
        try {
            File file = new File(BACKUP_PATH);
            if (!file.exists()) {
                boolean ignored = file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(BACKUP_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                out.add((String) ois.readObject());
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("[ex]: failed to read object data!");
            ex.printStackTrace();
        }

        return out;
    }
}
