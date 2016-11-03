package google_fb_yahoo;

import java.util.HashSet;
import java.util.Set;

public class AlmostSorted {

    private Set<Integer> inversionIndex = new HashSet<Integer>();

    // assuming the arr is almost sorted in ascending order
    private void findInversions(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (inversionIndex.contains(j)) {
                    continue;
                } else if (arr[i] < arr[j]) {
                    inversionIndex.add(i);
                }
                break;
            }
        }
    }

    private boolean isAlmostSorted(int[] arr) {
        findInversions(arr);
        return inversionIndex.size() <= 1;
    }

    public static void main(String[] args) {
        AlmostSorted as = new AlmostSorted();
        System.out.println(as.isAlmostSorted(new int[]{7, 3, 9, 5}));
        System.out.println(as.inversionIndex.size());
        //System.out.println(as.isAlmostSorted(new int[] {1, 2, 8, 10, 4}));
    }
}
