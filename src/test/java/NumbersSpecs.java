import org.agileindia.mathworks.Numbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.agileindia.mathworks.Predicates.*;
import static org.hamcrest.Matchers.*;

public class NumbersSpecs {
    @Test
    public void itSelectsPerfectNumbersUsingPredicate() {
        //Given
        Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6, 10, 28);
        //When
        Numbers perfect= numbers.select(PERFECT_PREDICATE);

        //Then
        assertThat(perfect.size(), equalTo(2));
        assertThat(perfect.hasItems(6, 28),is(true));
    }
    @Test
    public void itSelectsEvenNumberUsingPredicate() {

        Numbers numbers = new Numbers(1, 2, 3, 4);


        Numbers even = numbers.select(EVEN_PREDICATE);

        assertThat(even.hasItems(2, 4),is(true));

    }
    @Test
    public void itSelectsOddNumberUsingPredicate() {

        Numbers numbers = new Numbers(1, 2, 3, 4);

        Numbers odd = numbers.select(ODD_PREDICATE);

        assertThat(odd.hasItems(1, 3),is(true));

    }
    @Test
    public void itSelectsPrimeNumberUsingPredicate() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> evenNumbers = Numbers.select(numbers, PRIME_PREDICATE);

        assertThat(evenNumbers, hasItems(2,3));

    }
    @Test
    public void itSelectsOddOrPrimeUsingPredicate() {

        Numbers numbers = new Numbers(1,2,3,4,5);

        Numbers oddOrPrime = numbers.select(ODD_PREDICATE.or(PRIME_PREDICATE));


        assertThat(oddOrPrime.hasItems(3,5),is(true));
    }
    @Test
    public void itSelectsEvenAndPerfectUsingPredicate() {

        Numbers numbers = new Numbers(1,2,3,6,8,27,28);

        Numbers evenAndPerfect = numbers.select(EVEN_PREDICATE.and(PERFECT_PREDICATE));

        assertThat(evenAndPerfect.size(), equalTo(2));

        assertThat(evenAndPerfect.hasItems(6, 28),is(true));
    }
    @Test
    public void itSelectsEvenThatAreNotPerfectUsingPredicate() {

        Numbers numbers = new Numbers(1,2,3,6,8,27,28);

        Numbers evenNotPerfect = numbers.select(EVEN_PREDICATE.and(Predicate.not(PERFECT_PREDICATE)));

        assertThat(evenNotPerfect.hasItems(2),is(true));
    }
    @Test
    public void toFindSumoftheNumbers() {

        Numbers numbers = new Numbers(5,7,10,5);

        int  sumOfNumbers = numbers.sum();

        assertThat(sumOfNumbers,equalTo(27));
    }
    @Test
    public void itSelectsNumbersWithinInRange(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers  numberWithinRange = numbers.inRange(5,10);

        assertThat(numberWithinRange.hasItems(5,7,10),is(true));
    }
    @Test
    public void toLearnMultiplicationOfNumbers(){

        Numbers numbers = new Numbers(5,7,10,5);

        int multiplicationValue = numbers.multiplication();

        assertThat(multiplicationValue,equalTo(1750));
    }
    @Test
    public void toLearnMultiplicationWithFactorForNumbers(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers multipliedList = numbers.multiplicationWithFactor(10);

        assertThat(multipliedList.hasItems(50,70,100,150),is(true));
    }}
