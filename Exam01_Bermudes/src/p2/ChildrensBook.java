package p2;

public class ChildrensBook extends BookItem {
    private int age;

    public ChildrensBook(String title, Name author, double price, int age) {
        super(title, author, price - Math.round(price * .10));
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildrensBook{" +
                "age=" + age +
                "} " + super.toString();
    }
}
