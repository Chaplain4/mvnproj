package io;

import util.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Test {

    public void practice() {
        File file = new File("D:\\io_tests\\new_file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("New file is created = " + isCreated);
            File file2 = new File("D:\\io_tests\\simple_file2.txt");
            boolean isExists = file2.exists();
            if (!isExists) {
                file2.createNewFile();
                System.out.println("New file is created");
            }
            File file3 = new File("D:\\io_tests");
            System.out.println("Path: " + file3.getPath());
            System.out.println("Name: " + file3.getName());
            File[] files = file3.listFiles();
            System.out.println("path names size : " + files.length);
            System.out.println("**********");
            IOUtils.printStat(file3.getPath());
            System.out.println("**********");
            InputStream is = new FileInputStream("D:/io_tests/war_and_peace.ru.txt");
            Date startDate2 = new Date();
            int code = is.read();
            System.out.println("code = " + code);
            char ch = (char) code;
            System.out.println("char = " + ch);
            System.out.println("char = " + (char) is.read());
            System.out.println("char = " + (char) is.read());
            System.out.println("char = " + (char) is.read());
            System.out.println("char = " + (char) is.read());
            while ((code = is.read()) != -1) {
                System.out.print((char) code);
            }
            System.out.println();
            Date endDate2 = new Date();
            System.out.println("**********");
            Date startDate1 = new Date();
            Reader reader = new FileReader("D:/io_tests/war_and_peace.ru.txt");
            while ((code = reader.read()) != -1) {
                System.out.print((char) code);
            }
            Date endDate1 = new Date();
            System.out.println("**********");
            Date startDate = new Date();
            Reader reader2 = new BufferedReader(new FileReader("D:/io_tests/war_and_peace.ru.txt"));
            int charcode2;
            while ((charcode2 = reader2.read()) != -1) {
                System.out.print((char) charcode2);
            }
            Date endDate = new Date();
            System.out.println(endDate.getTime() - startDate.getTime());
            System.out.println(endDate1.getTime() - startDate1.getTime());
            System.out.println(endDate2.getTime() - startDate2.getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> task1(File file) {
        ArrayList<String> arraylist = new ArrayList<String>(1);
        Reader reader3 = null;
        try {
            reader3 = new BufferedReader(new FileReader(file.getPath()));
            int charcode3;
            StringBuilder stringBuilder = new StringBuilder();
            while ((charcode3 = reader3.read()) != -1 && stringBuilder.length() != Integer.MAX_VALUE) {
                if (stringBuilder.length() < Integer.MAX_VALUE - 1) {
                    stringBuilder.append((char) charcode3);
                } else {
                    arraylist.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length() - 1);
                }
            }
            if (stringBuilder.length() > 0) {
                arraylist.add(stringBuilder.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arraylist;
    }

    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder(214748364);
        try (Reader reader = new BufferedReader(new FileReader(path), 214748364)) {  // using TRY - with - resources. See AutoCloseable.
            int characterCode;
            while ((characterCode = reader.read()) != -1) {
                sb.append((char) characterCode);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Resource res = new Resource()) {
            //working with resource
            res.addLine("hello ");
            res.addLine("world");
            res.printData();
            ArrayList<String> arrayList = task1(new File("D:/io_tests/war_and_peace.ru.txt"));
            File file2 = new File("D:/io_tests/war_and_peace2.ru.txt");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
                System.out.println(arrayList.get(i).length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class Resource implements Closeable {

    private String data = new String();

    @Override
    public void close() throws IOException {
        if (data.length() > 0) {
            data = new String();
            System.out.println("Resource data clear");
        }
    }

    public void addLine(String line) {
        data += line;
    }

    public void printData() {
        System.out.println(data);
    }
}
