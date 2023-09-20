package threads.sync;

import util.ThreadUtils;

public class WaitNotifyTester {
    public static void main(String[] args) {
        Store store = new Store();
        Thread t1 = new Thread(new Consumer(store));
        Thread t2 = new Thread(new Producer(store));
        t1.setName("Consumer");
        t2.setName("Producer");
    }
}

class Store {
    private int product = 0;

    public synchronized void get() {
        while (product == 0) {
            try {
                ThreadUtils.log("Start waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        ThreadUtils.sleep(0.2);
        product--;
        ThreadUtils.log("Consumer product + 1");
        ThreadUtils.log("Total products : " + product);
        ThreadUtils.log("Notify -> ");
        notifyAll();
    }

    public synchronized void put() {
        while (product > 0) {
            try {
                ThreadUtils.log("Start waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        product++;
        ThreadUtils.log("Producer product + 1");
        ThreadUtils.log("Total Store products : " + product);
        notifyAll();
    }
}


class Producer extends Thread {
    private final Store store;
    Producer (Store store) {
        this.store = store;
        this.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.put();
        }
    }
}

class Consumer extends Thread {
    private final Store store;
    Consumer (Store store) {
        this.store = store;
        this.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.get();
        }
    }
}