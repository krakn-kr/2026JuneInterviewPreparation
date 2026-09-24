package java8streams.Q9;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Q9. Find the first non-repeating character in a string ?
 */
public class Main {
    public static void main(String[] args) {
        String str = "Ashok Kumar Naidu";
        Optional<Map.Entry<Character, Long>> first = str.toLowerCase().chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();
        first.ifPresent(entry-> System.out.println(entry.getKey()));
    }
}
