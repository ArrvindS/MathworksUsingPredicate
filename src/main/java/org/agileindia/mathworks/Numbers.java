package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Numbers {
    private List<Integer> numbers = new ArrayList<>();

    public Numbers(int ...numbers) {
        this.numbers.addAll(toList(numbers));
    }

    public Numbers(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    private static boolean isInRange(int number, int low, int high){
        return (low <= number && number <= high);
    }

    private List<Integer> toList(int[] items) {
        List<Integer> toVerify = new ArrayList<>();
        for (int number : items) {
            toVerify.add(number);
        }
        return toVerify;
    }

    public Numbers select(Predicate<Integer> predicate) {
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                selected.add(number);
            }
        }
        return new Numbers(selected);
    }

    public int size() {
        return numbers.size();
    }

    public boolean hasItems(int... items) {
        return numbers.containsAll(toList(items));
    }

    public int sum() {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public Numbers inBetween(int low, int high) {
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (Predicates.INRANGE.test(number, low, high)) {
                selected.add(number);
            }
        }
        return new Numbers(selected);
    }

    public int product() {
        int product = 1;
        for(Integer number : numbers) {
            product *= number;
        }
        return product;
    }

    public int count(){
        return this.numbers.size();
    }

    public Numbers times(int factor) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            number *= factor;
            result.add(number);

        }
        return new Numbers(result);
    }
}
