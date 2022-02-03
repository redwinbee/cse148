package p3;

import java.util.Random;

public class Demo {
	private static Random random = new Random();
	
	public static void main(String[] args) {
		Cat cat1 = new Cat("Garfield");
		for (int i = 0; i < 5; i++) {
			cat1.feed(random.nextDouble(16.0) + 5.0);
		}
		
		System.out.println("cat1's name: " + cat1.getName());
		System.out.println("cat1's weight: " + cat1.getWeight());
	}
}
