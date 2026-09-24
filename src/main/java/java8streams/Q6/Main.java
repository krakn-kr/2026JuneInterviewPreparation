package java8streams.Q6;

import java.util.Arrays;
import java.util.List;

/*
Q6. Find out all the numbers starting with 1 from a integer list ?
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,200,110,35,60,13);
        List<Integer> result = list.stream().map(String::valueOf)
                .filter(str -> str.startsWith("1"))
                .map(Integer::valueOf)
                .toList();
        System.out.println(result);
    }
}
