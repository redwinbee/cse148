package p1;

import p1.helpers.CourseHelper;
import p1.helpers.NameHelper;
import p1.objects.*;

public class Demo {
    private static final int MAX_STUDENTS = 50;
    private static final int MAX_COURSES_PER_STUDENT = 4;

    public static void main(String[] args) {
        StudentBag students = createStudents();
        display(students);

        // test finding a student by id
        Student s1 = students.findBy(String.valueOf((int) (Math.random() * 49.0)));
        System.out.println("=== TEST 1 :: Find student by ID ===");
        System.out.printf("[%s] %s%n", s1.getId(), s1.toString());

        // test removing a student by id
        Student s2 = students.removeBy(String.valueOf((int) (Math.random() * 49.0)));
        System.out.println("=== TEST 2 :: Remove student by ID ===");
        System.out.printf("Post-removal of student with ID=%s%n", s2.getId());
        display(students);
    }

    private static StudentBag createStudents() {
        StudentBag students = new StudentBag(MAX_STUDENTS);
        for (int i = 0; i < MAX_STUDENTS; i++) {
            Course[] courses = CourseHelper.generateCourses((int) (1 + Math.random() * MAX_COURSES_PER_STUDENT), 5);
            students.add(new Student(NameHelper.generateName(5), "CS", courses, Math.random() * 4.0));
        }

        return students;
    }

    private static void display(StudentBag students) {
        Student[] allStudents = students.all();
        for (int i = 0; i < allStudents.length; i++) {
            Student student = allStudents[i];
            System.out.printf("[%d] %s%n", i, student.toString());

            Course[] courses = student.getCourses();
            for (int j = 0; j < courses.length; j++) {
                Course course = courses[j];
                System.out.printf("\t[%d] %s%n", j, course.toString());
                System.out.printf("\t\t * instructor: %s%n", course.getInstructor().getName());
                System.out.printf("\t\t * textbook: %s%n", course.getTextbook().getTitle());
                System.out.printf("\t\t * credits: %d%n", course.getNumCredits());
            }
        }
    }
}
