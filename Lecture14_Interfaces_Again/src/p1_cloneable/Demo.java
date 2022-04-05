package p1_cloneable;

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student("A", 3.5);
        Student s2 = null;
        try {
            s2 = s1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // now we compare s1 and s2, and since we did a deep-copy, it will be false
        System.out.println("(s1 == s2): " + (s1 == s2));
    }
}
