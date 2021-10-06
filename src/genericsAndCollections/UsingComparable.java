package genericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Comparable should be used when you compare instances of the same class. Comparator can be used to compare
    instances of different classes. Comparable is implemented by the class which needs to define a natural ordering
    for its objects.
 */

public class UsingComparable implements Comparable<UsingComparable> {

    private String name;

    public UsingComparable(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(UsingComparable o) {
        return name.compareTo(o.name); // call String's compareTo
    }

    public static void main(String[] args) {
        List<UsingComparable> list = new ArrayList<>();
        list.add(new UsingComparable("b"));
        list.add(new UsingComparable("a"));
        Collections.sort(list); // sort by name
        System.out.println(list); // [a, b]
    }

}
