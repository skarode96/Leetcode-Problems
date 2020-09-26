package guidewire;

import org.junit.Test;

import java.io.IOException;

public class Question2Test {

    @Test
    public void test() throws IOException {
        String directory = "/home/sameer/projects/leetcode-problems";
        Question2.getFileList(directory);
    }

}