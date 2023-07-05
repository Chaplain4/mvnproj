package abs;

public class TVSet implements Playable, Test {
    @Override
    public void play() {
        System.out.println("TV is on");
    }

    @Override
    public void stop() {
        System.out.println("TV is off");
    }

    @Override
    public void test() {
        System.out.println("Test is on");
    }
}
