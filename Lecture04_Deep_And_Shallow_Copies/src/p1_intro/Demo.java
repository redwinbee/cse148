package p1_intro;

public class Demo {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        /*
 reference type
        Student s1 = new Student("A", 20, 3.5);
        String name = "Joe";
 primitive type
        int n = 10;
        byte b = 1;
        short s = 4;
        long l = 1_000;
        double d = 3.5;
        float f = 2.1F;
        boolean isHot = true;
        char c = 'A';
*/
        /*
        using the equals() method compares the value stored inside the
        objects whereas the == operator only compares the objects themselves.
        so in this case:
            equals() = true
            ==       = false
         */
        String name1 = new String("Joe");
        String name2 = new String("Joe");
        System.out.println(name1.equals(name2));
        System.out.println(name1 == name2);

        /*
        java treats strings very differently from other reference types, so
        in the following example, if java can know that two string objects have the
        same value, it will point 'name4' back to 'name3' to avoid creating unnecessary
        objects.

        the only way around that is by explicitly writing:
            String name3 = new String("Jane");
            String name4 = new String("Jane");

         this feature is known as "String Interning"
         */
        String name3 = "Jane";
        String name4 = "Jane";
    }
}