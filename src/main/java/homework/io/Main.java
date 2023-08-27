package homework.io;

//Решить задачи используя байтовый, символьный и буферизированный потоки. (т.е. 3-мя способами)

import lombok.AllArgsConstructor;
import lombok.Data;
import util.IOUtils;

import java.io.*;
import java.util.*;

public class Main {
    /**
     * Т.к. задача выполняется тремя способами, будет записано 3 файла
     */
    public static void task1(String path, String text) {
        //1. Создать файл исп. класс File. Записать в файл текст.
        System.out.println("Beginning Task 1");
        // используя байтовый
        try (Writer writer = new BufferedWriter(new FileWriter(path));) {
            for (int c : text.toCharArray()) {
                writer.write(c);
            }
            File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //символьный
        try (Writer writer = new BufferedWriter(new FileWriter(path.replace("task1.txt", "task1-2.txt")))) {
            for (Character c : text.toCharArray()) {
                writer.write(c);
            }
            File file = new File(path.replace("task1.txt", "task1-2.txt"));
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //и буферизированный потоки
        try (Writer writer = new BufferedWriter(new FileWriter(path.replace("task1.txt", "task1-3.txt")))) {
            writer.write(text);
            File file = new File(path.replace("task1.txt", "task1-3.txt"));
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing Task 1");
    }

    public static void task2(String path) {
        //Прочитать файл. Вывести весь существующий текст в консоль в верхнем регистре. Если файл пустой, написать об этом в консоль.
        System.out.println("Beginning Task 2");
        try (InputStream is = new FileInputStream(path);
             Reader reader = new FileReader(path);
             Reader reader2 = new BufferedReader(new FileReader(path))) {
            // используя байтовый
            int code;
            StringBuilder str = new StringBuilder();
            while ((code = is.read()) != -1) {
                str.append((char) code);
            }
            if (str.toString().length() > 0) {
                System.out.println(str.toString().toUpperCase());
            } else System.out.println("File is empty");
            //символьный
            str = new StringBuilder();
            while ((code = reader.read()) != -1) {
                str.append((char) code);
            }
            if (str.toString().length() > 0) {
                System.out.println(str.toString().toUpperCase());
            } else System.out.println("File is empty");
            //и буферизированный потоки
            str = new StringBuilder();
            while ((code = reader2.read()) != -1) {
                str.append((char) code);
            }
            if (str.toString().length() > 0) {
                System.out.println(str.toString().toUpperCase());
            } else System.out.println("File is empty");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing Task 2");
    }

    /**
     * Т.к. задача выполняется тремя способами, файл будет дополнен введенной информацией num x 3 раз
     */
    public static void task3(String path, String textForUpdate, int num) {
        //Создать метод который ДОПОЛНИТ существующий файл введенной информацией столько раз сколько введет пользователь.
        // updateFile(String path , String textForUpdate, int num){…}
        System.out.println("Beginning Task 3");
        // используя байтовый
        try (Writer writer = new BufferedWriter(new FileWriter(path, true))) {
            for (int counter = 0; counter < num; counter++) {
                for (int c : textForUpdate.toCharArray()) {
                    writer.write(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //символьный
        try (Writer writer = new BufferedWriter(new FileWriter(path, true))) {
            for (int counter = 0; counter < num; counter++) {
                for (Character c : textForUpdate.toCharArray()) {
                    writer.write(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //и буферизированный потоки
        try (Writer writer = new BufferedWriter(new FileWriter(path, true))) {
            for (int counter = 0; counter < num; counter++) {
                writer.write(textForUpdate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing Task 3");
    }

    /**
     * Т.к. задача выполняется тремя способами, будет записано 3 файла
     */
    @Data
    static class randomNumber {
        private int index;
        private int number;
        private boolean isRepeating;

        public randomNumber(int index) {
            this.index = index;
            this.number = (int) ((Math.random() * 100) - 50);
        }
    }

    public static void task4(String path, int numberOfNumbers) {
        //Создать метод который заполнит файл случайными числами (каждое с новой строки).
        //Если генерируется число которое уже было записано, дополнять звёздочкой*
        System.out.println("Beginning Task 4");
        StringBuilder sb = new StringBuilder("");
        List<randomNumber> numbers = new ArrayList<>();
        for (int i = 0; i < numberOfNumbers; i++) {
            numbers.add(new randomNumber(i));
            boolean isRepeating = false;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (numbers.get(j).getNumber() == numbers.get(i).getNumber()) {
                        isRepeating = true;
                    }
                }
            }
            numbers.get(i).setRepeating(isRepeating);
        }
        for (int i = 0; i < numberOfNumbers; i++) {
            sb.append(numbers.get(i).getNumber());
            if (numbers.get(i).isRepeating) {
                sb.append('*');
            }
            if (numberOfNumbers - i != 1) {
                sb.append("\n");
            }
        }
        // используя байтовый
        try (Writer writer = new BufferedWriter(new FileWriter(path));) {
            for (int c : sb.toString().toCharArray()) {
                writer.write(c);
            }
            File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //символьный
        try (Writer writer = new BufferedWriter(new FileWriter(path.replace("task4.txt", "task4-2.txt")))) {
            for (Character c : sb.toString().toCharArray()) {
                writer.write(c);
            }
            File file = new File(path.replace("task4.txt", "task4-2.txt"));
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //и буферизированный потоки
        try (Writer writer = new BufferedWriter(new FileWriter(path.replace("task4.txt", "task4-3.txt")))) {
            writer.write(sb.toString());
            File file = new File(path.replace("task4.txt", "task4-3.txt"));
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing Task 4");
    }

    public static void task5(String path) {
        //Создать метод который отсортирует файл с числами по убыванию.
        System.out.println("Beginning Task 5");
        List<Integer> numbers = null;
        try (InputStream is = new FileInputStream(path);
             Reader reader = new FileReader(path);
             Reader reader2 = new BufferedReader(new FileReader(path))) {
            // используя байтовый
            int code;
            StringBuilder str1 = new StringBuilder();
            while ((code = is.read()) != -1) {
                str1.append((char) code);
            }
            //символьный
            StringBuilder str2 = new StringBuilder();
            while ((code = reader.read()) != -1) {
                str2.append((char) code);
            }
            //и буферизированный потоки
            StringBuilder str3 = new StringBuilder();
            while ((code = reader2.read()) != -1) {
                str3.append((char) code);
            }
            if (str1.toString().equals(str2.toString()) && str1.toString().equals(str3.toString())) {
                String str = str1.toString().replace('*', '\n');
                String[] strings = str.split("\n");
                numbers = new ArrayList<Integer>();
                for (int i = 0; i < strings.length; i++) {
                    if (!(strings[i].isEmpty())) {
                        numbers.add(Integer.parseInt(strings[i]));
                    }
                }
            } else System.out.println("Something went wrong!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        numbers.sort(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i).toString());
            sb.append('\n');
        }
        try (Writer writer = new BufferedWriter(new FileWriter(path.replace("task4.txt", "task5.txt")))) {
            writer.write(sb.toString());
            File file = new File(path.replace("task4.txt", "task5.txt"));
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing Task 5");
    }

    /**
     * Полный аналог задания, решённого на занятии 24.8.
     */
    static void task6(String path, String[] searchwords) {
        //Создать метод который найдет указанный текст в файле. Выведите количество повторений в консоль.
        System.out.println("Beginning Task 6");
        for (String searchword : searchwords) {
            String stringToLowerCase = IOUtils.readFileByLine(path).toLowerCase();
            int searchwordCounter = 0;
            int indexCounter = 0;
            boolean countComplete = false;
            while (!countComplete) {
                indexCounter = stringToLowerCase.indexOf(searchword, indexCounter) +
                        searchword.length();
                if (!(stringToLowerCase.indexOf(searchword, indexCounter) == -1)) {
                    searchwordCounter++;
                } else {
                    countComplete = true;
                    if (searchwordCounter > 0) {
                        searchwordCounter++;
                    }
                }
            }
            System.out.println(searchword + " : " + searchwordCounter);
        }
        System.out.println("Finishing Task 6");
    }

    /**
     * Байтовый поток превращает кириллицу в кашу, поэтому тут придётся обойтись 2 способами
     */
    static void task7(String path) {
        //Перед вами стихотворение А. С. Пушкина. Найти частоту повторения слов. Частоту повторения букв.
        System.out.println("Beginning Task 7");
        try (Reader reader = new FileReader(path);
             Reader reader2 = new BufferedReader(new FileReader(path))) {
            int code;
            StringBuilder str1 = new StringBuilder();
            // используя символьный
            str1 = new StringBuilder();
            while ((code = reader.read()) != -1) {
                str1.append((char) code);
            }
            //и буферизированный потоки
            StringBuilder str2 = new StringBuilder();
            while ((code = reader2.read()) != -1) {
                str2.append((char) code);
            }
            if (str1.toString().equals(str2.toString())) {
                StringBuilder str3;
                str3 = str1;
                String result = str1.toString().replaceAll("\n", " ").replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").toLowerCase();
                String[] strings = result.split(" +");
                ArrayList<String> words = new ArrayList<>();
                for (String string : strings) {
                    words.add(string);
                }
                Set<String> set = new HashSet<>(words);
                words.clear();
                words.addAll(set);
                for (int i = 0; i < words.size(); i++) {
                    int counter = 0;
                    for (String string : strings) {
                        if (words.get(i).equals(string)) {
                            counter++;
                        }
                    }
                    System.out.println(words.get(i) + " : " + counter);
                }
                for (char a = 'а'; a <= 'я'; a++) {
                    int counter = 0;
                    for (String str : strings) {
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == a) {
                                counter++;
                            }
                        }
                    }
                    System.out.println(a + " : " + counter);
                }
            } else System.out.println("Something went wrong!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finishing Task 7");
    }


    /**
     * Байтовый поток превращает кириллицу в кашу, поэтому тут придётся обойтись 2 способами
     */
    static void task8(String path) {
        //Прочитайте текст из файла, удалите все лишние пробелы, знаки табуляции. Пересохраните текст задом наперед.
        System.out.println("Beginning Task 8");
        try (Reader reader = new FileReader(path);
             Reader reader2 = new BufferedReader(new FileReader(path))) {
            int code;
            StringBuilder str1 = new StringBuilder();
            // используя символьный
            str1 = new StringBuilder();
            while ((code = reader.read()) != -1) {
                str1.append((char) code);
            }
            //и буферизированный потоки
            StringBuilder str2 = new StringBuilder();
            while ((code = reader2.read()) != -1) {
                str2.append((char) code);
            }
            if (str1.toString().equals(str2.toString())) {
                StringBuilder str3;
                str3 = str1;
                String result = str1.toString().replaceAll("\n", " ").
                        replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").replaceAll(" +", " ");
                StringBuilder stringBuilder = new StringBuilder(result);
                result = stringBuilder.reverse().toString();
                try (Writer writer = new BufferedWriter(new FileWriter("src/main/java/homework/io/nikhsuP.txt"))) {
                    writer.write(result);
                    File file = new File("src/main/java/homework/io/nikhsuP.txt");
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing Task 8");
    }

    public static void main(String[] args) {
        task1("src/main/java/homework/io/task1.txt", "text");
        task2("src/main/java/homework/io/task1.txt");
        task3("src/main/java/homework/io/task1.txt", " EXTRA", 3);
        task4("src/main/java/homework/io/task4.txt", 20);
        task5("src/main/java/homework/io/task4.txt");
        task6("src/main/java/homework/io/task4.txt", new String[]{"1", "2", "0"});
        task7("src/main/java/homework/io/Pushkin.txt");
        task8("src/main/java/homework/io/Pushkin.txt");
    }
}
