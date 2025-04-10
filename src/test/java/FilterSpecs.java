import org.agileindia.mathworks.Filter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;


import static org.agileindia.mathworks.Predicates.*;

public class FilterSpecs {
    @Test
    public void itSelectsPerfectNumbersUsingPredicate() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 28);
        //When
        List<Integer> perfectNumbers = Filter.select(numbers,PERFECT_PREDICATE);

        //Then
        assertThat(perfectNumbers, hasSize(2));
        assertThat(perfectNumbers, hasItems(6, 28));
    }
    @Test
    public void itSelectsEvenNumberUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> evenNumbers = Filter.select(numbers, EVEN_PREDICATE);

        assertThat(evenNumbers, hasItems(2, 4));

    }
    @Test
    public void itSelectsOddNumberUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> evenNumbers = Filter.select(numbers, ODD_PREDICATE);

        assertThat(evenNumbers, hasItems(1, 3));

    }
    @Test
    public void itSelectsPrimeNumberUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> evenNumbers = Filter.select(numbers, PRIME_PREDICATE);

        assertThat(evenNumbers, hasItems(2,3));

    }
    @Test
    public void itSelectsOddOrPrimeUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumbers = Filter.select(numbers,ODD_PREDICATE.or(PRIME_PREDICATE));


        assertThat(evenNumbers, hasItems(3,5));
    }
    @Test
    public void itSelectsEvenAndPerfectUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1,2,3,6,8,27,28);
        List<Integer> evenPerfectNumbers = Filter.select(numbers, EVEN_PREDICATE.and(PERFECT_PREDICATE));
        assertThat(evenPerfectNumbers, hasSize(2));
        assertThat(evenPerfectNumbers, hasItems(6, 28));
    }
    @Test
    public void itSelectsEvenThatAreNotPerfectUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1,2,3,6,8,27,28);
        List<Integer> evenNotPerfectNumbers = Filter.select(numbers,EVEN_PREDICATE.and(Predicate.not(PERFECT_PREDICATE)));
        assertThat(evenNotPerfectNumbers, hasItems(2));
    }
    @Test
    public void toFindSumoftheNumbers() {
        List<Integer> numbers = Arrays.asList(5,7,10,5);
        List<Integer>  sumOfNumbers = Filter.add(numbers);
        assertThat(sumOfNumbers,hasItems(27));
    }
    @Test
    public void itSelectsNumbersWithinRange(){
        List<Integer> numbers = Arrays.asList(5,7,10,15);
        List<Integer>  numberWithinRange = Filter.range(numbers,5,10);
        assertThat(numberWithinRange, hasItems(5,7,10));
    }

}
