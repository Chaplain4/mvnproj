package threads;

import static util.ThreadUtils.*;

public class ExtraTester {
    public static void main(String[] args) throws InterruptedException {
        logBegin();
//        ExtraThread extraThread = new ExtraThread("Generator", 10);
//        DaemonThread daemonThread = new DaemonThread("Daemon");
//        sleep(5);
//        extraThread.disable();
        TaskThread taskThread = new TaskThread("Кипячение");
        new TaskThread(taskThread,"нарезка овощей");

        logFinish();
    }
}
