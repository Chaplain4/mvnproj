package util;


public class MathUtil {
    public static void varTester(double val) {
        double d;
        d = val;
        System.out.println(d);
        d = d + d;
        System.out.println(d);
    }

    public static void forTester(int num, double val, boolean flag) {
        System.out.println("for Tester begin");

        for (int i = 0; i < num; i++) {
            if (flag) {
                System.out.print("VALUE is " + (val += val));
            } else {
                System.out.println("VALUE is " + (val += val));
            }
        }
        System.out.println("for Tester end");
    }

    /**
     * Returns an integer value with a positive sign,
     * greater than or equal to 0.0 and less than 1.0.
     *
     * @param maxBound
     * @return a pseudorandom integer from 0 to maxBound inclusive
     */
    public static int genRandom(int maxBound) {
        return genRandom(0, maxBound);
    }

    public static int genRandom(int minBound, int maxBound) {
        //TODO :
        int v = maxBound - minBound + 1;
        int x = (int) (Math.random() * v) + minBound;
        return x < 0 ? x * (-1) : x;
    }

    public static int genRandom() {
        return genRandom(10);
    }

    public static void diamonds() {
        //int[] ar
    }
// на входе два массива (отсутствующих и присутствующих)


    public static void main(String[] args) {
//        System.out.println("Main starter.");
////        varTester(5.55);
////        forTester(5, 10, false);
////        int val = genRandom(1);
////        System.out.println(val);
////        int val2 = genRandom(100, 101);
////        System.out.println(val2);
//        int x = genRandom();
//        System.out.println(x);
        int[] result = ArraysUtil.genRandomArray(20);
        ArraysUtil.printArray(result, true);
        int max = ArraysUtil.findMax(result);
        System.out.println("MAX = " + max);
    }
}