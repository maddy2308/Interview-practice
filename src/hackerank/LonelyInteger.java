package hackerank;


import java.util.HashSet;
import java.util.Set;

public class LonelyInteger {

    public static void main(String[] args) {
        System.out.println(lonelyInteger(new int[]{1, 1, 2}));
        System.out.println(countPairs(new long[]{1, 5, 3, 4, 2}, 2));

    }

    static int lonelyInteger(int[] arr) {
        if (arr.length > 0) {
            int xor = arr[0];
            for (int i = 1; i < arr.length; i++) {
                xor ^= arr[i];
            }
            return xor;
        } else {
            return -1;
        }
    }

    private static Set<String> removeRedundantSet = new HashSet<String>();

    static int countPairs(long[] arr, int k) {
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
