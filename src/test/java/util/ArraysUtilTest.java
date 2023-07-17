package util;

import org.junit.*;

import java.util.concurrent.TimeoutException;

public class ArraysUtilTest {

    private int[] arr;

    @BeforeClass
    public static void init() {
        System.out.println("init job");
    }

    @Before
    public void beforeEach() {
        System.out.println("beforeEach job");
        arr = new int[5];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;
        arr[3] = -200;
        arr[4] = 3;
    }


    @AfterClass
    public static void destroy() {
        System.out.println("destroy / clean job");
    }

    @After
    public void afterEach() {
        System.out.println("afterEach job");
    }

    @Test
    public void initialFindMaxTest() {
        System.out.println("initialFindMaxTest start");
        int expected = 3;
        int actual = ArraysUtil.findMax(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayRemovalTest() {
        System.out.println("arrayRemovalTest start");
        arr[1] = 0;
        int expected = 0;
        int actual = arr[1];
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void findMaxFromNullTest() {
        System.out.println("findMaxFromNullTest start");
        arr = null;
        int expected = Integer.MIN_VALUE;
        int actual = ArraysUtil.findMax(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 5000)
    public void generateArrayPerformance() {
        System.out.println("generateArrayPerformance start");
        for (int i = 0; i < 5; i++) {
            ArraysUtil.printArray(ArraysUtil.genRandomArray(1000000));
        }
    }
}