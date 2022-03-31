package p1;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age;
        do {
            try {
                System.out.print("enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid age! please try again");
            }
        } while (true);

        System.out.println("the age is: " + age);
        System.out.println("done!");
    }
}
