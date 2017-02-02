package testo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testo {



    public static void main(String[] args) {
        Function<String, Stream<String>> splitSentence =
                s -> Pattern.compile("[.!?]").splitAsStream(s);



//        Path path = Paths.get("files/testText.txt");
        Path path = Paths.get("files/TomSawyer.txt");
        String inputWord = "be";

        try {
//            String content = new String(Files.readAllBytes(path));


            List<String> lines = Files.lines(path)

                    .map(String::toLowerCase)
                    .flatMap(splitSentence)
                    .filter(s -> s.contains(inputWord))
                    .collect(Collectors.toList());

            for (String s:lines) {
                System.out.println(s);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
