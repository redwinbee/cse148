package util;

import model.PersonBag;
import model.PersonBagSingleton;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Restore {
    public static @Nullable PersonBag restorePersonBag() {
        PersonBag out = null;
        try {
            FileInputStream fis = new FileInputStream("data/personBag.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            out = (PersonBag) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static @Nullable PersonBagSingleton restorePersonBagSingleton() {
        PersonBagSingleton out = null;
        try {
            FileInputStream fis = new FileInputStream("data/personBag.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            out = (PersonBagSingleton) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return out;
    }
}
