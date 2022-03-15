package p1;

import java.util.ArrayList;

public class Demo {
    private static final int LIST_CAPACITY = 10_000;
    private static final int RANDOM_STRING_LENGTH = 100;

    public static void main(String[] args) {
        ArrayList<String> stringList1 = new ArrayList<>(LIST_CAPACITY);
        for (int i = 0; i < LIST_CAPACITY; i++) {
            stringList1.add(generateRandomString((int) (Math.random() * RANDOM_STRING_LENGTH)));
        }

        System.out.println("stringList1.size(): " + stringList1.size());

        ArrayList<String> stringList2 = new ArrayList<>(2);
        stringList2.add("Hello");
        stringList2.add("World");
        stringList1.addAll(stringList2);

        System.out.println("stringList1.size(): " + stringList1.size());

        // print out the contents of stringList1
        stringList1.forEach(System.out::println);

        // check if the list contains a given object
        System.out.println("stringList1.contains(\"Hello\"): " + stringList1.contains("Hello"));
    }

    /**
     * Generate a random string of upper-case letters with a given size.
     * @param length The length of the string.
     * @return The generated string.
     */
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            char ch = (char) ((int) (Math.random() * 26) + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }
}
