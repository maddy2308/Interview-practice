package arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.getLongestIncreasingSubSequence(new int[]{2, 6, 4, 5, 1, 3}));
    }

    // L[i] = MAX (L[j] | j < i, arr[j] < arr[i]) + arr[i]
    private String getLongestIncreasingSubSequence(int[] arr) {

        StringBuilder[] sb = new StringBuilder[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sb[i] = new StringBuilder(arr[i] + ",");
        }

        for (int i = 0; i < arr.length; i++) {
            int maxLength = Integer.MIN_VALUE;
            int stackToChoose = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int length = sb[j].toString().split(",").length;
                    if (maxLength < length) {
                        stackToChoose = j;
                        maxLength = length;
                    }
                }
            }
            if (stackToChoose >= 0) {
                //reverse list to be choosen
                sb[i].append(sb[stackToChoose]);
            }
        }
        int maxLength = Integer.MIN_VALUE;
        int indexToReturn = -1;
        for (int i = 0; i < arr.length; i++) {
            int length = sb[i].toString().split(",").length;
            if (maxLength < length){
                maxLength = length;
                indexToReturn = i;
            }
        }
        return indexToReturn >= 0 ? sb[indexToReturn].toString() : "";
    }
}
