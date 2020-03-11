import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BFSTest {

    @Test
    public void TestCase3() {
        //
        String path = "src/main/resources/file1.txt"; //from source path
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            int[] result = BFS.runBFS(scanner);
            String str = BFS.stringify(result);
            String expected = "6 -1 -1 -1 -1 -1 12 -1 12";
            Assert.assertEquals(expected, str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}