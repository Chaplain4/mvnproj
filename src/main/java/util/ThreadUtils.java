package util;

import java.util.Date;

public class ThreadUtils {
    public static void logBegin() {
        Thread th = Thread.currentThread();
        System.out.println(String.format("Started [%s]: [%d] %s (%d)", new Date().toString(), th.getId(), th.getName(), th.getPriority()));
    }

    public static void logFinish() {
        Thread th = Thread.currentThread();
        System.out.println(String.format("Finished [%s]: [%d] %s (%d)", new Date().toString(), th.getId(), th.getName(), th.getPriority()));
    }

    public static void log(Object text) {
        Thread th = Thread.currentThread();
        System.out.println(String.format("%s[%s]: [%d] %s (%d)", text, new Date().toString(), th.getId(), th.getName(), th.getPriority()));
    }

    public static void sleep(double seconds) {
        log("start sleeping");
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log("wake up");
    }

    public static void sleep() {
        sleep((int) (Math.random() * 3));
    }

    public static void runInNewThread(Runnable target) {
        new Thread(target).start();
    }
}
