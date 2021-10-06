package functionalProgramming;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonTerminalOperations {

    void test() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3

        // min() and max() returns an Optional
        Stream<String> sMin = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = sMin.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());

        // findAny() and findFirst() returns an Optional
        Stream<String> sFind = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        sFind.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp

        // allMatch(), anyMatch() and nonMatch()
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite1 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite1.anyMatch(pred)); // true

        // forEach()
        Stream<String> sForEach = Stream.of("Monkey", "Gorilla", "Bonobo");
        sForEach.forEach(System.out::print); // MonkeyGorillaBonobo

        // reduce()
        // The most common ways of doing a reduction is to start with an initial
        // value and keep merging it with the next value
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (ss, c) -> ss + c);
        System.out.println(word); // wolf

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        String word1 = stream1.reduce("", String::concat);
        System.out.println(word1);

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::print); // 3
        threeElements.reduce(op).ifPresent(System.out::print); // 90

        // collect()
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        StringBuilder word2 = stream2.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        System.out.println(word2);

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set3 = stream3.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set3); // [f, l, o, w]

        // unsorted
        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        Set<String> set = stream4.collect(Collectors.toSet());
        System.out.println(set); // [f, w, l, o]
    }

    public static void main(String[] args) {
        var c = new CommonTerminalOperations();
        c.test();
    }
}
