import org.agileindia.mathworks.Numbers;
import org.agileindia.mathworks.Predicates;

public class Runner {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(1,2,3,4,5,6,7,8,9,10);

        int sum = numbers.select(Predicates.EVEN) //2, 4, 6, 8, 10
                .inBetween(1, 7) // 2, 4, 6
                .times(2) // 4, 8, 12
                .count(); // 3
//                .product(); // 384
//                .sum(); // 24

        System.out.println("sum = " + sum);
    }
}

