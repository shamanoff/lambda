package testo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class t2 {

// BreakeIterator with Locale return list of strings there every string is sentence.

    private static ArrayList<String> sentenceFinder(String inputString) {
        ArrayList<String> readyList = new ArrayList<>();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(inputString);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            readyList.add(inputString.substring(start, end));
        }
        return (readyList);
    }

// WordComparator return true only if sentence contains full word that we are looking for

    private static boolean wordComparator(String stringFromText, String targetWord){
        String[] words = stringFromText.split("\\s+");
        String test = "";
        for (String s: words) {
            if(targetWord.equalsIgnoreCase(s)){
                test = s;
            }
        }
        return !Objects.equals(test, "");
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("files/TomSawyer.txt");
        String content = new String(Files.readAllBytes(path));
        ArrayList<String> allStrings = sentenceFinder(content);

        String targetWord = "saw"; //The word that we looking for

        List<String> resultSentences = allStrings.stream()
                .filter(s -> wordComparator(s, targetWord))
                .collect(Collectors.toList());

        for (String e: resultSentences) {
            System.out.println(e);
            System.out.println();

        }



    }
}

