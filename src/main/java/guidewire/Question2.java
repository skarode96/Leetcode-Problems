package guidewire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public static void solve() {

    }

    public static void getFileList(String directory) throws IOException {

        List<String> fileList = new ArrayList<>();
        File file = new File(directory);

        getFiles(file, fileList);

        fileList.forEach(System.out::println);

    }

    private static void getFiles(File directory, List<String> fileList) throws IOException {

        File[] files = directory.listFiles();
        for (File file: files) {
            if(file.isDirectory()) {
                getFiles(file, fileList);
            } else {
                fileList.add(file.getCanonicalPath());
            }
        }
    }
}
