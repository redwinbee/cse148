package util;

import model.PersonBag;
import model.PersonBagSingleton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Backup {
    public static void backupPersonBag(PersonBag personBag) {
        try {
            FileOutputStream fos = new FileOutputStream("data/personBag.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personBag);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void backupPersonBagSingleton() {
        PersonBagSingleton personBag = PersonBagSingleton.getInstance(1_000);
        try {
            FileOutputStream fos = new FileOutputStream("data/personBag.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personBag);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
