import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

public class Main {


    public static void main(String[] args) {

/*        String words[] = {"Asterix", "Omega", "Djon", "Space"};

        System.out.println(Arrays.toString(words));

        List<String> wariors = Arrays.asList(words);
        wariors.stream()
                .map(String::toLowerCase)
                .filter("asterix"::equals)
                .collect(Collectors.toList());

        System.out.println("Wariors: "+ wariors.toString());*/

        List<String> beginningWithNumbers = Stream.of("a", "2abc", "abc", "1eee")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());

        System.out.println(beginningWithNumbers.toString());
    }
}
