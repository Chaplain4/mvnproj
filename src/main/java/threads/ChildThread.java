package threads;

import java.util.Date;

import static util.ThreadUtils.*;

public class ChildThread extends Thread{
    // OWN JOB in parallel thread
    @Override
    public void run() {
        logBegin();
        System.out.println("Child Job: ");
        for (int i = 0; i< 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log(i);
        }
        logFinish();
    }
}
