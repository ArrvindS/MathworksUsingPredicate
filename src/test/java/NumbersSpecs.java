import org.agileindia.mathworks.Numbers;
import org.junit.jupiter.api.Test;

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


        Numbers even = numbers.select(EVEN);

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

        Numbers numbers = new Numbers(1, 2, 3, 4);

        Numbers evens = numbers.select(PRIME_PREDICATE);

        assertThat(evens.hasItems(2, 3), is(true));
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

        Numbers evenAndPerfect = numbers.select(EVEN.and(PERFECT_PREDICATE));

        assertThat(evenAndPerfect.size(), equalTo(2));

        assertThat(evenAndPerfect.hasItems(6, 28),is(true));
    }
    @Test
    public void itSelectsEvenThatAreNotPerfectUsingPredicate() {

        Numbers numbers = new Numbers(1,2,3,6,8,27,28);

        Numbers evenNotPerfect = numbers.select(EVEN.and(Predicate.not(PERFECT_PREDICATE)));

        assertThat(evenNotPerfect.hasItems(2),is(true));
    }
    @Test
    public void toFindSumoftheNumbers() {

        Numbers numbers = new Numbers(5,7,10,5);

        int  sumOfNumbers = numbers.sum();

        assertThat(sumOfNumbers,equalTo(27));
    }
    @Test
    public void itSelectsNumbersWithinInIsInBetween(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers  numberWithinRange = numbers.inBetween(5,10);

        assertThat(numberWithinRange.hasItems(5,7,10),is(true));
    }
    @Test
    public void toLearnProductOfNumbers(){

        Numbers numbers = new Numbers(5,7,10,5);

        int multiplicationValue = numbers.product();

        assertThat(multiplicationValue,equalTo(1750));
    }
    @Test
    public void toMultiplyEachNumberByAFactor(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers multipliedList = numbers.times(10);

        assertThat(multipliedList.hasItems(50,70,100,150),is(true));
    }

    @Test
    public void toCountNumbers(){

        Numbers numbers = new Numbers(1,2,3,4,5);

        int count = numbers.count();

        assertThat(count,equalTo(5));

    }

    @Test
    public void toLearnSquaresOfGivenNumbers(){

        Numbers numbers = new Numbers(1,2,3,5);

        Numbers squares = numbers.square();

        assertThat(squares.hasItems(1,4,9,25),is(true));
    }

    @Test
    public void toLearnFirstOccurrencePosition(){

        Numbers numbers = new Numbers(3,1,2,1,5);

        int firstOccurrence = numbers.findFirstOccurance(2);

        assertThat(firstOccurrence,equalTo(3));
    }

    @Test
    public void toLearnFirstOccurrencePosition_2(){

        Numbers numbers = new Numbers(3,1,2,1,5);

        int firstOccurrence = numbers.findFirstOccurance(10);

        assertThat(firstOccurrence,equalTo(-1));
    }


}
