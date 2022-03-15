package p3;

import p1.Name;
import p2.Person;

public class Instructor extends Person {
    private String rank;


    public Instructor(Name name, String rank) {
        super(name);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "rank='" + rank + '\'' +
                "} " + super.toString();
    }
}
