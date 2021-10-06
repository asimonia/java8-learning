package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

/*
    Generics provide type safety at the compilation level.
    If raw types were used, then to avoid ClassCastException,
    you have to use instanceOf before casting
 */
public class WorkingWithGenerics {

    // raw use of parameterized class List
    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof StringBuilder) {
                System.out.println("it is not a String");
            }
            String name = (String) list.get(i); // get the list element and cast to String
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        List names = new ArrayList();

        try {
            names.add(new StringBuilder("Webby"));
            printNames(names);
        } catch (ClassCastException e) {
            e.printStackTrace();  // class java.lang.StringBuilder cannot be cast to class java.lang.String
        }
    }
}
