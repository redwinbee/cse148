package p1.objects;

public class Course {
    private String number;
    private String title;
    private String description;
    private Instructor instructor;
    private Textbook textbook;
    private int numCredits;

    public Course(String number, String title, String description, Instructor instructor, Textbook textbook, int numCredits) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.textbook = textbook;
        this.numCredits = numCredits;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    @Override
    public String toString() {
        return String.format("course: %s, %s, %d", getNumber(), getTitle(), getNumCredits());
    }
}
