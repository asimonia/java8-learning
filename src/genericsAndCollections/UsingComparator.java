package genericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsingComparator implements Comparable<UsingComparator> {
    private String name;
    private int weight;

    public UsingComparator(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    public int compareTo(UsingComparator d) {
        return name.compareTo(d.name);
    }
    public static void main(String[] args) {
        // Comparator is a functional interface
        // We can create an anonymous inner class which is the old way
        Comparator<UsingComparator> byWeight = new Comparator<UsingComparator>() {
            @Override
            public int compare(UsingComparator d1, UsingComparator d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        // Best to use a lambda instead
        Comparator<UsingComparator> byWeight2 = (d1, d2) -> d1.getWeight() - d2.getWeight();

        // Simplify it even further by passing a method reference inside a generic static method
        Comparator<UsingComparator> byWeight3 = Comparator.comparingInt(UsingComparator::getWeight);

        List<UsingComparator> ducks = new ArrayList<>();
        ducks.add(new UsingComparator("Quack", 7));
        ducks.add(new UsingComparator("Puddles", 10));
        // Using Comparable
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        // Using Comparator
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
    }
}
