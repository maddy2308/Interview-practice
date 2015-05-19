package recurssion;


public class MagicIndex {

    public static void main(String[] args) {

        int[] arr = {-5, -2, 0, 1, 3, 4, 6};
        int[] arr2 = {0, 1, 4, 5, 9, 15, 18};
        int[] arr3 = {-40, -20, 2, 2, 2, 3, 5, 6, 9, 12, 13};
        System.out.println(findMagicIndex(arr3, 0, arr3.length - 1));
    }

    private static int findMagicIndex(int[] arr, int first, int last) {
        int mid = (first + last) / 2;
        if (first > last) {
            return -1;
        }

        if (arr[mid] == mid) {
            return mid;
        } else {
            if (arr[mid] > mid) {
                return findMagicIndex(arr, first, mid - 1);
            } else {
                return findMagicIndex(arr, mid + 1, last);
            }
        }
    }
}
