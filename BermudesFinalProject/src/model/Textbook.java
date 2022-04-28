package model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Represents a textbook which has a title, ISBN, author, and a price associated to it.
 */
public class Textbook implements Serializable {
    private String title;
    private String isbn;
    private Name author;
    private double price;

    /**
     * Creates a new textbook with the given title, ISBN, author, and price.
     *
     * @param title  The title to give book.
     * @param isbn   The ISBN to give the book.
     * @param author The author to give the book.
     * @param price  The price to give the book.
     */
    public Textbook(String title, String isbn, Name author, double price) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }

    /**
     * Gets the title of this book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this book.
     *
     * @param title The new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the ISBN of this book.
     *
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of this book.
     * \
     *
     * @param isbn The new ISBN.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the author of this book.
     *
     * @return The author of the book.
     */
    public Name getAuthor() {
        return author;
    }

    /**
     * Sets the author of this book.
     *
     * @param author The new author.
     */
    public void setAuthor(Name author) {
        this.author = author;
    }

    /**
     * Gets the price of this book.
     *
     * @return The price of the book.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this book.
     *
     * @param price The new price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of this textbook containing the title, ISBN, author, and price.
     *
     * @return This textbook in string format.
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Textbook.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("isbn='" + isbn + "'")
                .add("author=" + author)
                .add("price=" + price)
                .toString();
    }
}
