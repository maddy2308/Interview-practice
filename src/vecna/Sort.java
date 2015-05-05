package vecna;

public class Sort {

    public static void main(String[] args) {
        //This code will sort the numbers in the array.
        //task: Modify the algorithm to reverse the sort, then comment on its efficiency in the space
        // provided below:

        // -------------------------------------------------------------------------------------------------------------
        // By - Madhur Mehta

        // The space complexity of the below algorithm is O(N), and time complexity is O(N^2). We can do better than
        // this for time complexity by doing in O(N * LogN) by using Merge Sort or Quick Sort. ALso if we are bound
        // to use this implemented algorithm below we can save the space complexity by doing the sortin in-place and
        // not using additional array such as sorted array.
        // -------------------------------------------------------------------------------------------------------------

        int[] unsorted = new int[100];
        for (int i = 0; i < 100; i++)
            unsorted[i] = (int) (Math.random() * 100);
        System.out.println("Here are the unsorted numbers:");
        for (int i = 0; i < 100; i++) System.out.print(unsorted[i] + " ");
        System.out.println();
        int[] sorted = new int[100];
        for (int i = 0; i < 100; i++) {
            // change the hi value to be max so that we can have a lower value sorted and put in
            // correct position in sorted array
            int hi = Integer.MAX_VALUE;
            int hiIndex = -1;
            for (int j = 0; j < 100; j++) {
                // reverse the sign to check if the current hi is greater than the vaule being checked, and if so
                // make hi as this value, to find the lowest value in array.
                if (unsorted[j] < hi) {
                    hi = unsorted[j];
                    hiIndex = j;
                }
            }
            sorted[i] = hi;
            // change this value to very high value so that during comparison to find lowest,
            // these values don't change the result (kind of ignored).
            unsorted[hiIndex] = Integer.MAX_VALUE;
        }
        System.out.println("Here are the sorted numbers:");
        for (int i = 0; i < 100; i++) System.out.print(sorted[i] + " ");
        System.out.println();
    }

}

