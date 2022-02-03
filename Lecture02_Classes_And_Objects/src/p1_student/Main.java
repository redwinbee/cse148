package p1_student;

import p2_car.Car;

public class Main {
	public static void main(String[] args) {
		Student johnDoe = new Student("John Doe", 25, 3.9);
		Student janeDoe = new Student("Jane Doe", 21, 3.8);
		System.out.println(johnDoe);
		System.out.println(janeDoe);
		
		Car c1 = new Car("Honda", 2022, "Blue", false, 30_500.55);
		Car c2 = new Car("Tesla", 2021, "White", true, 50_000.25);
		Car c3 = new Car();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
