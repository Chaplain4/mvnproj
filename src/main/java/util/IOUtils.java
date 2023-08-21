package util;

import io.Test;

import java.io.*;
import java.util.Date;
import java.util.Locale;

public class IOUtils {
    public static void printStat (String path) {
        File rootFile = new File(path);
        if (!rootFile.exists()) {
            System.out.println("invalid file path");
            return;
        }

        if (rootFile.isDirectory()) {
            System.out.println(String.format("FOLDER <%s><LastModified:%s>", rootFile.getName(), new Date(rootFile.lastModified()).toString()));
            File[] files = rootFile.listFiles();
            for (int i = 0, j = 0; i < files.length; i++) {
                for (int k = 0; k < j; k++) {
                    System.out.print("  ");
                }
                printStat(files[i].getPath());
            }
        } else {
            System.out.println(String.format("FILE ---> <%s><Size:/d>", rootFile.getName(), rootFile.length()));
        }
    }

    public static void write(String data, String path) {
        try (Writer writer = new BufferedWriter(new FileWriter(path))) {
        writer.write(data);
        File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String data, String path, boolean append) {
        try (Writer writer = new BufferedWriter(new FileWriter(path, append))) {
            writer.write(data);
            File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stitch(String newFilePath, String... paths) {
        StringBuilder sb = new StringBuilder();
        for (String path : paths) {
            sb.append(io.Test.readFile(path));
        }
        write(sb.toString(), newFilePath, true);
    }

    public static void findKeyword(String filePath, String searchword) {
        if (io.Test.readFile(filePath).toLowerCase().contains(searchword.toLowerCase())) {
            System.out.println("Searchword found!");
        }
    }
}