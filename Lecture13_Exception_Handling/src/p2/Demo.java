package p2;

public class Demo {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("John Doe", 4.5);
            System.out.println(s1);
        } catch (IllegalArgumentException ex) {
            System.out.printf("[ex]: %s%n", ex.getMessage());
        }
    }
}
