package p1_enums;

public class DemoEnum {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("John", Rank.Instructor, 10_000);
        Instructor instructor2 = new Instructor("Jane", Rank.Professor, 20_000);
        System.out.println(instructor1);
        System.out.println(instructor2);
    }
}
