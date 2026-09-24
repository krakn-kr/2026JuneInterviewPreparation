package Q24;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        String input = "iindia";

        Optional<Character> result = findFirstNonRepeatingCharacter(input);

        result.ifPresentOrElse(

                c -> System.out.println("First non-repeating character: " + c),

                () -> System.out.println("No non-repeating character found")

        );

    }


    public static Optional<Character> findFirstNonRepeatingCharacter(String s) {

        // Create a LinkedHashMap to store character frequencies

        // and maintain insertion order

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        Optional<Character> first = s.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(c -> c,LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() ==1L )
                .map(Map.Entry::getKey).findFirst();
        // Count the frequency of each character
        System.out.println("lllllllll "+first.get());
        s.chars().mapToObj(c -> (char) c)

                .forEach(c ->

                        charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1)

                );


        // Find the first character with a frequency of 1

        return charCountMap.entrySet().stream()

                .filter(entry -> entry.getValue() == 1)

                .map(Map.Entry::getKey)

                .findFirst();

    }

}