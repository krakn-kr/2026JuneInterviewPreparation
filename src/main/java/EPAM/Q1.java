package EPAM;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args) {
        String str = "banana";
        String result = IntStream.range(0, str.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, str.length())
                        .mapToObj(j -> str.substring(i, j))
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse("");
        System.out.println(result);

    }
}
