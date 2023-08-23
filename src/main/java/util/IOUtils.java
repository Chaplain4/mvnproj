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

    public static String readFileByLine(String path) {
        StringBuilder sb = new StringBuilder(214748364);
        try (BufferedReader reader = new BufferedReader(new FileReader(path), 214748364)) {  // using TRY - with - resources. See AutoCloseable.
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
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

class Tasks {
    //прочитать файл и вернуть задом наперед в новый файл
    static void task1(String path, String newPath) {
        StringBuilder data = null;
        data.append(IOUtils.readFileByLine(path));
        StringBuilder atad = data.reverse();
        IOUtils.write(atad.toString(),newPath);
    }

    //исследовать входящий файл на количество поисковых слов и вернуть результат в файл.
    static void task2(String path, String resultFilePath, String[] searchwords) {
        for (String searchword : searchwords) {
            String stringToLowerCase = IOUtils.readFileByLine(path).toLowerCase();
            int searchwordCounter = 0;
            int indexCounter = 0;
            boolean countComplete = false;
            while (!countComplete) {
                indexCounter = stringToLowerCase.indexOf(searchword, indexCounter) +
                        searchword.length() - 1;
                if (!(stringToLowerCase.indexOf(searchword, indexCounter) == -1)) {
                    searchwordCounter++;
                } else {
                    countComplete = true;
                    if (searchwordCounter > 0) {
                        searchwordCounter++;
                    }
                }
            }
            IOUtils.write(searchword + " : " + searchwordCounter,resultFilePath, true);
            IOUtils.write("\n",resultFilePath, true);
        }
    }

    public static void main(String[] args) {
        task2("D:/io_tests/war_and_peace.ru.txt", "D:/io_tests/war_and_peace.ru-search"
                + new Date().getTime() + ".txt", new String[]{"война", "мир", "наполеон", "кутузов", "пьер"});
    }
}