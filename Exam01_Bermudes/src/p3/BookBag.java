package p3;

import java.util.Arrays;

public class BookBag {
    private final BookItem[] books;
    private int elements;

    public BookBag(int size) {
        this.books = new BookItem[size];
    }

    public void insert(BookItem bookItem) {
        books[elements++] = bookItem;
    }

    public BookItem[] searchByLastName(String lastName) {
        BookItem[] out = new BookItem[elements];
        int matches = 0;
        for (int i = 0; i < elements; i++) {
            if (books[i].getAuthor().getLastName().equals(lastName)) {
                out[matches++] = books[i];
            }
        }

        return Arrays.copyOf(out, matches);
    }

    public BookItem[] searchByAge(int age) {
        BookItem[] out = new BookItem[elements];
        int matches = 0;
        for (int i = 0; i < elements; i++) {
            if (books[i] instanceof ChildrensBook childrensBook) {
                if (childrensBook.getAge() > age) {
                    out[matches++] = childrensBook;
                }
            }
        }

        return Arrays.copyOf(out, matches);
    }

    public BookItem[] removeByYear(String year) {
        BookItem[] out = new BookItem[elements];
        int matches = 0;
        for (int i = 0; i < elements; i++) {
            if (books[i] instanceof FictionBook fictionBook) {
                if (Integer.parseInt(fictionBook.getYear()) > Integer.parseInt(year)) {
                    out[matches++] = books[i];
                    for (int j = i; j < elements -1; j++) {
                        books[j] = books[j + 1];
                    }

                    elements--;
                    i--;
                }
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
