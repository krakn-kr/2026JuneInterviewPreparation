package java8streams.Intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers =
                Arrays.asList(50, 10, 30, 20, 40);

        numbers.stream()
                .filter(n -> n > 10)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("After map: " + n))
                .toList();
    }
}
