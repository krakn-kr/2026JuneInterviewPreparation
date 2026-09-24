package java8streams.Q11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Q11. Group a list of strings by their length ?
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ashok", "Kumar", "Naidu", "Ram");
        Map<Integer, List<String>> result = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);
    }
}
