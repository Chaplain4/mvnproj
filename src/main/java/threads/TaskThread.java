package threads;

import lombok.SneakyThrows;
import util.ThreadUtils;

public class TaskThread extends Thread{
    //wait this thread
    private Thread joinTo;
    private String job;
    TaskThread(Thread joinTo, String job){
        this.joinTo = joinTo;
        this.job = job;
        this.start();
    }

    TaskThread(String job){
        this.job = job;
        this.start();
    }

    @SneakyThrows
    @Override
    public void run(){
        ThreadUtils.log("Log begin");
        if (joinTo != null && joinTo.isAlive() && !joinTo.isDaemon()) {
            joinTo.join();
            ThreadUtils.log("Start waiting for " + joinTo.getName());
        }
        ThreadUtils.log("Working with " + job);
        ThreadUtils.logFinish();
    }
}
