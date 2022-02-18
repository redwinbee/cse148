package p3;

import p1.Course;

public class Demo {
    private static final int NUM_COURSES = 10;

    public static void main(String[] args) {
        CourseBag courseBag1 = CourseHelper.randCourseBag(NUM_COURSES);
        testSearchByCourseNumber(courseBag1);

        CourseBag courseBag2 = CourseHelper.randCourseBag(NUM_COURSES);
        testSearchByCredits(courseBag2);
    }

    private static void testSearchByCourseNumber(CourseBag courseBag) {
        System.out.println("== BEFORE COURSE BAG ==");
        courseBag.display();
        System.out.println();

        // test the searchBy(courseNumber) method
        Course c1 = search(courseBag);
        System.out.println("* matched (unmodified): " + c1);
        if (c1 != null) {
            courseBag.removeBy(c1.getCourseNumber());
            System.out.println("* matched (removed): " + c1);
            c1.setCourseNumber("UNK001");
            c1.setCourseTitle("Unknown Course");
            c1.setCredits(1);
        }
        System.out.println("* matched (modified): " + c1);
        System.out.println();
        System.out.println("== AFTER COURSE BAG :: searchBy(courseNumber) ==");
        courseBag.display();
        System.out.println();
    }

    private static void testSearchByCredits(CourseBag courseBag) {
        System.out.println("== BEFORE COURSE BAG ==");
        courseBag.display();
        System.out.println();

        // test the searchBy(credits) method
        Course[] matches = courseBag.searchBy(4);
        for (Course course : matches) {
            System.out.println("* matched (unmodified): " + course);
            course.setCourseNumber(CourseHelper.randCourseNumber());
            course.setCourseTitle(CourseHelper.randCourseTitle());
            course.setCredits(CourseHelper.randCourseCredit());
            System.out.println("\t* matched (modified): " + course);
        }
        Course[] removedMatches = courseBag.removeBy(3);
        for (Course course : removedMatches) {
            System.out.println("* matched (removed): " + course);
        }

        System.out.println();
        System.out.println("== AFTER COURSE BAG :: searchBy(credits) ==");
        courseBag.display();
    }

    /**
     * due to the nature of randomness the search *might* take a non-trivial amount of time, I would
     * manually add the course myself but that would require resizing the backing array of CourseBag
     * when calling insert() and I don't feel like doing that right now.
     *
     * @param courseBag the course bag to check
     * @return hopefully, an actual course
     */
    private static Course search(CourseBag courseBag) {
        int searchNum = CourseHelper.MAX_COURSE_NUM;
        for (int i = 0; i < CourseHelper.MAJORS.length; i++) {
            for (int j = searchNum; j >= 0; j--) {
                String searchTerm = String.format("%s%s", CourseHelper.MAJORS[i], j);
                Course c1 = courseBag.searchBy(searchTerm);
                if (c1 != null) {
                    return c1;
                }
            }
        }

        // assuming I did this right we should never reach this line
        return null;
    }
}
