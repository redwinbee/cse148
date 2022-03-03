package p2;

public abstract class BookItem {
    private String title;
    private Name author;
    private double price;

    public BookItem(String title, Name author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public BookItem(BookItem item) {
        this.title = item.getTitle();
        this.author = item.getAuthor();
        this.price = item.getPrice();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Name getAuthor() {
        return author;
    }

    public void setAuthor(Name author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                '}';
    }
}
