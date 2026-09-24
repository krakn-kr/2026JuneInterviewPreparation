package Q27;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "example string";
        Map<Character, Long> characterMap = input.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        characterMap.forEach((key,val)->{
            System.out.println(key+"="+val);
        });
    }
}
