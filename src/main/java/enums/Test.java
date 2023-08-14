package enums;
// import all static methods,classes or fields

import static enums.Constants.*;

// import specific method, class or field
import static java.lang.Math.PI;
import static java.lang.Math.random;
import static java.lang.Math.cos;

public class Test {
    public static void main(String[] args) {
        double x = PI + 2;
        Math.random();
        random();
        cos(1.5);
        System.out.println(ONE);
        Problem p1 = new Problem();
        p1.setDescription("Wrong password");
        p1.setSeverity(Severity.MINOR);
        p1.resolve();
    }

    static int rand(int bound) {
        int x = (int) (Math.random() * bound);
        return x;
    }
}
