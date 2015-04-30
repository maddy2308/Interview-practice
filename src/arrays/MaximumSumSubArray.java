package arrays;

import java.util.Arrays;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] maxArray = new MaximumSumSubArray().getMaximumSum(new int[]{-10, 4, 2, -9, 4, -9, 9, -6, 4, 4});
        for (int num : maxArray){
            System.out.print(num + ", ");
        }
    }

    private int[] getMaximumSum(int[] numbers) {
        int startIndex = 0, endIndex = 0, maxStartIndex = 0, maxEndIndex = 0;
        int maxSum = Integer.MIN_VALUE, currentSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (currentSum > 0 && currentSum + numbers[i] > 0) {
                currentSum += numbers[i];
                endIndex = i;
            } else {
                currentSum = numbers[i];
                startIndex = i;
                endIndex = i;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStartIndex = startIndex;
                maxEndIndex = endIndex;
            }
        }
        return Arrays.copyOfRange(numbers, maxStartIndex, maxEndIndex + 1);
    }

}
