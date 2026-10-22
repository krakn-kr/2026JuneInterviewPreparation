package Q44;

import java.util.*;

public class SecondHighest {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(5, 3, 9, 1, 6, 8, 9);
        Optional<Integer> secondHighest = numbersList.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondHighest.ifPresent(System.out::println);
    }
}
