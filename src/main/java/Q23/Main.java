package Q23;

import java.util.List;

import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        List<String> strings = List.of("apple", "banana", "cherry");


        String result = strings.stream()

                .collect(Collectors.joining(", "));


        System.out.println(result); // Output: apple, banana, cherry

    }

}