package Q41;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> set = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toSet());
        System.out.println(set);

    }
}
