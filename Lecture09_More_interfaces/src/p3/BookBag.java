package p3;

import java.util.Arrays;
import java.util.function.Predicate;

public class BookBag {
    private Book[] books;
    private int elements;

    public BookBag(int size) {
        this.books = new Book[size];
    }

    public void insert(Book book) {
        books[elements++] = book;
    }

    public Book[] search(Predicate<Book> predicate) {
        Book[] out = new Book[elements];
        int matches = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(books[i])) {
                out[matches++] = books[i];
            }
        }

        return Arrays.copyOf(out, matches);
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, books[i]);
        }
    }
}
