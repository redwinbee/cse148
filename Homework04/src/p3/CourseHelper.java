package p3;

import p1.Course;

public class CourseHelper {
    public static final String[] MAJORS = {"CSE", "CST", "MAT", "ENG", "PHY", "CHE", "BIO", "HIS"};
    public static int MAX_COURSE_NUM = 299;

    public static CourseBag randCourseBag(int size) {
        CourseBag courseBag = new CourseBag(size);
        for (int i = 0; i < size; i++) {
            Course course = new Course(randCourseNumber(), randCourseTitle(), randCourseCredit());
            courseBag.insert(course);
        }

        return courseBag;
    }

    public static String randCourseNumber() {
        return MAJORS[(int) (Math.random() * MAJORS.length)] + ((int) (Math.random() * MAX_COURSE_NUM));
    }

    public static String randCourseTitle() {
        StringBuilder sb = new StringBuilder();
        int maxChars = ((int) (Math.random() * 20.0)) + 20;
        for (int i = 0; i < maxChars; i++) {
            char ch = (char) ((Math.random() * 26.0) + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }

    public static int randCourseCredit() {
        return (int) (1 + Math.random() * 4.0);
    }
}
