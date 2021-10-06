package genericsAndCollections;


/*
 *         3 ways a class can approach implementing this interface
 *
 *         Here are the things that you can’t do with generics. (And by “can’t,”
 *         we mean without resorting to contortions like passing in a class
 *         object.)
 *         1. Call the constructor. new T() is not allowed because at
 *         runtime it would be new Object() .
 *         2. Create an array of that static type. This one is the most annoying, but it makes sense
 *         because you’d be creating an array of Object s.
 *         3. Call instanceof . This is not allowed because at runtime List<Integer> and List
 *         <String> look the same to Java thanks to type erasure.
 *         4.Use a primitive type as a generic type parameter. This isn’t a big deal
 *         because you can use the wrapper class instead. If you want a type of
 *         int , just use Integer.
 *         5. Create a static variable as a generic type parameter.
 *         This is not allowed because the type is linked to the
 *         instance of the class.
 */
public interface GenericInterface<T> {
    void ship(T t);
}

interface Shippable<T> {
    void ship(T t);
}

class Robot {
    private String name;
    private Integer life;
}

// Method 1: specify the generic type to the class
class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) {}
}

// Method 2: create a generic class
class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) {}
}

// Method 3: don't use generics
class ShippableCrate implements Shippable {
    public void ship(Object t) {}
}