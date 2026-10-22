package Q34;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueWordsCollector {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(

                "Java 8 introduced streams",

                "Streams are powerful",

                "Use streams to process data"

        );
        Set<String> result = sentences.stream().map(word -> word.split("\\s+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println(result);
        System.out.println(new Random().nextInt(0,11));
        System.out.println((int)(Math.random()*11));
    }
}
