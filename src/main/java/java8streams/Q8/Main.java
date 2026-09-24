package java8streams.Q8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Q8. Concatenate a list of strings into a single string, separated by commas ?
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ashok", "Kumar", "Naidu", "Ram");
        String result = list.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(result);
    }
}
