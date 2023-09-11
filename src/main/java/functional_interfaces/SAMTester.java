package functional_interfaces;

import java.util.Date;
import java.util.function.Function;

// 'SAM - Single Abstract Method Interface'
public class SAMTester {

    static int counter = 0;
    int instanceCounter;

    public static void main(String[] args) {
        Operable op = new Executor();
        op.operation(55, 55);
        //Анонимный класс. Тело класса
        Operable op2 = new Operable() {
            @Override
            public void operation(int a, int b) {
                System.out.println(a - b);
            }
        };
        op2.operation(100, 80);
        // Lambda
        final int A_LOCAL = 50;
        Operable op13;
        op13 = (a, b) -> {
            System.out.println(A_LOCAL * b);
        };
        op13.operation(77, 88);

        Printable pr1 = (str, times) -> {
            while (times > 0) {
                System.out.println(str);
                times--;
            }
        };
        pr1.print("hello lambda", 3);
        Calculation c = () -> 1L;
        Calculation c2 = () -> 2L;
        Calculation c3 = () -> 2L;
        long value = c2.calc();
        System.out.println(value);
        test(c3);
        test(()->100L);

        Function<Double, Integer> function = (summ1) -> {
          return (Integer) (int) (3.25 * summ1);
        };
        System.out.println(function.apply(50000.0));
    }

    static void test(Calculation c) {
        System.out.println(c.calc()*2);
    }
}

@FunctionalInterface
interface Calculation {
    long calc();
}

class Executor implements Operable {

    @Override
    public void operation(int a, int b) {
        System.out.println(a + b);
    }

    @Override
    public void defaultOperation() {

    }
}

@FunctionalInterface
interface Printable {
    void print(String s, int times);
}

@FunctionalInterface
interface Operable {
    void operation(int a, int b);

    default void defaultOperation() {
        System.out.println(new Date());
    }

    static void Operation() {
        System.out.println("Inside static");
    }
}

