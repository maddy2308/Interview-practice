package arrays;

import java.util.Arrays;

public class HighestProduct {


    /*
        Given an array_of_ints, find the highest_product you can get from three of the integers. The input
        array_of_ints will always have at least three integers.
     */

    public static void main(String[] args) {
        //System.out.println(getMaximumProduct(new int[]{-10, 3, 4, 50, 20, -15}));
        System.out.println(getMaximumProduct(new int[]{-10, -10, 1, 3, 2}));
    }

    // arr = {-10, 3, 4, 50, 20, -15}
    // sortedArray = {-15, -10, 3, 4, 20, 50}
    // all negative elements

    // O(NLogN)
    private static int getMaximumProduct(int[] arr) {
        int negativeMax = 0;
        int positiveMax;
        Arrays.sort(arr);
        if (arr[0] < 0 && arr[1] < 0) {
            int size = arr.length;
            negativeMax = arr[0] * arr[1] * arr[size - 1];
        }
        int size = arr.length - 1;
        positiveMax = arr[size - 3] * arr[size - 2] * arr[size - 1];
        return positiveMax > negativeMax ? positiveMax : negativeMax;
    }

    // arr = {-10, 3, 4, 50, 20, -15}  =>
    // 7500
    // arr = {-10, -10, 1, 3, 2} => 300

    /*
            1 => -120
            2 => 600
            3 => 4000
            4 => -15000
            5 => 150000/20 = 7500

     */
    private static int getMaximumProduct2(int[] arr) {

        return 0;
    }

}
