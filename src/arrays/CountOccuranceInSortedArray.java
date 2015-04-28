package arrays;

public class CountOccuranceInSortedArray {

    private static int[] array = new int[]{1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7};
    private static int size = array.length;

    public static void main(String[] args) {
        CountOccuranceInSortedArray obj = new CountOccuranceInSortedArray();
        int high = obj.binarySearchForLastOccurrence(0, size - 1, 2);
        int low  = obj.binarySearchForFirstOccurrence(0, size - 1, 2);
        System.out.println(high - low + 1);
    }

    public int binarySearchForFirstOccurrence(int first, int last, int keyToSearch) {
        if (first > last)
            return -1;
        else {
            int mid = (first + last) / 2;
            if ((mid == 0 || array[mid - 1] < keyToSearch) && (array[mid] == keyToSearch)) {
                return mid;
            } else {
                return (array[mid] < keyToSearch) ?
                        binarySearchForFirstOccurrence(mid + 1, last, keyToSearch) :
                        binarySearchForFirstOccurrence(first, mid-1, keyToSearch);
            }
        }
    }

    public int binarySearchForLastOccurrence(int low, int high, int number) {
        int mid = 0;
        // loop till the condition is true
        while (low <= high) {
            // divide the array for search
            mid = (low + high) / 2;
            if (array[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
