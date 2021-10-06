package genericsAndCollections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndArrayList {

    // List<E> extends Collection<E>
    // Collection<E> extends Iterable<E>

    // Iterable allows an object to be the target of the enhanced for statement
    // (sometimes called the "for-each loop" statement).
    // List is an ordered collection also known as a sequence
    static void test() {
        String[] array = { "a", "b" }; // [a, b]
        System.out.println(Arrays.toString(array));
        // convert an Array to a List
        List<String> list = Arrays.asList(array); // [a, b]
        System.out.println(list);
        // You can change the element in either the array or the list.
        // Changes are reflected in both, since they are backed by the same data.
        array[0] = "c";
        // convert a List to an Array
        //String[] array2 = (String[]) list.toArray(); // [c, b]

        // list.remove(1); throws UnsupportedOperationException
        // list is not resizable because it is backed by the underlying array.
    }

    public static void main(String[] args) {
        test();
    }
}
