package p4;

import static p4.BookHelper.displayBooks;
import static p4.BookHelper.generateRandomTitle;

import java.util.Random;

public class Demo {
	private static final int BOOKS_TO_CREATE = 1000;
	private static Random random = new Random();

	public static void main(String[] args) {
		Book[] books = new Book[BOOKS_TO_CREATE];
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book(generateRandomTitle(random.nextInt(11) + 5), random.nextDouble(100.0));
		}

		displayBooks(books);
	}
}
