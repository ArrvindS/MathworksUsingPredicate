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
    public static List<Integer> select(List<Integer> numbers, Predicate<Integer> condition) {
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (condition.test(number)) {
                selected.add(number);
            }
        }
        return selected;
    }
    public static Integer sum(List<Integer> numbers){
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
    private static boolean range(int number, int low, int high){
        return (low <= number && number <= high);
    }
    public static List<Integer> inRange(List<Integer> numbers,int low , int high){
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (range(number,low,high)) {
                selected.add(number);
            }
        }
        return selected;
    }
    private List<Integer> toList(int[] items) {
        List<Integer> toVerify = new ArrayList<>();
        for (int number : items) {
            toVerify.add(number);
        }
        return toVerify;
    }

    public Numbers select(Predicate<Integer> predicate) {
        return new Numbers(select(numbers,predicate));
    }

    public int size() {
        return numbers.size();
    }

    public boolean hasItems(int... items) {
        return numbers.containsAll(toList(items));
    }

    public int sum() {
        return sum(numbers);
    }

    public Numbers inRange(int low, int high) {
        return new Numbers(inRange(numbers,low,high));
    }

    public int multiply() {
        return multiply(numbers);
    }

    private int multiply(List<Integer> numbers) {
        int multiply = 1;
        for(Integer number : numbers) {
            multiply *= number;
        }
        return multiply;
    }

    public Numbers multiplyWithFactor(int factor) {
        return new Numbers(multiplyWithFactor(numbers,factor));
    }
    private List<Integer> multiplyWithFactor(List<Integer> numbers, int factor){
        List<Integer> multipliedList = new ArrayList<>();
        for (Integer number : numbers) {
            number *= factor;
            multipliedList.add(number);

        }
        return multipliedList;
    }
}
