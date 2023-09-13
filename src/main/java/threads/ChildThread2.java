package threads;

import static util.ThreadUtils.*;

public class ChildThread2 implements Runnable {

    @Override
    public void run() {
        logBegin();
        sleep();
        logFinish();
    }
}