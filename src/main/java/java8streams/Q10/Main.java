package java8streams.Q10;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Q10. Find frequency of characters of a given string ?
 */
public class Main {
    public static void main(String[] args) {
        String str = "Ashok Kumar Naidu";
        Map<Character, Long> characterLongMap = str.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(characterLongMap);
    }
}
