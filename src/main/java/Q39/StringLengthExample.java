package Q39;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringLengthExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        List<Integer> list = strings.stream().map(String::length)
                .toList();
        System.out.println(list);
    }
}
