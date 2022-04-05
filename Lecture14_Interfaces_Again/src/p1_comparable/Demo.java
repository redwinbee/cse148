package p1_comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("all")
public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student("A", 4.0);
        Student s2 = new Student("Z", 3.0);
        Student s3 = new Student("M", 1.0);

        Student[] studentsArray = {s1, s2, s3};
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);

        Arrays.sort(studentsArray);
        Collections.sort(studentArrayList);
        System.out.println("sorted (Student[]): " + Arrays.toString(studentsArray));
        System.out.println("sorted (ArrayList<Student>): " + studentArrayList);

        Arrays.sort(studentsArray, (o1, o2) -> Double.compare(o1.getGpa(), o2.getGpa()));
        System.out.println("sorted (Comparator): " + Arrays.toString(studentsArray));

        System.out.println("comparing (s1 & s2)[name]: " + s1.compareTo(s2));
        System.out.println("comparing (s2 & s1)[name]: " + s2.compareTo(s1));
        System.out.println("comparing (s1 & s1)[name]: " + s1.compareTo(s1));


        /*
        what if we want to choose a different means of sorting an array? the method Arrays.sort() can
        optionally take in a functional interface Comparator<T> that can be implemented to let the
        method know how to sort the contents of the array.
         */
        Arrays.sort(studentsArray, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getGpa(), o2.getGpa());
            }
        });
        System.out.println("sorted (Student[]) (by GPA): " + Arrays.toString(studentsArray));

        /*
        the same functionality is available on Collections.sort() if you're working with something
        more complex instead of just an Array
         */
        Collections.sort(studentArrayList, (ss1, ss2) -> Double.compare(ss1.getGpa(), ss2.getGpa()));
        System.out.println("sorted (ArrayList<Student>) (by GPA): " + studentArrayList);

    }
}
