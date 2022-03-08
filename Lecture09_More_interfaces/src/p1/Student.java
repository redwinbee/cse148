package p1;

public class Student {
    private String name;
    private final Playable playable;
    private final Gradable gradable;

    public Student(String name, Playable playable, Gradable gradable) {
        this.name = name;
        this.playable = playable;
        this.gradable = gradable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playSports() {
        playable.play();
    }

    public void readBooks() {
        playable.read();
    }

    public void getGrade() {
        gradable.grade();
    }
}
