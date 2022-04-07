package p4;

import java.io.Serializable;
import java.util.StringJoiner;

public class Person implements Serializable {
    private Name name;
    private int age;

    public Person(Name name, int age) {
        this.name = name;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("age=" + age)
                .toString();
    }
}
