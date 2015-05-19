package arrays;


public class ArrayMisc {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(binarySearch(0, arr.length - 1, arr, 1));
        System.out.println(findFirstIndex(arr, 1));
    }


    /*
     * In a matrix of only 0’s and 1’s, where in each row, there are only 0’s first and then 1’s,
     * find the row with maximum number of 1’s. [Start with right top corner O(m+n) ] [With Code]
     */
    public static int findFirstIndex(int[] arr, int number) {
        int firstIndexFound = -1, globalFirstIndex = -1;
        int last = arr.length - 1;
        do {
            globalFirstIndex = firstIndexFound;
            firstIndexFound = binarySearch(0, last, arr, number);
            last = firstIndexFound - 1;
        } while (firstIndexFound != -1);

        return globalFirstIndex;
    }

    /*
    * Binary search
    */
    private static int binarySearch(int first, int last, int[] arr, int number) {
        if (first > last) {
            return -1;
        }
        if (arr[first] > number) {
            return -1;
        } else if (arr[last] < number) {
            return -1;
        } else if (arr[first] == number) {
            return first;
        }

        int mid = (first + last) / 2;
        if (arr[mid] == number) {
            return mid;
        } else if (arr[mid] > number) {
            return binarySearch(first, mid - 1, arr, number);
        } else {
            return binarySearch(mid + 1, last, arr, number);
        }
    }


}
