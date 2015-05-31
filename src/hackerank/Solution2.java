package hackerank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(countPairs(arr, k));
    }

    static int countPairs(long[] arr, long k) {
        int count = 0;
        Set<Long> set = new HashSet<Long>(arr.length);
        for (long number : arr) {
            set.add(number);
        }
        for (long number : arr) {
            if (set.contains(number - k)) {
                count++;
            }
        }
        return count;
    }
}
