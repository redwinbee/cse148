package p1_intro;

public class Demo {
    public static void main(String[] args) {
/*
        Name n1 = new Name();
        Student s1 = new Student(n1);
        Instructor i1 = new Instructor(n1);
        System.out.println(s1);
        System.out.println(i1);
*/

        /*
        since we specified that both the Student and Instructor classes inherit from
        the Person class with "... extends Person", then we must--in the constructor of both classes--
        call the super() method with the arguments for the Person class. which then gives us the IDs
        for each instance we create, guaranteeing a unique ID number.

        this also means that we have available to us all the methods in the Person class as well as
        the toString() method we overrode.
         */
        Name n1 = new Name("John", "Doe");
        Student s1 = new Student(n1);
        Name n2 = new Name("Jane", "Doe");
        Instructor i1 = new Instructor(n2);
        System.out.println(s1);
        System.out.println(i1);
        System.out.println("s1 (name): " + s1.getName());
        System.out.println("i1 (name): " + i1.getName());

        /*
        also, since Student extends Person, we can also specify when we create a new
        student that we want it to be specifically a Person. This is part of a concept
        known as: Polymorphism
            - the ability for an object to take on different shapes

        the consequences of polymorphism are that we can divorce the type of the ref. var
        from the object it is referencing.

        another consequence is that if we have an array of Person's (people) (Person[]), we can
        store Person classes OR any objects that have Person as its superclass
         */
        Student student = new Student(n1);
        Person[] people = new Person[1];
        people[0] = student; // student inside of person array at index 0
    }
}
