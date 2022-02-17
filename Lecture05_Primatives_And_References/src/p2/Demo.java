package p2;

public class Demo {
    public static void main(String[] args) {
        Name name = new Name("John", "Doe");
        Student s1 = new Student(name, 3.0);
        s1.getName().setFirstName("Jane");
        System.out.println(s1);
        System.out.println(name);

        // create s2 from a deep-copy of everything in s1
        Student s2 = new Student(s1);
        s2.getName().setFirstName("Joe");
        s2.setGpa(4.0);
        System.out.println(s2);

        // compare two names
        Name n1 = new Name("John", "Doe");
        Name n2 = new Name("John", "Doe");
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));

        // compare the contents of both students
        System.out.println("==       returns: " + (s1 == s2));
        System.out.println("equals() returns: " + s1.equals(s2));

    }
}
