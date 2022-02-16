package p1;

import p1.objects.Student;

public class StudentBag {
    private final Student[] students;
    private int elms;

    public StudentBag(int size) {
        this.students = new Student[size];
    }

    public Student add(Student student) {
        this.students[elms++] = student;
        return student;
    }

    public Student[] all() {
        return students;
    }

    public Student findBy(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        // nothing found
        return null;
    }

    public Student removeBy(String id) {
        int i;
        for (i = 0; i < students.length; i++) {
            if (students[i].getId().equals(id)) {
                break;
            }
        }

        if (i == elms) {
            return null;
        } else {
            Student temp = students[i];
            for (int j = i; j < elms - 1; j++) {
                students[j] = students[j - 1];
            }

            elms--;
            return temp;
        }
    }

    public void display() {
        for (int i = 0; i < elms; i++) {
            System.out.printf("[%d] %s\n", i, students[i].toString());
        }
    }
}
