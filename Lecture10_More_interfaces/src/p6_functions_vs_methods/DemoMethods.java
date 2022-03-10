package p6_functions_vs_methods;

public class DemoMethods {
    public static void main(String[] args) {
        Student s1 = new Student("Alex", 4.0);
        Student s2 = new Student("Jose", 4.0);
        System.out.println("s1: " + s1.getName());
        System.out.println("s2: " + s2.getName());
        System.out.println("compute(5 ,4): " + compute(5, 4));
    }

    /*
    in java, we still call this a method, but we can now call this a
    function because it's a self-contained method that will return the same result
    regardless of which object calls this method.
     */
    @SuppressWarnings("all")
    private static int compute(int i, int j) {
        return i + j;
    }
}
