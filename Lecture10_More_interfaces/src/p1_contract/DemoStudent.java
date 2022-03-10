package p1_contract;

public class DemoStudent {
    public static void main(String[] args) {
        Student s1 = new Student("John", 3.9);
        Student s2 = new Student("Alex", 3.0);
        System.out.println(s1.compareTo(s2) > 0);
        System.out.println(s2.compareTo(s1) > 0);
    }
}
