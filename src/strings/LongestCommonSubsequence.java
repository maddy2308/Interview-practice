package strings;


public class LongestCommonSubsequence {

    int[][] lcsArray;
    int length = -1;
    String lcs;

    /* Driver program to test above function */
    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        obj.lcs("abcdaf", "acbcf");
        System.out.println("The lowest common substring is of length " + obj.length + " and it is " + obj.lcs);
    }

    private void lcs(String x, String y) {
        StringBuilder sbx = new StringBuilder(x.toLowerCase());
        StringBuilder sby = new StringBuilder(y.toLowerCase());
        String str = sbx.reverse() + " ";
        sbx = new StringBuilder(str).reverse();
        str = sby.reverse() + " ";
        sby = new StringBuilder(str).reverse();
        lcsHelper(sbx.toString(), sby.toString());
        backtrackToGetLCS(sbx.toString());
    }

    private void lcsHelper(String x, String y) {
        int m = x.length();
        int n = y.length();
        lcsArray = new int[m][n];

        for (int i = 1; i < x.length(); i++) {
            for (int j = 1; j < y.length(); j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    lcsArray[i][j] = lcsArray[i - 1][j - 1] + 1;
                } else {
                    lcsArray[i][j] = Math.max(lcsArray[i - 1][j], lcsArray[i][j - 1]);
                }
            }
        }
        length = lcsArray[m - 1][n - 1];
    }

    private void backtrackToGetLCS(String x) {
        StringBuilder sb = new StringBuilder();
        int i = lcsArray.length - 1, j = lcsArray[0].length - 1;
        while (i > 0 && j > 0) {
            int value = lcsArray[i][j];
            if (lcsArray[i - 1][j - 1] + 1 == value) {
                sb.append(x.charAt(i));
                 i--; j--;
            } else {
                if (lcsArray[i-1][j] == value){
                    i--;
                } else {
                    j--;
                }
            }
        }
        lcs = sb.reverse().toString();
    }
}
