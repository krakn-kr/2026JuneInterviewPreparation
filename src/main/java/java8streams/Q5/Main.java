package java8streams.Q5;

import java.util.Set;
import java.util.stream.Collectors;

/*
Q5. Find Special characters in a string ?
 */
public class Main {
    public static void main(String[] args) {
        String str = "!~@# ashok#$";
        Set<Character> result = str.chars()
                .mapToObj(i -> (char) i)
                .filter(character -> !Character.isLetterOrDigit(character))
                .collect(Collectors.toSet());
        String result2 = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result2);

    }
}
