package Q26;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByLength {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "melon", "pear", "plum");
        Map<Integer, List<String>> frequencyMap = strings.stream().collect(Collectors.groupingBy(String::length));
    frequencyMap.forEach((key,val)->{
        System.out.println("length ="+key+" "+val);
    });
    }
}
