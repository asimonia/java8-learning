package functionalProgramming;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

/**
 *
 *         A functional interface has exactly one abstract method. This doesn't
 *         mean that they have only one method. It can still contain default
 *         methods or static methods
 *
 */
public class BuiltInFunctionalInterfaces {

    /**
     * A Supplier is used when you want to generate or supply values without
     * taking any input. A Supplier is often used when constructing new objects.
     */
    void supplier() {
        Supplier<LocalDate> s1 = () -> LocalDate.now();     // lambda
        Supplier<LocalDate> s2 = LocalDate::now;            // can be replaced with method reference; more concise

        LocalDate d1 = s1.get();
        LocalDate d2 = s1.get();

        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * You use a Consumer when you want to do something with a parameter but not return
     * anything.  BiConsumer does the same thing but with two params.
     */
    void consumerAndBiconsumer() {
        Consumer<String> c1 = (x) -> System.out.println(x);
        Consumer<String> c2 = System.out::println;
        c1.accept("a");

        // BiConsumer
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println(map);
    }

    /**
     * Predicate and BiPredicate is often used with filtering and matching.
     * Takes a parameter and returns a boolean
     */
    void predicateAndBipredicate() {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test("a"));

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("steve", "cole"));

        // default method
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());
        System.out.println(brownEggs.test("egg brown"));
        System.out.println(otherEggs.test("egg"));
    }

    void functionAndBiFunction() {
        // Function
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5

        // BiFunction
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick

        // TriFunction
        TriFunction<String, String, String, String> t1 = (string, toAdd1, toAdd2) -> string
                .concat(toAdd1)
                .concat(toAdd2);
        System.out.println(t1.apply("a ", "b ", "c"));
    }

    /**
     *
     * UnaryOperator and BinaryOperator are a special case of a function. They
     * require all type parameters to be the same type.
     */
    void unaryOperatorAndBinaryOperator() {
        // UnaryOperator
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        // BuiltInFunctionalInterfaces
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }

    public static void main(String[] args) {
        BuiltInFunctionalInterfaces b = new BuiltInFunctionalInterfaces();
        b.supplier();
        b.consumerAndBiconsumer();
        b.predicateAndBipredicate();
        b.functionAndBiFunction();
        b.unaryOperatorAndBinaryOperator();
    }
}
