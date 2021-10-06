package genericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 *
 *         A bounded parameter type is a generic type that specifies a bound for the generic
 *
 *         A wildcard generic type is an unknown generic type represented by ( ? )
 *
 *         class A {}
 *         class B extends A { }
 *         class C extends B { }
 *
 *         List<?> list1 = new ArrayList<A>();
 *         List<? extends A> list2 = new ArrayList<A>();
 *         List<? super A> list3 = new ArrayList<A>();
 *         List<? extends B> list4 = new ArrayList<A>(); It has an upper-bounded wildcard that allows ArrayList<B> or ArrayList<C> to be referenced.
 *         List<? super B> list5 = new ArrayList<A>();
 *         List<?> list6 = new ArrayList<? extends A>(); The problem is that you need to know what
 *         that type will be when instantiating the ArrayList.
 *
 *         Generics enable parameterized types for classes and interfaces.  Benefits include:
 *         1. Stronger type checks at compile time
 *         2. Elimination of casts
 *         3. Generic algorithms
 *
 *         Upper bounded wildcard restricts the unknown type to be a specific type or a subtype of that type and is
 *         represented using the extends keyword. In a similar way, a lower bounded wildcard restricts the unknown type
 *         to be a specific type or a super type of that type.
 */
public class GenericBound {

    interface UnaryPredicate<T> {
        boolean test(T obj);
    }

    // 1. Unbounded wildcards
    static void printList(List<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }

    /**
     * 2. Upper-Bounded Wildcards
     * The upper-bounded wildcard says that any class
     * that extends Number or Number itself can be used as the formal parameter type:
     *
     */
    public static long total(List<? extends Number> list) {
        // ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT
        // COMPILE
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    // 3. Lower-Bounded Wildcards
    // This will work with an Integer or any super type of Integer, for example,
    // List<Number> or List<Object>
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c) {
            if (p.test(elem))
                ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(1, "apple");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);
        List<Integer> li = Arrays.asList(1, 2, 2);
        addNumbers(li);
    }
}


class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}