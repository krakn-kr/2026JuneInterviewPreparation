package Q40;

import java.util.Arrays;
import java.util.List;

public class ProductOfElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

    }
}
