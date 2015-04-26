package sortingAndArrays;

import java.util.Arrays;

/**
 * Find Next Higher Number With Same Digits
 */
public class NextHigherNumber {

    public static void main(String[] args){
        System.out.println(new NextHigherNumber().findNumber("12543265"));
    }

    private String findNumber(String number) {
        char[] arr = number.toCharArray();
        int pivot = -1;
        int digitAtPivot = -1;
        int currentDigit = -1;
        for (int index = arr.length - 2; index >= 0; index--) {
            currentDigit = Integer.parseInt(arr[index] + "");
            int digitNextToCurrent = Integer.parseInt(arr[index+1] + "");
            if (currentDigit < digitNextToCurrent){
                pivot = index;
                break;
            }
        }
        if (pivot >= 0) {
            digitAtPivot = Integer.parseInt(arr[pivot] + "");

            int nextMin = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int index = pivot + 1; index < arr.length; index++) {
                currentDigit = Integer.parseInt(arr[index] + "");
                if (currentDigit > digitAtPivot && currentDigit < nextMin) {
                    nextMin = currentDigit;
                    minIndex = index;
                }
            }
            arr[pivot] = (char) (nextMin + 48);
            arr[minIndex] = (char) (digitAtPivot + 48);
        }
        return Arrays.toString(arr);
    }

}
