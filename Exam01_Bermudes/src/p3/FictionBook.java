package p3;

public class FictionBook extends BookItem {
    private String year;

    public FictionBook(String title, Name author, double price, String year) {
        super(title, author, price + price * .10);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                "year='" + year + '\'' +
                "} " + super.toString();
    }
}
