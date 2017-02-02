package testo;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public interface SetnenceFunc {
    Function<String, Stream<String>> splitSentence =
    s -> Pattern.compile("[.!?]").splitAsStream(s);
}
