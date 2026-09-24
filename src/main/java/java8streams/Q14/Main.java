package java8streams.Q14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Q14. Convert a list of strings to map where key is the string and the value is the length ?
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ashok", "Kumar", "Naidu", "Ram","Ram");
        Map<String, Integer> collect = list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length,(existingValue,newValue)->existingValue));
        System.out.println(collect);

    }
}
