package arrays;

public class RemoveElementsThatRepeat {

    public static void main(String[] args) {
        smoosh(new int[]{0, 0, 0, 0, 1, 1, 0, 0, 0, 3, 3, 3, 1, 1, 0});
    }

    /**
     * smoosh() takes an array of ints.  On completion the array contains
     * the same numbers, but wherever the array had two or more consecutive
     * duplicate numbers, they are replaced by one copy of the number.  Hence,
     * after smoosh() is done, no two consecutive numbers in the array are the
     * same.
     * <p/>
     * Any unused elements at the end of the array are set to -1.
     * <p/>
     * For example, if the input array is [ 0 0 0 0 1 1 0 0 0 3 3 3 1 1 0 ],
     * it reads [ 0 1 0 3 1 0 -1 -1 -1 -1 -1 -1 -1 -1 -1 ] after smoosh()
     * completes.
     *
     * @param ints the input array.
     */

    public static void smoosh(int[] ints) {
        // Fill in your solution here.  (Ours is fourteen lines long, not counting
        // blank lines or lines already present in this file.)
        int numberRepeating = ints[0], unique = 1;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == numberRepeating) {
                ints[i] = -1;
            } else {
                numberRepeating = ints[i];
                unique++;
            }
        }

        for (int i = 1, j = 1; i < ints.length; i++) {
            if (j == unique) break;
            if (ints[i] != -1) {
                ints[j++] = ints[i];
            }
        }

        for (int i = unique; i < ints.length; i++) {
            ints[i] = -1;
        }
    }
}
