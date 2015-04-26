package Utility;

public class MergeSort {

    // client
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 9, 8, 4, 0, 1};
        arr = new MergeSort().sort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private int[] sort(int[] arr) {
        return divide(0, arr.length - 1, arr);
    }

    private int[] divide(int left, int right, int[] arr) {
        //base cond.
        if (left > right || left == right) {
            int[] temp = {arr[left]};
            return temp;
        } else {
            int mid = (int) ((left + right) / 2);
            int[] leftSubArray = divide(left, mid, arr);
            int[] rightSubArray = divide(mid + 1, right, arr);
            return merge(leftSubArray, rightSubArray);
        }
    }

    private int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int leftPtr = 0, rightPtr = 0, i = 0;
        while (leftPtr < left.length && rightPtr < right.length) {
            combined[i++] = (left[leftPtr] < right[rightPtr]) ? left[leftPtr++] : right[rightPtr++];
        }
        for (; i < combined.length; ) {
            combined[i++] = (leftPtr < left.length) ? left[leftPtr++] : right[rightPtr++];
        }
        return combined;
    }

}
