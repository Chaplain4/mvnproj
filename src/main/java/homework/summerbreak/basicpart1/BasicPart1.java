package homework.summerbreak.basicpart1;

import java.io.File;
import java.nio.charset.Charset;

public class BasicPart1 {
    public static void task1() {
        //Write a Java program to print 'Hello' on screen and your name on a separate line.
        //Expected Output :
        //Hello
        //Alexandra Abramov
        System.out.println("Beginning task 1");
        System.out.println("Hello");
        System.out.println("Arthur Auskern");
        System.out.println("Finishing task 1");
    }

    public static void task2(int num1, int num2) {
        //Write a Java program to print the sum of two numbers.
        //Test Data:
        //74 + 36
        //Expected Output :
        //110
        System.out.println("Beginning task 2");
        System.out.println(num1 + num2);
        System.out.println("Finishing task 2");
    }

    public static void task3(int num1, int num2) {
        //Write a Java program to divide two numbers and print them on the screen.
        //Test Data :
        //50/3
        //Expected Output :
        //16
        System.out.println("Beginning task 3");
        System.out.println(num1 / num2);
        System.out.println("Finishing task 3");
    }

    public static String task37(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt((input.length()-1) - i));
        }
        return result.toString();
    }

    public static void task40() {
        //Write a Java program to list the available character sets in charset objects.
        //Expected Output
        //
        //List of available character sets:
        //Big5
        //Big5-HKSCS
        System.out.println("Beginning task 40");
        System.out.println(Charset.availableCharsets().toString());
        System.out.println("Finishing task 40");
    }

    public static void task45(String pathname) {
        System.out.println("Beginning task 45");
        File file = new File(pathname);
        System.out.println(file.getPath() + " : " + file.length());
        System.out.println("Finishing task 45");
    }

    public static void main(String[] args) {
        task1();
        task2(74, 36);
        task3(50, 3);
        task40();
        task45("C:\\Users\\admin\\Documents\\Crystals.pdf");

    }
}
