package p1;

public class Demo {
    public static void main(String[] args) {
        Name name1 = new Name("John", "Doe");
        Name name2 = new Name("Another", "Name");
        BookItem bookItem1 = new BookItem("Some Title", name1, 12.25);
        BookItem bookItem2 = new BookItem(bookItem1);
        bookItem2.setTitle("Another Title");
        bookItem2.setAuthor(name2);
        bookItem2.setPrice(7.75);

        System.out.println("book1 title: " + bookItem1.getTitle());
        System.out.println("book1 author: " + bookItem1.getAuthor());
        System.out.println("book1 price: " + bookItem1.getPrice());
        System.out.println("book2 title: " + bookItem2.getTitle());
        System.out.println("book2 author: " + bookItem2.getAuthor());
        System.out.println("book2 price: " + bookItem2.getPrice());
    }
}
