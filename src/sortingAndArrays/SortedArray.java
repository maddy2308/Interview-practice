package sortingAndArrays;

/**
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
 * Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any
 * occurrence. If it isn’t present, return -1.
 */
public class SortedArray {

    private int[] array;
    private int keyToSearch;

    public SortedArray(int[] array, int keyToSearch) {
        this.array = array;
        this.keyToSearch = keyToSearch;
    }

    public static void main(String[] args){
        SortedArray obj = new SortedArray((new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), 7);
        System.out.println(obj.find(0, 0));
    }

    private int find(int startIndex, int start){
        try {
            if (array[startIndex + start] == keyToSearch){
                return start + startIndex;
            } else {
                if (array[startIndex + start] > keyToSearch){
                    // do binary search
                    return findKey(startIndex + start/2, startIndex + start);
                } else {
                    // recurse again
                    return start > 0 ?
                            find(startIndex, start *2) :
                            find(startIndex, ++start);
                }
            }
        } catch(IndexOutOfBoundsException ibe){
            // do something when idex goes out of bounds
            return start == 0 ? -1 : find(start/2, 0);
        }
    }

    // binary search logic
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
