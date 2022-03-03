package p3;

public class Demo {
    private static final int BOOK_COUNT = 100;

    public static void main(String[] args) {
        BookBag bookBag = new BookBag(BOOK_COUNT);
        Name name1 = new Name("John", "Name");
        Name name2 = new Name("Another", "Name");
        Name name3 = new Name("Hank", "Doe");
        BookItem cb1 = new ChildrensBook("CB1", name1, 5.25, 12);
        BookItem fb1 = new FictionBook("FB1", name2, 6.25, "2001");
        BookItem cb2 = new ChildrensBook("CB2", name3, 7.75, 10);
        BookItem cb3 = new ChildrensBook("CB3", name1, 10.25, 9);
        BookItem fb2 = new FictionBook("FB2", name3, 3.45, "2002");
        BookItem fb3 = new FictionBook("FB3", name2, 11.45, "2004");

        bookBag.insert(cb1);
        bookBag.insert(fb1);
        bookBag.insert(cb2);
        bookBag.insert(cb3);
        bookBag.insert(fb2);
        bookBag.insert(fb3);

        System.out.println("=== DISPLAY (before) ===");
        bookBag.display();
        System.out.println();

        System.out.println("=== SEARCH BY LAST NAME ===");
        BookItem[] searchByLastNameResults = bookBag.searchByLastName("Doe");
        display(searchByLastNameResults);
        System.out.println();

        System.out.println("=== SEARCH BY AGE ===");
        BookItem[] searchByAgeResults = bookBag.searchByAge(10);
        display(searchByAgeResults);
        System.out.println();

        System.out.println("=== REMOVE BY YEAR ===");
        BookItem[] removeByYearResults = bookBag.removeByYear("2002");
        display(removeByYearResults);
        System.out.println();

        System.out.println("=== DISPLAY (after) ===");
        System.out.println("note: shallow-copy so the values should still be the same");
        bookBag.display();

    }

    private static void display(BookItem[] bookItems) {
        for (int i = 0; i < bookItems.length; i++) {
            System.out.printf("[%d]: %s%n", i, bookItems[i]);
        }
    }
}
