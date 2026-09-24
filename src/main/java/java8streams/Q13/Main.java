package java8streams.Q13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Q13. Filter a list of numbers to only include those greater than 10 and then find their average ?
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 10, 12, 18);
        Double result = list.stream().filter(integer -> integer > 10)
                        .mapToInt(i->i).average().orElse(0.0);
        System.out.println(result);
    }
}
