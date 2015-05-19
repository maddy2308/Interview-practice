package dp;

public class FlipForMax1s {

    public static void main(String[] args) {
        //new FlipForMax1s().flipOnes(new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0});
        new FlipForMax1s().flipOnes(new int[]{1, 0, 1, 0, 0, 1, 0, 1});
    }

    private void flipOnes(int[] arr) {
        int globalDiff = -1;
        int start = 0, end = 0, globalStart = 0, globalEnd = 0;
        int zeros = 0, ones = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == 0)
                zeros++;
            else
                ones++;
            if ((zeros - ones) < 0) {
                i++;
                start = i;
                end = i;
                zeros = 0;
                ones = 0;
            } else {
                i++;
                if (globalDiff < (zeros - ones)) {
                    globalStart = start;
                    globalEnd = end;
                    globalDiff = globalEnd - globalStart;
                }
                end = i;
            }
        }
        System.out.println(globalStart + " " + globalEnd);
    }
}
