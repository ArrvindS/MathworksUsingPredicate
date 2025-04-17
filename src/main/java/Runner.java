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

        System.out.println("Factorial value "+ factorial(5));
        System.out.println("Fibonaci Series for 7 is :- ");
        for(int i = 0; i < 7; i++){
            System.out.print(fibonaci(i)+ " ");
        }
        }


    private static int fibonaci(int upto) {
        if(upto <= 1)
            return upto;

        return fibonaci(upto - 1) + fibonaci(upto - 2);
    }

    private static int factorial(int number) {
        if(number == 0 || number == 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}

