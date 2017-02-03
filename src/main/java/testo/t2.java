package testo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class t2 {

    public static ArrayList<String> find(String e) {
        ArrayList<String> ready = new ArrayList<>();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
//        String source = "This is a test. This is a T.L.A. test. Now with a Dr. in it.";
        iterator.setText(e);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            ready.add(e.substring(start, end));
//            System.out.println(content.substring(start,end));
        }
        return (ready);
    }

    public static void main(String[] args) throws IOException {


        Path path = Paths.get("files/TomSawyer.txt");
        String content = new String(Files.readAllBytes(path));
        ArrayList<String> readyS = find(content);
        String word = "saw";
        List<String> total = readyS.stream()

                .map(String::toLowerCase)
                .filter(s -> s.contains(word))
                .collect(Collectors.toList());

        for (String e: total) {
            System.out.println(e);
            System.out.println();

        }



    }
}

