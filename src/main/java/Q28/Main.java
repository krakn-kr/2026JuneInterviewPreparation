package Q28;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);
        Double result = numbers.stream().filter(number -> number > 10)
                .collect(Collectors.averagingDouble(Integer::intValue));
        System.out.println(result);
        double result2 = numbers.stream().filter(n -> n > 10)
                .mapToInt(number -> number)
                .average()
                .orElse(0.0);
        System.out.println(result2);
    }
}
