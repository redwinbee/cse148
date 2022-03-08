package p3;

import java.util.Arrays;

public class Demo {
    private static final int BOOK_COUNT = 10;

    public static void main(String[] args) {
        BookBag bookBag = new BookBag(BOOK_COUNT);
        Book b1 = new Book("A", 9.99);
        Book b2 = new Book("B", 10.99);
        Book b3 = new Book("C", 11.99);
        Book b4 = new Book("D", 12.99);
        bookBag.insert(b1);
        bookBag.insert(b2);
        bookBag.insert(b3);
        bookBag.insert(b4);

        /*
        we no longer need to specify what search does in the BookBag class like we have
        been doing before, now we can just have 1 simple method called search() which can be
        implemented in any way we want at the time we actually do the search.

        this is a very functional way of programming in java
         */
        Book[] booksNamedC = bookBag.search((Book b) -> b.getTitle().equals("C"));
        System.out.println(Arrays.toString(booksNamedC));

        Book[] booksCosting17 = bookBag.search((Book b) -> b.getPrice() <= 17.00);
        System.out.println(Arrays.toString(booksCosting17));
    }
}
