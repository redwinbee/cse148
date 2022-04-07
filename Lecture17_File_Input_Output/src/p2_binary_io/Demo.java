package p2_binary_io;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            // will write the integer 1 to the file (in binary) = 0..[32 0's]1
            dos.writeInt(1);
            // will write the string "hi" encoded as modified UTF
            // "hi" is 'h' and 'i', and since UTF stores things in 8 bytes, we have to
            // pad the value with 0's to encode it correctly
            dos.writeUTF("hi");
            dos.close();

            // ============================================================================

            FileInputStream fis = new FileInputStream("data.dat");
            DataInputStream dis = new DataInputStream(fis);
            // we read the data in the same way we wrote it
            int integer = dis.readInt();
            String string = dis.readUTF();
            System.out.println("read: " + integer + string);
            dis.close();
        } catch (FileNotFoundException ex) {
            System.err.println("[ex]: failed to open stream!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("[ex]: failed to read/write data!");
            ex.printStackTrace();
        }
    }
}
