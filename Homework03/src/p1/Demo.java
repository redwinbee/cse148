package p1;

import p1.helpers.CourseHelper;
import p1.helpers.InstructorHelper;
import p1.helpers.NameHelper;
import p1.helpers.TextbookHelper;
import p1.objects.*;

public class Demo {
    private static final int MAX_STUDENTS = 50;
    private static final int COURSE_PER_STUDENT = 4;

    public static void main(String[] args) {
        Student[] students = createStudents();
        display(students);
    }

    private static Student[] createStudents() {
        Student[] students = new Student[Demo.MAX_STUDENTS];
        for (int i = 0; i < MAX_STUDENTS; i++) {
            Course[] courses = generateCourses();
            students[i] = new Student(NameHelper.generateName(5), "CS", courses, 4.0);
        }

        return students;
    }

    private static Course[] generateCourses() {
        Course[] courses = new Course[COURSE_PER_STUDENT];
        for (int i = 0; i < COURSE_PER_STUDENT; i++) {
            Instructor instructor = InstructorHelper.generateRandomInstructor(5);
            Textbook textbook = TextbookHelper.generateRandomTextbook(5);
            courses[i] = CourseHelper.generateCourse(5);
        }

        return courses;
    }

    private static void display(Student[] students) {
        for (int i = 0; i < MAX_STUDENTS; i++) {
            System.out.println(String.format("[%d] ", i) + students[i].toString());
            for (int j = 0; j < COURSE_PER_STUDENT; j++) {
                Course[] courses = students[i].getCourses();
                System.out.println(String.format("    [%d] ", j) + courses[j]);
            }
        }
    }
}
