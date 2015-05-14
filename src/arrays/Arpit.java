package arrays;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

import java.util.Arrays;

class Arpit {
    public static void main(String[] args) {
        // Test case 1: input array provided in the question
        int[] array1 = {0, 0, 0, 0, 0};
        int[] maximumSumSubArray = maxSumSubArray(array1);
        System.out.print("Input array: ");
        printArray(array1);
        System.out.print("Maximum sum sub array: ");
        printArray(maximumSumSubArray);
        System.out.println();

        // Test case 2: All negative integers
        int[] array2 = {-9, -8, -7, -6, -5, -4, -3, -2, -1};
        maximumSumSubArray = maxSumSubArray(array2);
        System.out.print("Input array: ");
        printArray(array2);
        System.out.print("Maximum sum sub array: ");
        printArray(maximumSumSubArray);
        System.out.println();

        // Test case 2: All positive integers
        int[] array3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        maximumSumSubArray = maxSumSubArray(array3);
        System.out.print("Input array: ");
        printArray(array3);
        System.out.print("Maximum sum sub array: ");
        printArray(maximumSumSubArray);
        System.out.println();

        // Test case 2:
        int[] array4 = {-1, 2, -3, 4, -5, 6, -7, 8, -9, 0, -101, 102, 11, 99,
                111, -111, 112, -11, -99, 12, 100};
        maximumSumSubArray = maxSumSubArray(array4);
        System.out.print("Input array: ");
        printArray(array4);
        System.out.print("Maximum sum sub array: ");
        printArray(maximumSumSubArray);
        System.out.println();
    }

    // Function returns the maximum sum sub array.
    private static int[] maxSumSubArray(int[] array) {
        int startIndex = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            currSum += array[i];

            if (currSum >= maxSum) {
                maxSum = currSum;
                maxStartIndex = startIndex;
                maxEndIndex = i;
            } else if (currSum < 0) {
                currSum = 0;
                startIndex = i + 1;
            }
        }

        // Return the sub array
        return (Arrays.copyOfRange(array, maxStartIndex, maxEndIndex + 1));
    }

    // Function prints the input parameter integer array.
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
