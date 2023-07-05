package abs;

public class DVDPlayer extends Player implements Playable {

    @Override
    public void play() {
        System.out.println("Start playing DVD Disc...");
    }

    @Override
    public void stop() {
        System.out.println("Stop playing DVD Disc...");
    }
}
