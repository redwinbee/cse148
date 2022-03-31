package p3;

public class Demo {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("John Doe", 4.1);
            System.out.println(s1);
        } catch (IncorrectGPAException e) {
            System.out.printf("[ex]: %s%n", e.getMessage());
        }

    }
}
