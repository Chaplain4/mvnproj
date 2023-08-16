package util;

import java.io.File;
import java.util.Date;

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
}