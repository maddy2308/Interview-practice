package vecna;

public class PrimesImprovement {
    public static void main(String[] args) {

        //This code should print out the prime numbers.
        //task: Fix and improve the algorithm

        System.out.println("Printing primes from 1 to 100");
        int i;
        int j;
        boolean prime;
        for (i = 1; i <= 100; i++) {
            prime = true;
            // the fix is to remove start from 2 instead of 1 since every number is divisible by 1
            for (j = 2; j < i; j++)
                if (i % j == 0) prime = false;
            if (prime) System.out.print(i + " ");

            // The above for loop and if condition can be removed by a single line of code(which is commented below)
            // if (isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }

    // The complexity of checking a number if, is prime, is O(Sqrt(n)).
    // So to check for n numbers it will be O(n * Sqrt (n)) which is better than the complexity of O(n^2) as suggested
    // by the initial algorithm.
    private static boolean isPrime(int number) {
        if (number > 0) {
            boolean isPrime = true;
            int sqrtOfNumber = (int) Math.sqrt(number);
            for (int j = 2; j <= sqrtOfNumber; j++) {
                if (number % j == 0) isPrime = false;
            }
            return isPrime;
        } else {
            return false;
        }
    }
}


