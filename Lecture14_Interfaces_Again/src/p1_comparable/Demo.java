package p1_comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    }
}
