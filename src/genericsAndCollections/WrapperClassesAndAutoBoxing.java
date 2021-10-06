package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassesAndAutoBoxing {


    /**
     *
     *         Autoboxing automatically converts a primitive to the corresponding
     *         wrapper classes when needed if the generic type is specified in the
     *         declaration.
     *
     *         Unboxing is the conversion of a wrapper class to a primitive.
     */
    public class WrapperClassesAndAutoboxing {
        public void test() {
            List<Integer> numbers = new ArrayList<Integer>();
            // auboxing
            numbers.add(1);
            numbers.add(new Integer(3));
            numbers.add(new Integer(5));
            // Java sees a matching signature for int, so it doesn't need to autobox
            // the call to the method.
            numbers.remove(1);
            numbers.remove(new Integer(5));
            System.out.println(numbers); // 1
        }
    }
}
