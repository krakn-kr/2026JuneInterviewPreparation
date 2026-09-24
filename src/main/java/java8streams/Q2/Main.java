package java8streams.Q2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Q2. Find sum of even numbers and sum of odd numbers in a given list ?
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, Integer> result = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0,
                Collectors.summingInt(Integer::intValue)));
        System.out.println("Even numbers="+result.get(true));
        System.out.println("Odd numbers="+result.get(false));
    }
}
