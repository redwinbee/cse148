package p3_object_io;

import java.io.*;

;

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student("A", 3.0);
        Student s2;

        try {
            /*
            we write the Student object to a file on the disk, however in order to write
            the object we first have to signal to java that the object we are writing is intended
            to be serialized to disk. Thus, we have to add "implements Serializable" to the object implementation
             */
            FileOutputStream fos = new FileOutputStream("students.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            System.out.println("serialized student: " + s1);
            oos.close();
        } catch (IOException e) {
            System.err.println("[ex]: failed to write object data!");
            e.printStackTrace();
        }

        try {
            /*
            we know read the object back from the file (deserialize) and create a student object from
            that data. serialization and deserialization now provide us with object persistence
             */
            FileInputStream fis = new FileInputStream("students.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (Student) ois.readObject();
            System.out.println("deserialized student: " + s2);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ex]: failed to read object data!");
            e.printStackTrace();
        }
    }
}
