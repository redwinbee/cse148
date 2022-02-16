package p1.helpers;

import p1.objects.Course;

public class CourseHelper {
    private static final String[][] COURSES = { new String[] { "CSE118", "Fundamentals of Programming" },
            new String[] { "MAT141", "Calculus I" }, new String[] { "CSE148", "Object Oriented Programming" },
            new String[] { "MAT142", "Calculus II" }, new String[] { "PHY101", "Physics I" }};

    public static Course generateCourse(int nameLength) {
        String[] courseInfo = COURSES[(int)(Math.random() * COURSES.length)];
        return new Course(courseInfo[0], courseInfo[1], "", InstructorHelper.generateRandomInstructor(nameLength),
                TextbookHelper.generateRandomTextbook(nameLength),generateRandomCredits());
    }

    private static int generateRandomCredits() {
        return (int) (Math.random() * 4.0);
    }
}
