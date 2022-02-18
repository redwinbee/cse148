package p3;

import p1.Course;

import java.util.Arrays;

public class CourseBag {
    private final Course[] courses;
    private int elements;

    public CourseBag(int size) {
        this.courses = new Course[size];
    }

    public void insert(Course course) {
        courses[elements++] = new Course(course);
    }


    // assuming courseNumber is unique to each course
    public Course searchBy(String courseNumber) {
        for (Course course : courses) {
            if (course.getCourseNumber().equals(courseNumber)) {
                return new Course(course);
            }
        }

        return null;
    }

    public Course[] searchBy(int credits) {
        Course[] out = new Course[elements];
        int matches = 0;
        for (int i = 0; i < elements; i++) {
            if (courses[i].getCredits() == credits) {
                out[matches++] = new Course(courses[i]);
            }
        }

        return Arrays.copyOf(out, matches);
    }

    // assuming courseNumber is unique to each course
    public Course removeBy(String courseNumber) {
        int i;
        for (i = 0; i < elements; i++) {
            if (courses[i].getCourseNumber().equals(courseNumber)) {
                break;
            }
        }

        if (i == elements) {
            return null;
        } else {
            Course bak = new Course(courses[i]);
            for (int j = i; j < elements - 1; j++) {
                courses[j] = courses[j + 1];
            }

            elements--;
            return bak;
        }
    }

    public Course[] removeBy(int credits) {
        Course[] matches = new Course[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (courses[i].getCredits() == credits) {
                matches[count++] = courses[i];
                for (int j = i; j < elements - 1; j++) {
                    courses[j] = courses[j + 1];
                }

                elements--;
                i--;
            }
        }

        return Arrays.copyOf(matches, count);
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d] %s%n", i, courses[i]);
        }
    }
}
