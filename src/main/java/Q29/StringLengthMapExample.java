package Q29;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLengthMapExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<String, Integer> stringLengthMap = strings.stream().collect(Collectors.toMap(str -> str, String::length));
        stringLengthMap.forEach((key,value)->{
            System.out.println(key+"="+value);
        });
    }
}
