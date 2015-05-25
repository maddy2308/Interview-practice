package practiceProblems;


import java.io.IOException;

public class Solution {


    static int maxThreats(int[] a) {
        int globalMax = 0;
        for (int i = 0; i < a.length; i++) {
            int max = getThreatStatus(a, a[i], i + 1);
            //System.out.print(max);
            globalMax = max > globalMax ? max : globalMax;
        }
        return globalMax;
    }

    // since the question says that there will be all unique values in the array so I don't have to check for
    // vertical or horizontal threats. I should only check for the diagonal threats
    // column and row are 1 based index
    private static int getThreatStatus(int[] a, int column, int row) {
        int threats = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != row - 1) {
                if (Math.abs(column - a[i]) == Math.abs(row - (i + 1)) && isNotJumping(a, row, i + 1)) {
                    threats++;
                }
                // System.out.print(threats);
            }
        }
        return threats;
    }


    private static boolean isNotJumping(int[] arr, int currentRow, int checkRow) {
        boolean top = false, left = false;
        if (currentRow > checkRow) top = true;
        if (arr[currentRow - 1] > arr[checkRow - 1]) left = true;

        if (top && left) {
            if ((currentRow - checkRow >= 2) && (arr[checkRow] == arr[checkRow - 1] + 1))
                return false;
        } else if (top && !left) {
            if ((currentRow - checkRow >= 2) && (arr[checkRow] + 1 == arr[checkRow - 1]))
                return false;
        } else if (!top && left) {
            if ((checkRow - currentRow >= 2) && (arr[checkRow - 1] + 1 == arr[checkRow - 2]))
                return false;
        } else {
            if ((checkRow - currentRow >= 2) && (arr[checkRow - 1] - 1 == arr[checkRow - 2]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(maxThreats(new int[]{2, 1, 3}));
    }
}
