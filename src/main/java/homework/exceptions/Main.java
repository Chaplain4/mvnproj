package homework.exceptions;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int a = 4;
        try {
            System.out.println(a / 0);
        } catch (ArithmeticException e) {
            System.out.println("Произошла недопустимая арифметическая операция, Вы ввели: " + a + " / 0");
        }
    }
}

//с двумя конструкторами – один по умолчанию, второй принимает сообщение
// исключения и передает его в конструктор класса Exception.
class WrongLoginException extends Exception {
    private String login;

    public WrongLoginException(String login) {
        this.login = login;
    }

    public WrongLoginException() {
        super("Wrong Login Exception");
    }

    public String getLogin() {
        return login;
    }

}

class WrongPasswordException extends Exception {
    private String password;

    public WrongPasswordException(String password) {
        this.password = password;
    }

    public WrongPasswordException() {
        super("Wrong Password Exception");
    }

    public String getPassword() {
        return password;
    }
}


class Main2 {
    public static boolean task3(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean inputCorrect = true;

        try {
            //Login должен содержать только латинские буквы, цифры и знак подчеркивания.
            // Длина login должна быть меньше 20 символов.
            // Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
            if (!(login.matches("\\w{1,19}"))) {
                inputCorrect = false;
                throw new WrongLoginException(login);
            }
            //Password должен содержать только латинские буквы, цифры и знак подчеркивания.
            // Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
            // Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
            if (!(password.matches("\\w{1,19}") && (password.equals(confirmPassword)))) {
                inputCorrect = false;
                throw new WrongPasswordException(password);
            }
        } catch (WrongLoginException e) {
            System.out.println("Login должен содержать только латинские буквы, цифры и знак подчеркивания. Длина login должна быть меньше 20 символов");
            e.printStackTrace();
        } catch (WrongPasswordException e1) {
            System.out.println("Password должен содержать только латинские буквы, цифры и знак подчеркивания. " +
                    "Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.");
            e1.printStackTrace();
        } finally {
            return inputCorrect;
        }
    }

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        int[] m = {-1, 0, 1};
        Scanner sc = new Scanner(System.in);
        int a = 0;
        try {
            a = sc.nextInt();
            m[a] = 4 / a;
            System.out.println(m[a]);
        } catch (Exception e1) {
            if (e1 instanceof ArithmeticException) {
                System.out.println("Произошла недопустимая арифметическая операция, Вы ввели: 4 / " + a);
            } else if (e1 instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("Произошла недопустимая арифметическая операция, Вы ввели: " + a + " вместо 0 ... " + (m.length - 1));
            } else {
                System.out.println("Произошло какое-то исключение. Возможно, вы ввели неправильный тип данных?");
            }
        }
        System.out.println(task3("Admin", "123", "123"));
    }
}