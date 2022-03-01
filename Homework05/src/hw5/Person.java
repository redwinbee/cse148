package hw5;

public abstract class Person {
    private static int count;

    private final String id;
    private Name name;
    private String phone;

    public Person(Name name, String phone) {
        super();
        this.name = name;
        this.phone = phone;
        id = String.valueOf(count++);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", phone='" + phone + '\'' +
                '}';
    }
}
