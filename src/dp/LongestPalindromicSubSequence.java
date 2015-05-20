package dp;

public class LongestPalindromicSubSequence {

    private void fillDpArray(String str) {
        int[][] dpArray = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dpArray[i][i] = 1;
        }

        for (int i = 1; i < str.length(); i++) {
            for (int j = 0, k = i; j < str.length() - i; j++, k++) {
                if (str.charAt(k) == str.charAt(j)) {
                    dpArray[j][k] = 2 + dpArray[j + 1][k - 1];
                } else {
                    dpArray[j][k] = Math.max(dpArray[j + 1][k], dpArray[j][k - 1]);
                }
            }
        }

        for (int[] aDpArray : dpArray) {
            for (int j = 0; j < dpArray[0].length; j++) {
                System.out.print(aDpArray[j] + " ");
            }
            System.out.println();
        }
    }

    // driver method
    public static void main(String[] args) {
        LongestPalindromicSubSequence obj = new LongestPalindromicSubSequence();
        obj.fillDpArray("agbdba");
    }
}
