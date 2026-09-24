package java8streams.Q3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Q3. Find duplicate elements in a given integers list ?
*/
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,50,20,50);
        Map<Integer, Long> result = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> result2 = result.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println(result2);
    }

}
