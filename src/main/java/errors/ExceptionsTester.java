package errors;

import model.Person;

import java.util.Scanner;

public class ExceptionsTester {
    public static void main(String[] args) {
        System.out.println("Begin");
        Person p1 = new Person();
        // p1.clone(); // throws new NullPointerException object
        Throwable throwable = new Throwable();
        Error error;
        Exception exception;
        try {
            //это потенциально небезопасный код. пытаемся словить исключение, которое ожидает в блоке catch
            p1.clone(); // will throw NullPointerException object!
        } catch (NullPointerException e) { //пытаемся словить именно NullPointerException
            // обработка исключения
            System.err.println("Oops! It's NullPointerException");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            //этот блок выполнится в любом случае - при ошибке или без неё
            System.out.println("Final job");
        }
        int[] array = {2, 12, 33};
        Scanner sc = new Scanner(System.in);
        System.out.println("input array index");
        int x = sc.nextInt();
        boolean aioubException = false;
        try {
            System.out.println(array[x]);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("array out of bounds");
            arrayIndexOutOfBoundsException.printStackTrace();
            aioubException = true;
            if (x > array.length - 1) {
                x = array.length - 1;
            } else {
                x = 0;
            }
        } finally {
            if (aioubException) {
                System.out.println(array[x]);
            }
        }
        System.out.println("input string");
        System.out.println();
        String str = "Hello java world";
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            try {
                System.out.println(words[i].charAt(words[i].indexOf('o')));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("No 'o' in word : " + words[i] + " , word number : " + i);
            }
        }


        System.out.println("End");
    }
}
