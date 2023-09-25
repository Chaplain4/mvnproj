package homework.threads;


import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.util.*;

import static util.ThreadUtils.*;

public class Threads {
    public static void task1() {
        //Запустить 3 дополнительных потока. (Разными способами)
        //У каждого своя задержка при выполнении (milliseconds):
        //Thread A - 100 , Thread B - 500, Thread C - 1000.
        //(Писать лог в консоль для каждого – запуск/выполнение/завершение)
        ThreadA threadA = new ThreadA();
        threadA.setName("Thread A");
        threadA.start();

        new Thread(() -> {
            logBegin();
            sleep(0.5);
            log(Thread.currentThread().getName() + " timeout complete (500 ms)");
            logFinish();
        }, "Thread B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logBegin();
                sleep(1);
                log(Thread.currentThread().getName() + " timeout complete (1000 ms)");
                logFinish();
            }
        }, "Thread C").start();
        System.out.println("=====================================");
    }

    public static void task2() {
        //Не меняя задержку поменяйте стек завершения в обратную сторону, если теперь каждый производный от главного
        // потока запускает по одному дочернему(дополнительному) и ожидает его выполнения.
        //У каждого своя задержка при выполнении (milliseconds):
        //Thread ChildA - 2000 , Thread ChildB - 1000, Thread ChildC - 100.
        //Используйте join()
        runInNewThread(() -> {
            logBegin();
            sleep(0.1);
            Thread childA = new Thread("Child A") {
                @SneakyThrows
                @Override
                public void run() {
                    logBegin();
                    sleep(2000);
                    logFinish();
                }
            };
            childA.start();
            try {
                childA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logFinish();
        }, "Thread A");


        new Thread(() -> {
            logBegin();
            sleep(0.5);
            Thread childB = new Thread("Child B") {
                @SneakyThrows
                @Override
                public void run() {
                    logBegin();
                    sleep(1000);
                    logFinish();
                }
            };
            childB.start();
            try {
                childB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logFinish();
        }, "Thread B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logBegin();
                sleep(1);
                Thread childC = new Thread("Child C") {
                    @SneakyThrows
                    @Override
                    public void run() {
                        logBegin();
                        sleep(100);
                        logFinish();
                    }
                };
                childC.start();
                try {
                    childC.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                logFinish();
            }
        }, "Thread C").start();
    }

    public static void task3() {
        //Уберите все задержки во всех потоках.
        //Реализуйте очередность добавления ресурсов. Используйте synchronized (2 способа).
        //Протестируйте что происходит если не использовать синхронизацию.
        Resource resource = new Resource();

        runInNewThread(() -> {
            logBegin();
            synchronized (resource) {
                resource.add();
            }
            Thread childA = new Thread("Child A") {
                @SneakyThrows
                @Override
                public void run() {
                    logBegin();
                    resource.syncAdd();
                    logFinish();
                }
            };
            childA.start();
            try {
                childA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logFinish();
        }, "Thread A");


        new Thread(() -> {
            logBegin();
            resource.syncAdd();
            Thread childB = new Thread("Child B") {
                @SneakyThrows
                @Override
                public void run() {
                    logBegin();
                    synchronized (resource) {
                        resource.add();
                    }
                    logFinish();
                }
            };
            childB.start();
            try {
                childB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logFinish();
        }, "Thread B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logBegin();
                resource.syncAdd();
                Thread childC = new Thread("Child C") {
                    @SneakyThrows
                    @Override
                    public void run() {
                        logBegin();
                        synchronized (resource) {
                            resource.add();
                        }
                        logFinish();
                    }
                };
                childC.start();
                try {
                    childC.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                logFinish();
            }
        }, "Thread C").start();
        resource.getThreadList().forEach(System.out::println);
    }

    @SneakyThrows
    public static void task4(String path) {
        //Используя методы чтения из пакета io, запустите 7 основных потоков которые читают ‘Война и Мир’, затем
        // переворачивая текст, записывают содержание в отдельный файл в папку results. У каждого потока своя копия
        // результирующего файла, формат имени которого <thread_name>_< yyyyMMddHHmmss>.txt
        Thread[] threads = new Thread[7];
        for (int i = 0; i < 7; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Thread.currentThread() != threads[0]) {
                        for (int j = 1; j < threads.length; j++) {
                            if (Thread.currentThread() == threads[j]) {
                                try {
                                    threads[j - 1].join();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                    Date date = new Date();
                    ArrayList<Character> arrayList = new ArrayList<>();
                    for (char c : util.IOUtils.readFileByLine(path).toCharArray()) {
                        arrayList.add(c);
                    }
                    Collections.reverse(arrayList);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i));
                    }
                    String str = sb.toString();
                    util.IOUtils.write(str, "src/main/java/homework/threads/" +
                            Thread.currentThread().getName() + "_" + date.getYear() + date.getMonth() + date.getDate() +
                            date.getHours() + date.getMinutes() + date.getSeconds() + ".txt");
                }
            },
                    "Thread " + (i + 1));
            threads[i].start();
        }
    }

    public static void task5() {
        //Дополните предыдущую задачу Daemon потоком. Задача Daemon потока исследовать папку на наличие результирующих
        // файлов. Как только в каталоге создан файл, например , writer_th#2_202309053359.txt, деман должен проверить
        // что файл не пустой и написать в консоль сколько потоков ещё работают. т.е. ‘6 потоков в работе’, ‘5 потоков в работе’ …
        DaemonThread1 daemonThread1 = new DaemonThread1();
        task4("src/main/java/homework/threads/WarAndPeace.txt");
    }

    public static void task6() {
        //Реализовать доступ к ArrayList<Integer> поочередно из двух потоков.
        //Первый поток добавляет в массив случайное число и оповещает второй поток. Второй поток читает добавленное
        // число и печатает в консоль чётное ли число или не чётное, после чего оповещает первый поток.
        //Количество чисел вводится с клавиатуры.
        //Варианты усложнения:
        //- существует третий поток который так же как и второй, ожидает вставки, после чего он печатает в консоль
        // среднее значение всех случайных чисел в листе.
        System.out.println("Input counter");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        NewArrayList newArrayList = new NewArrayList(num);
        Thread t1 = new Thread(new Adder(newArrayList));
        Thread t2 = new Thread(new Printer(newArrayList));
        Thread t3 = new Thread(new Calculator(newArrayList));
        newArrayList.setCounter(num = num - 1);
        while (!newArrayList.isComplete()) {
            t1.run();
            t2.run();
            t3.run();
            newArrayList.setCounter(num = num - 1);
            if (newArrayList.getCounter() == 0) {
                newArrayList.setComplete(true);
            }
        }
    }

    public static void task7(int clientNum) {
        //Задача состоит в том что бы накормить группу людей из 10 человек. Ввести следующие потоки – Клиент, Повар,
        // Официантка. Число клиентов по умолчанию 10. Каждого клиента нужно накормить обедом.
        //Клиенты делают заказы, повар начинает готовить блюдо только когда клиент сделал заказ. Официантка может
        // отнести клиенту блюдо только если блюдо готово. (Принимать заказы официантка может во время готовки)
        //Готовка блюда – 1 сек. Оформление заказа 0.2 сек. Поднос – 0.1 сек.
        //Работа потоков заканчивается, когда всех клиентов обслужили.
        //Варианты усложнения:
        //- количество клиентов задаётся параметром
        //- определённое блюдо готовится определённому клиенту
        //- добавьте ещё одного повара
        //- клиент может заказать до 3ёх блюд
        Restaurant restaurant = new Restaurant();
        for (int i = 0; i < clientNum; i++) {
            Client client = new Client(restaurant);
        }
        Waitress waitress = new Waitress(restaurant);
        Cook cook1 = new Cook(restaurant);
        Cook cook2 = new Cook(restaurant);
    }

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4("src/main/java/homework/threads/WarAndPeace.txt");
//        task5();
//        task6();
        task7(10);
    }
}

class ThreadA extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        logBegin();
        Thread.sleep(100);
        log(this.getName() + " timeout complete (100 ms)");
        logFinish();
    }
}

class Resource {
    //Создайте класс Resource. Метод add() должен добавить имя потока в список ресурсов.
    //При этом сам процесс добавления должен быть залогирован с остановкой в 100 ms.
    private ArrayList<String> threadList = new ArrayList<>();

    public ArrayList<String> getThreadList() {
        return threadList;
    }

    @SneakyThrows
    public void add() {
        getThreadList().add(Thread.currentThread().getName());
        log(Thread.currentThread().getName() + " added");
        Thread.sleep(100);
    }

    @SneakyThrows
    public synchronized void syncAdd() {
        getThreadList().add(Thread.currentThread().getName());
        log(Thread.currentThread().getName() + " added");
        Thread.sleep(100);
    }
}

class DaemonThread1 extends Thread {
    public DaemonThread1() {
        this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        File folder = new File("src/main/java/homework/threads");
        int files = folder.list().length;
        logBegin();
        for (; true; ) {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println((7 + files - folder.list().length) + " потоков в работе");
        }
    }
}

@Data
class NewArrayList {
    //Реализовать доступ к ArrayList<Integer> поочередно из двух потоков.
    //Первый поток добавляет в массив случайное число и оповещает второй поток. Второй поток читает добавленное
    // число и печатает в консоль чётное ли число или не чётное, после чего оповещает первый поток.
    //Количество чисел вводится с клавиатуры.
    //Варианты усложнения:
    //- существует третий поток который так же как и второй, ожидает вставки, после чего он печатает в консоль
    // среднее значение всех случайных чисел в листе.
    private List<Integer> integerList = new ArrayList<>();
    private int counter;
    private boolean isAdded = false;
    private boolean isCalculated = true;
    private boolean isPrinted = false;
    private boolean isComplete = false;

    public NewArrayList(int counter) {
        this.counter = counter;
    }

    @SneakyThrows
    public synchronized void add() {
        while (!isCalculated) {
            wait();
        }
        integerList.add((Integer) (int) (Math.random() * 10));
        setAdded(true);
        setCalculated(false);
        notify();
    }

    @SneakyThrows
    public synchronized void print() {
        while (!isAdded) {
            wait();
        }
        if (integerList.get(integerList.size() - 1) % 2 == 0) {
            System.out.println("Even number added");
        } else {
            System.out.println("Odd number added");
        }
        setPrinted(true);
        setAdded(false);
        notify();
    }

    @SneakyThrows
    public synchronized void calculate() {
        while (!isPrinted) {
            wait();
        }
        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }
        double avg = ((double) sum / integerList.size());
        System.out.println("Average = " + avg);
        setPrinted(false);
        setCalculated(true);
        notify();
    }
}

class Printer extends Thread {
    private final NewArrayList newArrayList;

    Printer(NewArrayList newArrayList) {
        this.newArrayList = newArrayList;
        this.start();
    }

    @Override
    public void run() {
        newArrayList.print();
    }
}

class Calculator extends Thread {
    private final NewArrayList newArrayList;

    Calculator(NewArrayList newArrayList) {
        this.newArrayList = newArrayList;
        this.start();
    }

    @Override
    public void run() {
        newArrayList.calculate();
    }
}

class Adder extends Thread {
    private final NewArrayList newArrayList;

    Adder(NewArrayList newArrayList) {
        this.newArrayList = newArrayList;
        this.start();
    }

    @Override
    public void run() {
        newArrayList.add();
    }
}

@Data
class Restaurant {
    //Задача состоит в том что бы накормить группу людей из 10 человек. Ввести следующие потоки – Клиент, Повар,
    // Официантка. Число клиентов по умолчанию 10. Каждого клиента нужно накормить обедом.
    //Клиенты делают заказы, повар начинает готовить блюдо только когда клиент сделал заказ. Официантка может
    //отнести клиенту блюдо только если блюдо готово. (Принимать заказы официантка может во время готовки)
    //Готовка блюда – 1 сек. Оформление заказа 0.2 сек. Поднос – 0.1 сек.
    //Работа потоков заканчивается, когда всех клиентов обслужили.
    //Варианты усложнения:
    //- количество клиентов задаётся параметром
    //- определённое блюдо готовится определённому клиенту
    //- добавьте ещё одного повара
    //- клиент может заказать до 3ёх блюд
    private ArrayList<String> clients = new ArrayList<>();
    private HashMap<String, ArrayList<String>> orders = new HashMap<>();
    private HashMap<String, Boolean> ordersPlaced = new HashMap<>();
    private HashMap<String, Boolean> ordersReady = new HashMap<>();
    private HashMap<String, Boolean> ordersDelivered = new HashMap<>();
    private boolean allOrdersPlaced = false;
    private boolean allOrdersReady = false;
    private boolean allOrdersDelivered = false;

    public synchronized String checkNotPlaced() {
        for (String s : clients) {
            if (!ordersPlaced.get(s)) {
                return s;
            }
        }
        return null;
    }

    public synchronized String checkNotReady() {
        for (String s : clients) {
            if (!ordersReady.get(s) && ordersPlaced.get(s)) {
                return s;
            }
        }
        return null;
    }

    public synchronized String checkNotDelivered() {
        for (String s : clients) {
            if (!ordersDelivered.get(s) && ordersReady.get(s)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<String> generateOrder() {
        ArrayList<String> order = new ArrayList<>();
        int n = (int) ((Math.random() * 3) + 1);
        String[] menu = {"Hamburger", "Fries", "Pizza", "Soup", "Cheesecake", "Fish&Chips", "Donuts", "Sushi", "Wok"};
        for (int i = 0; i < n; i++) {
            order.add(menu[(int) (Math.random() * menu.length)]);
        }
        return order;
    }

    public synchronized void placeOrder(Client client) {
        this.getClients().add(client.getName());
        this.getOrders().put(client.getName(), this.generateOrder());
        this.getOrdersPlaced().put(client.getName(), false);
        this.getOrdersReady().put(client.getName(), false);
        this.getOrdersDelivered().put(client.getName(), false);
        log(client.getName() + " enters the restaurant");
        notifyAll();
    }

    @SneakyThrows
    public synchronized void awaitOrder(Client client) {
        while (!this.getOrdersDelivered().get(client.getName())) {
            wait();
        }
        log(client.getName() + " leaves the restaurant");
    }

    @SneakyThrows
    public synchronized void takeOrder() {
        while (checkNotPlaced() == null) {
            wait();
        }
        while (checkNotPlaced() != null) {
            String nextClient = checkNotPlaced();
            Thread.sleep(200);
            this.getOrdersPlaced().put(nextClient, true);
            log("Order taken from " + nextClient);
            notifyAll();
        }
    }

    @SneakyThrows
    public synchronized void deliverOrder() {
        while (checkNotDelivered() == null) {
            wait();
        }
        while (checkNotDelivered() != null) {
            String nextClient = checkNotDelivered();
            Thread.sleep(100);
            this.getOrdersDelivered().put(nextClient, true);
            log("Order delivered to " + nextClient);
            notifyAll();
        }
    }

    @SneakyThrows
    public synchronized void readyOrder() {
        while (checkNotReady() == null) {
            wait();
        }
        while (checkNotReady() != null) {
            String nextClient = checkNotReady();
            for (int a = 0; a < getOrders().get(nextClient).size(); a++) {
                Thread.sleep(1000);
            }
            log("Order from " + nextClient + " is ready");
            this.getOrdersReady().put(nextClient, true);
            notifyAll();
        }
    }
}

@Data
class Client extends Thread {
    private final Restaurant restaurant;

    Client(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.start();
    }

    @Override
    public void run() {
        getRestaurant().placeOrder(this);
        getRestaurant().awaitOrder(this);
        log("Client " + this.getName() + " served with " + getRestaurant().getOrders().get(this.getName()).toString());
    }
}

@Data
class Waitress extends Thread {
    private final Restaurant restaurant;

    Waitress(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        sleep(20);
        getRestaurant().takeOrder();
        getRestaurant().deliverOrder();
    }
}

@Data
class Cook extends Thread {
    private final Restaurant restaurant;

    Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.start();
    }

    @Override
    public void run() {
        getRestaurant().readyOrder();
    }
}