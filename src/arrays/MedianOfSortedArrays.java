package arrays;

import java.util.Arrays;

public class MedianOfSortedArrays {


    private static int[] arr1 = {1, 2, 4, 13, 23, 26, 34};
    private static int[] arr2 = {7, 9, 11, 17, 28, 35};

    /*private static int[] arr1 = {1, 12, 15, 26, 38};
    private static int[] arr2 = {2, 13, 17, 30, 45};*/

    public static void main(String[] args) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        Arrays.sort(mergedArray);
        System.out.println(Arrays.toString(mergedArray));

        System.out.println(recurse(0, arr1.length - 1, 0, arr2.length - 1));
    }

    private static int recurse(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int m1 = (leftStart + leftEnd) / 2;
        int m2 = (rightStart + rightEnd) / 2;
        int mid1 = arr1[m1];
        int mid2 = arr2[m2];
        if (mid1 == mid2) {
            return mid1;
        } else if (Math.abs(leftStart - leftEnd) < 2 && Math.abs(rightStart - rightEnd) < 2) {
            int maxSum = Math.max(arr1[leftStart], arr2[rightStart]) + Math.min(arr1[leftEnd], arr2[rightEnd]);
            return maxSum / 2;
        } else {
            if (mid1 > mid2) {
                return recurse(leftStart, m1, m2, rightEnd);
            } else {
                return recurse(m1, leftEnd, rightStart, m2);
            }
        }
    }
}
