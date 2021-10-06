package genericsAndCollections;

/*
    The process of removing generics syntax from your code during compilation is referred to as type erasure.
    The compiler will convert the generics to Object and add the relevant casts for your code to work with this
    type of erased class.
 */
public class GenericClass<T> {
    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
    // Generic Method
    public static <T> GenericClass<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new GenericClass<T>();
    }
}

class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}
