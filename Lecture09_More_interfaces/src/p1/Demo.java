package p1;

public class Demo {
    public static void main(String[] args) {
        /*
        lambda expression:
            - only available to functional interfaces (interfaces with 1 method)
            - "(arg1, arg2, ..., argn) -> { method_body };
         */
        Student s1 = new Student("John", new MyPlayable(), () -> System.out.println("A!"));
        Student s2 = new Student("Jane", new Playable() {
            @Override
            public void play() {
                System.out.println("play hockey!");
            }

            @Override
            public void read() {
                System.out.println("ready non-fiction!");
            }
        }, () -> System.out.println("B!"));
        Student s3 = new Student("Hank", new Playable() {
            @Override
            public void play() {
                System.out.println("play soccer!");
            }

            @Override
            public void read() {
                System.out.println("ready sci-fi!");
            }
        }, () -> System.out.println("C!"));

        s1.playSports();
        s1.readBooks();
        s1.getGrade();
        s2.playSports();
        s2.readBooks();
        s2.getGrade();
        s3.playSports();
        s3.readBooks();
        s3.getGrade();
    }
}
