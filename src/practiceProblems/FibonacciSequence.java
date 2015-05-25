package practiceProblems;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FibonacciSequence {

    // Using Golden Ratio to calculate the Fibonacci Sequence
    private static BigInteger getFibonacciNumber(int n) {
        double goldenRatio = 1.61815754;
        BigDecimal number = new BigDecimal((Math.pow(goldenRatio, n) - Math.pow((1 - goldenRatio), n)) / Math.sqrt(5));
        return number.toBigInteger();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getFibonacciNumber(i) + " ");
        }
    }

}
