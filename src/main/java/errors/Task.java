package errors;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Exception!");
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
