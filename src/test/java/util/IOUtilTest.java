package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class IOUtilTest {
    @Test
    public void readFileTest(){
        String text = io.Test.readFile("D:/io_tests/new_file.txt");
        Assert.assertNotNull(text);
        Assert.assertEquals("Wrong content", "Hello World!", text);
    }

    @Test
    public void readLargeFileTest(){
        String text = io.Test.readFile("D:/io_tests/war_and_peace.ru.txt");
        Assert.assertNotNull(text);
        Assert.assertTrue(text.length()>100000);
    }

    @Test
    public void writeFileTest(){
        String path = "D:/io_tests/new_file_" + new Date().getTime() + ".txt";
        IOUtils.write("Hello from Java!", path);
        Assert.assertTrue(io.Test.readFile(path).length() > 10);
    }

    @Test
    public void appendFileTest(){
        String path = "D:/io_tests/new_file_" + new Date().getTime() + ".txt";
        IOUtils.write("Hello from Java!", path, true);
        IOUtils.write("Hello from Java!", path, true);
        Assert.assertEquals("Wrong Content", "Hello from Java!Hello from Java!", io.Test.readFile(path));
    }

    @Test
    public void stitchFileTest(){
        String newFilePath = "D:/io_tests/stitched_file_" + new Date().getTime() + ".txt";
        IOUtils.stitch(newFilePath,"D:\\io_tests/new_file_1692640788018.txt","D:\\io_tests/new_file_1692640788018.txt","D:\\io_tests/new_file.txt");
        Assert.assertEquals("Wrong Content", "Hello from Java!Hello from Java!Hello World!", io.Test.readFile(newFilePath));
    }
}
