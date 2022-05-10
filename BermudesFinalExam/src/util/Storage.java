package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Student;
import model.StudentBag;

public class Storage {
	static final File BACKUP_FILE = new File("backup.dat");
	
    public static void backup(StudentBag studentBag) {
        System.out.printf("[storage]: backing up %d students...%n", studentBag.getElementCount());
        try {
            FileOutputStream fos = new FileOutputStream(BACKUP_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(studentBag.getElementCount());
            oos.writeObject(studentBag);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("resource")
    public static StudentBag restore() {
        try {
            FileInputStream fis = new FileInputStream(BACKUP_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            int elementCount = ois.readInt();
            StudentBag personBag = (StudentBag) ois.readObject();
            personBag.setElementCount(elementCount);
            Student.setIdCount(elementCount);

            System.out.printf("[storage]: restoring %d people...%n", elementCount);
            return personBag;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
