package practiceProblems;

import java.util.BitSet;

public class FindingPrimes {
    public static void main(String[] args) {
        findPrimes(100001);
    }

    private static void findPrimes(int n) {
        BitSet primes = new BitSet(n + 1);

        // turn all even numbers except 2 as composites
        for (int i = 4; i <= n; i += 2) {
            primes.set(i);
        }

        for (int i = 3; i <= n; i++) {
            long square = i * i;
            if (square < primes.size()) {
                int sq = (int) square;
                if (!primes.get(i)) {
                    for (int j = 0; j <= n / 3; j++) {
                        long k = sq + i * j;
                        if (k >= 0)
                            primes.set((int) k);
                    }
                }
            }
        }
        for (int i = n; i >= 1; i--)
            if (!primes.get(i)) {
                System.out.print(i);
                break;
            }
    }
}
