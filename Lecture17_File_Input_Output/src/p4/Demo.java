package p4;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Optional;

public class Demo {
    private static final int NUM_PEOPLE = (int) (Math.random() * 10_000);
    private static final String FILE_PATH = "/Users/redwinbee/Desktop/students.dat";

    public static void main(String[] args) {
        ArrayList<Person> toBeSerializedPeople = generatePeople(NUM_PEOPLE);
        System.out.printf("[inf]: serializing %d object(s)...%n", toBeSerializedPeople.size());
        Optional<File> serializedPeople = serialize(toBeSerializedPeople);
        serializedPeople.ifPresentOrElse(file -> System.out.printf("[inf]: file size: %s%n", humanReadableByteCountBin(file.length())), () -> {
            System.err.println("[err]: an error occurred while getting size data");
            System.err.println("[err]: perhaps the file does not exist?");
        });

        ArrayList<Person> deserialized = deserialize(new File(FILE_PATH));
        System.out.printf("[inf]: de-serialized %d object(s)%n", deserialized.size());
    }


    /**
     * serializes an array of People objects to a file and returns said file
     *
     * @param people the array of people to serialize
     * @return the serialized file. note that this file may optionally exist as errors
     * during serialization might have occurred.
     */
    private static @NotNull Optional<File> serialize(@NotNull ArrayList<Person> people) {
        File serialized;
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Person person : people) {
                oos.writeObject(person);
            }
            oos.close();
        } catch (IOException ex) {
            System.err.println("[ex]: failed to write object data!");
            ex.printStackTrace();
        } finally {
            serialized = new File(FILE_PATH);
        }

        return Optional.of(serialized);
    }

    /**
     * de-serializes a file of People objects back to an ArrayList
     *
     * @param file the file of serialized People objects
     * @return the de-serialized array of People objects
     */
    @Contract("_ -> new")
    @SuppressWarnings("InfiniteLoopStatement")
    private static ArrayList<Person> deserialize(@NotNull File file) {
        ArrayList<Person> people = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                people.add((Person) ois.readObject());
            }
        } catch (EOFException ignored) {
            // end of stream
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("[err]: failed to read object data!");
            ex.printStackTrace();
        }

        people.trimToSize();
        return people;
    }

    /**
     * generates a specific amount of Person objects
     *
     * @param size the number of Person objects to generate
     * @return the ArrayList of randomly generated Person objects
     */
    @Contract("_ -> new")
    private static @NotNull ArrayList<Person> generatePeople(int size) {
        ArrayList<Person> out = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Person person = generatePerson((int) (Math.random() * 30), (int) ((Math.random() * 110) + 10));
            out.add(person);
        }

        out.trimToSize();
        return out;
    }

    /**
     * generates a randomly generated person
     *
     * @param maxLength the max characters the name can have
     * @param maxAge    the max age the person can be
     * @return the generated person
     */
    @Contract("_,_ -> new")
    private static @NotNull Person generatePerson(int maxLength, int maxAge) {
        int firstLength = (int) (Math.random() * maxLength);
        int middleLength = (int) (Math.random() * maxLength);
        int lastLength = (int) (Math.random() * maxLength);
        return new Person(generateName(firstLength, middleLength, lastLength), (int) (Math.random() * maxAge));
    }

    /**
     * generates a randomly generated name
     *
     * @param firstLength  the length of the first name
     * @param middleLength the length of the middle name
     * @param lastLength   the length of the last name
     * @return the generated name
     */
    @Contract("_,_,_ -> new")
    private static @NotNull Name generateName(int firstLength, int middleLength, int lastLength) {
        return new Name(generateString(firstLength), generateString(middleLength), generateString(lastLength));
    }

    /**
     * return a randomly generated upper-case string
     *
     * @param charCount the number of characters the string should have
     * @return the generated string
     */
    @Contract("_ -> new")
    private static @NotNull String generateString(int charCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCount; i++) {
            char ch = (char) (Math.random() * 26 + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }

    /**
     * converts a given number of bytes to human-readable form as usually seen in
     * file explorers (ex: B, KiB, MiB, GiB...)
     * https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java/3758880#3758880
     *
     * @param bytes the number of bytes to convert
     * @return the string representation of ths number of bytes provided
     */
    public static String humanReadableByteCountBin(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " B";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %ciB", value / 1024.0, ci.current());
    }
}
