package testo;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class t2 {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("files/testText.txt");
        String content = new String(Files.readAllBytes(path));
        System.out.println(content);

    }
}
