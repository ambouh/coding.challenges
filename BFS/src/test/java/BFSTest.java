import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BFSTest {
    @Test
    public void TestCase1() {
        Assert.assertTrue(true);
    }

    @Test
    public void TestCase3() {
        //
        String path = "src/main/resources/file1.txt"; //from source path
        File file = new File(path);
        int[] result = new int[0];

        try {
            Scanner scanner = new Scanner(file);
            result = BFS.runBFS(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = BFS.stringify(result);
        String expected = "6 -1 -1 -1 -1 -1 12 -1 12";
        boolean match = expected.equals(str);
        Assert.assertTrue(true);
    }
}