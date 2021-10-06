package functionalProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CommonIntermediateOperations {

    void test() {
        // filter returns a stream with the elements that match a given expression
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::println);

        // returns a stream with duplicate values removed
        Stream<String> sDistinct = Stream.of("duck", "duck", "duck", "goose");
        sDistinct.distinct()
                .forEach(System.out::print); // duckgoose

        // makes a stream smaller
        Stream<Integer> sSkipLimit = Stream.iterate(1, n -> n + 1);
        sSkipLimit.skip(5)
                .limit(2)
                .forEach(System.out::print); // 67

        // one-to-one transformation on each stream element
        Stream<String> sMap = Stream.of("monkey", "gorilla", "bonobo");
        sMap.map(String::length)
                .forEach(System.out::print); // 676

        // takes each element in the stream and makes any elements it contains top-level elements in a single stream
        // this is helpful when you want to remove empty elements from a stream or combine streams
        List<String> zero = List.of();
        List<String> one = List.of("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(Collection::stream)
                .forEach(System.out::println);

        Stream<String> sSorted = Stream.of("brown-", "bear-");
        sSorted.sorted().forEach(System.out::print); // bear-brown-

        Stream<String> sSorted2 = Stream.of("brown bear-", "grizzly-");
        sSorted2.sorted(Comparator.reverseOrder()).forEach(System.out::print);

        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(st -> st.startsWith("g")).peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list.stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        var c = new CommonIntermediateOperations();
        c.test();
    }
}
