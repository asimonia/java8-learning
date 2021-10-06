package functionalProgramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class WorkingWithAdvancedStreamPipelineConcepts {

    void chainingOptionals() {
        Optional<Integer> o = Optional.of(123);
        // imperative
        if (o.isPresent()) {
            Integer num = o.get();
            String string = "" + num;
            if (string.length() == 3)
                System.out.println(string);
        }

        // functional
        o.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    void isDistinct() {
        String s = "ABC";
        boolean test_uppercase = s.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(Character::isUpperCase);

        int a = s.toCharArray().length;

        int b = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet())
                .size();

        boolean is_distinct_and_uppercase = test_uppercase && (a == b);

        System.out.println(is_distinct_and_uppercase);

    }

    void collectingResults() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingDouble(String::length));
        System.out.println(result2);

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3.filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3);
    }

    void collectingIntoMaps() {
        Stream<String> a = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = a.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        Stream<String> b = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map2 = b.collect(Collectors.toMap(String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2,
                TreeMap::new));
        System.out.println(map2);
    }

    void groupPartitionMapping() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(groupingBy(String::length));
        System.out.println(map);

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map2 = ohMy2.collect(groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map2);

        // partitioning is a special case of grouping
        // with partitioning there are only two possible groups: true and false
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map3 = ohMy3.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map3);

    }


    public static void main(String[] args) {
        var w = new WorkingWithAdvancedStreamPipelineConcepts();
        w.chainingOptionals();
        w.isDistinct();
        w.collectingResults();
        w.collectingIntoMaps();
        w.groupPartitionMapping();
    }
}
