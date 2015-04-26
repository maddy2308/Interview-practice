package sortingAndArrays;


public class SortedRotatedArray {

    private int[] array = {3, 4, 5, 6, 7, 1, 2};
    private int keyToSearch;
    public static void main(String[] args){
        SortedRotatedArray object = new SortedRotatedArray(4);
        int first = 0;
        int last = object.array.length - 1;
        int pivot = object.findPivot(first, last);
        int keyIndex = object.findKey(first, pivot, last);
        System.out.println(keyIndex);
    }

    public SortedRotatedArray(int keyToSearch) {
        this.keyToSearch = keyToSearch;
    }

    private int findKey(int first, int pivot, int last) {
        if (array[pivot] == keyToSearch) return pivot;
        else if (array[first] <= keyToSearch && keyToSearch < array[pivot]){
            return findKey(first, pivot);
        } else {
            return findKey(pivot + 1, last);
        }
    }

    // assuming the array is sorted in ascending manner
    public int findPivot(int first, int last){
        int mid = (first + last)/2;
        if (array[first] > array[last]){
            // array is rotated
            if (array[mid] > array[last]){
                return findPivot(mid+1, last);
            }
        }
        return first;
    }

    private int findKey(int first, int last){
        int mid = (first + last)/2;
        if (first > last){
            return -1;
        }
        else if ((first == last) || (array[mid] == keyToSearch))
            return mid;
        else if (array[mid] > keyToSearch){
            return findKey(first, mid - 1);
        }else {
            return findKey(mid + 1, last);
        }
    }
}
