package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSources {


    public void test() {
        Stream<String> empty = Stream.empty(); // count = 0;
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> formArray = Stream.of(1, 2, 3);

        // Java provides a convenient way to convert from a list to a stream
        List<String> list = Arrays.asList("ABC", "DEF", "GHI", "JKL");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        // infinite stream
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

    }

}
