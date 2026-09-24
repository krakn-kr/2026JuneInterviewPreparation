package Q25;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String input = "aaaabbccc";
        Map<Character,Long> freqencyMap = input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freqencyMap.forEach(((character, aLong) -> {
            System.out.println("Character: "+character+"="+aLong);
        }));
    }
}
