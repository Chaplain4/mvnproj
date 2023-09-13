package threads;

import static util.ThreadUtils.*;

import java.util.Date;

public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        currentThread.setName("MAIN");
        logBegin();
        currentThread.setPriority(10);

        System.out.println("Starting child ->");
        ChildThread ch = new ChildThread();
        ch.setName("Child");
        ch.start();  // execute run() method in parallel thread!

/*
        //start 15 extra Child threads
        for (int i = 0; i <15; i++) {
            ChildThread child = new ChildThread();
            child.setName("CHILD EXTRA THREAD #" + i);
            child.start();
        }
*/
        ChildThread2 ch2 = new ChildThread2();
        new Thread(ch2).start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            log(i);
        }

        //Lambda way
        new Thread(() -> {
            log("Lambda parallel thread");
        }).start();

        // using wrapper method
        runInNewThread(() -> log("Lambda parallel thread"));

        // using internal class
        new Thread(new Runnable() {
            @Override
            public void run() {
                log("internal class parallel Thread");
            }
        }).start();

        logFinish();
    }
}
