package Q42;

import java.util.Arrays;
import java.util.List;

public class PrefixCheck {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        String prefix = "ba";

        boolean b = strings.stream()
                .anyMatch(str -> str.startsWith(prefix));
        System.out.println(b);
    }
}
