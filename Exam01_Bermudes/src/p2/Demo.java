package p2;

public class Demo {
    public static void main(String[] args) {
        Name name1 = new Name("John", "Doe");
        Name name2 = new Name("Another","Name");
        BookItem childrensBook = new ChildrensBook("ChildrensBook1", name1, 6.25, 12);
        BookItem fictionBook = new FictionBook("FictionBook", name2, 6.25, "1997");

        System.out.println(childrensBook);
        System.out.println(fictionBook);
    }
}
