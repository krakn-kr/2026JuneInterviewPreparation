package Q37;

import java.util.Random;
import java.util.stream.Stream;

public class RandomNumberStream {
    public static void main(String[] args) {
        Random random = new Random();
        Stream<Integer> integerStream = Stream.generate(random::nextInt);
        integerStream.limit(10)
                .forEach(System.out::println);

    }
}
