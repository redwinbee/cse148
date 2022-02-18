package p2;

import p1.Course;
import p1.Name;
import p1.Student;

public class Demo {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        // create the objects
        Name name = new Name("John", "Doe");
        Course[] courses = new Course[2];
        courses[0] = new Course("MAT142", "Calculus II", 4);
        courses[1] = new Course("CSE148", "Object Oriented Programming", 4);
        Student s1 = new Student(name, courses);
        Student s2 = new Student(s1);

        // modify 's1' only
        s1.setName(new Name("Jane", "Doe"));
        Course[] newCourses = s1.getCourses();
        newCourses[0] = new Course("PHY101", "Physics I", 4);
        s1.setCourses(newCourses);

        display(s1);
        display(s2);
    }

    private static void display(Student student) {
        System.out.printf("[%s]%n", student.getName());
        for (Course course : student.getCourses()) {
            System.out.printf("\t * %s | %s | %d\n", course.getCourseNumber(), course.getCourseTitle(),
                    course.getCredits());
        }
    }
}
