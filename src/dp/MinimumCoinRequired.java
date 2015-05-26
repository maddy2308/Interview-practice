package dp;

public class MinimumCoinRequired {

    public static void main(String[] args) {
        printDpArray(getCoinsRequired(11, new int[]{1, 5, 6, 8}));
    }

    private static void printDpArray(int[][] dpArray) {
        for (int[] aDpArray : dpArray) {
            for (int j = 1; j < dpArray[0].length; j++) {
                System.out.print(aDpArray[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getCoinsRequired(int sum, int[] coins) {
        int[][] dpArray = new int[coins.length][sum + 1];
        for (int column = 1; column < dpArray[0].length; column++) {
            dpArray[0][column] = (column >= coins[0]) ? (column / coins[0]) : 0;
        }

        for (int row = 1; row < coins.length; row++) {
            int leftShift = coins[row];
            for (int column = 1; column < dpArray[0].length; column++) {
                if (column >= coins[row]) {
                    dpArray[row][column] = Math.min(dpArray[row - 1][column], dpArray[row][column - leftShift] + 1);
                } else {
                    dpArray[row][column] = dpArray[row - 1][column];
                }
            }
        }
        return dpArray;
    }

}
