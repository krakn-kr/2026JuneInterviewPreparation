package java8streams.Q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Q15. Flatten a list of lists of integers into a single list of integers ?
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60));
        List<Integer> list1 = list.stream().flatMap(List::stream)
                .toList();
        System.out.println(list1);
    }
}
