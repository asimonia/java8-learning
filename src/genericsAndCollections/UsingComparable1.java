package genericsAndCollections;

public class UsingComparable1 implements Comparable<UsingComparable1> {
    private int id;

    public int compareTo(UsingComparable1 a) {
        return this.id - a.id;
    }

    public static void main(String[] args) {
        UsingComparable1 a1 = new UsingComparable1();
        UsingComparable1 a2 = new UsingComparable1();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}
