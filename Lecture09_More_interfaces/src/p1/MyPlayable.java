package p1;

public class MyPlayable implements Playable {
    @Override
    public void play() {
        System.out.println("play basketball!");
    }

    @Override
    public void read() {
        System.out.println("read fiction!");
    }
}
