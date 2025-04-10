package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static List<Integer> select(List<Integer> numbers, Predicate<Integer> condition) {
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (condition.test(number)) {
                selected.add(number);
            }
        }
        return selected;
    }
}
