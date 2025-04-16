package org.agileindia.mathworks;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Predicates {

    public static Predicate<Integer> EVEN = number -> number % 2 == 0;
    public static Predicate<Integer> PERFECT_PREDICATE = (n -> n > 1 && IntStream.range(1, n).filter(i -> n % i == 0).sum() == n);
    public static Predicate<Integer> ODD_PREDICATE = EVEN.negate();
    public static Predicate<Integer> PRIME_PREDICATE=number -> {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    };
    public static TriPredicate<Integer, Integer, Integer> INRANGE =
            (number, low, high) -> low <= number && number <= high;
}

