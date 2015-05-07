package arrays;

import java.util.Arrays;
import java.util.Random;

public class UnknownLengthSortedArray {

    public static void main(String[] args) {
        int randLength = (int) (Math.random() * 100);
        int[] arr = new int[randLength];
        int element = -1;
        Random generator = new Random();
        for (int i = 0; i < randLength; i++) {
            arr[i] = generator.nextInt(300);
            element = arr[i];
        }
        Arrays.sort(arr);
        UnknownLengthSortedArray obj = new UnknownLengthSortedArray();
        int index = obj.traverseArray(arr, 0, element);
        assert (element == arr[index]);
    }

    private int traverseArray(int arr[], int current, int element) {
        int index = -1, previous = 0, i = 0;
        boolean flag = true;
        while (flag) {
            if (current > arr.length) {
                i = 0;
                current = previous;
            } else {
                if (arr[current] == element) {
                    flag = false;
                    index = current;
                } else if (arr[current] > element) {
                    index = binarySearch(previous, current, element, arr);
                    flag = false;
                } else if (arr[current] < element) {
                    i = i * 2 + 1;
                    previous = current;
                    current = current + i;
                }
            }
        }
        return index;
    }

    private int binarySearch(int first, int last, int element, int[] arr) {
        int mid = (first + last) / 2;
        // base condition
        if (first > last) {
            return -1;
        } else {
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                return binarySearch(first, mid - 1, element, arr);
            } else {
                return binarySearch(mid + 1, last, element, arr);
            }
        }
    }
}
