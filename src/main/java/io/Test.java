package io;

import util.IOUtils;

import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
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
            InputStream is = new FileInputStream(new File("D:/io_tests/war_and_peace.ru.txt"));
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
            System.out.println(endDate.getTime()-startDate.getTime());
            System.out.println(endDate1.getTime()-startDate1.getTime());
            System.out.println(endDate2.getTime()-startDate2.getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
