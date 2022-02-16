package p1.helpers;

import p1.objects.Instructor;

public class InstructorHelper {
    private static final String[] RANKS = {"A", "B", "C", "D", "E"};
    private static int officeNumCount = 0;

    public static Instructor generateRandomInstructor(int size) {
        return new Instructor(NameHelper.generateName(size), String.valueOf(officeNumCount++),
                generateRandomRank(), generateRandomSalary());
    }

    private static String generateRandomRank() {
        return RANKS[(int) (Math.random() * RANKS.length)];
    }

    private static double generateRandomSalary() {
        return Math.random() * 100_000.0;
    }
}
