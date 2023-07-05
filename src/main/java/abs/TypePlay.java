package abs;

public class TypePlay extends Player implements Playable {
    @Override
    public void play() {
        System.out.println("Start playing type record...");
    }

    @Override
    public void stop() {
        System.out.println("Stop playing type record...");
    }
}
