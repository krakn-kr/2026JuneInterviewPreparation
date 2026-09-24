package java8streams.Test;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String[] result = words.stream().toArray(String[]::new);
    }
}
