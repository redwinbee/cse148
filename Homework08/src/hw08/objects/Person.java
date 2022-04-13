package hw08.objects;


import java.util.StringJoiner;

public abstract class Person implements Cloneable, Comparable<Person> {
    private static int idCount;
    private Name name;
    private String id;

    public Person(Name name) {
        this.name = name;
        this.id = String.valueOf(idCount++);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

//    @Override
//    public Person clone() throws CloneNotSupportedException {
//        Person clone = (Person) super.clone();
//        clone.id = String.valueOf(idCount++);
//        return clone;
//    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().getLastName().compareTo(o.getName().getLastName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("id='" + id + "'")
                .toString();
    }
}
