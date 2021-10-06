package functionalProgramming;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturningAnOptional {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }


    public static Optional<String> firstMatch(String pattern, String content) {
        Matcher m = Pattern.compile(pattern).matcher(content);
        return m.find() ? Optional.of(m.group()): Optional.empty();
    }


    public static void main(String[] args) {
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty


        Optional<Double> opt = average(90, 100);

        if (opt.isPresent()) {
            System.out.println(opt.get()); // 95.0
        }
        opt.ifPresent(System.out::println); // 95.0

        firstMatch("A", "ABC").ifPresent(System.out::println);  // A
        firstMatch("D", "ABC").ifPresent(System.out::println);  // do nothing

        System.out.println(Optional.ofNullable(null));  // Optional.empty

        Optional<Double> opt2 = average();
        System.out.println(opt2.orElse(Double.NaN)); // NaN
        System.out.println(opt2.orElseGet(Math::random));
        System.out.println(opt2.orElseThrow(IllegalArgumentException::new));


    }
}
