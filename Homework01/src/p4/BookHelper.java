package p4;

import java.util.Random;

public class BookHelper {
	private static Random random = new Random();
	
	/**
	 * generates a random string of upper-case letters with
	 * the given size
	 * 
	 * @param letterCount number of characters in the string
	 * @return the randomly generated string
	 */
	static String generateRandomTitle(int letterCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= letterCount; i++) {
			char ch = (char) (random.nextInt(26) + 'A');
			sb.append(ch);
		}
		
		return sb.toString();
	}
	
	/**
	 * displays an array of books to the console in a
	 * nicely formatted manner
	 * 
	 * @param books books to display
	 */
	static void displayBooks(Book... books) {
		System.out.println("[Serial]     [Title]              [Price]");
		for (int i = 0; i < books.length; i++) {
			System.out.printf("%-11s%-24s$%-15.2f\n", i, books[i].getTitle(), books[i].getPrice());
		}
	}
}
