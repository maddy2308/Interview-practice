package dp;


import java.util.Arrays;

public class NumberOfWaysToGetSum {


    /*
        Number of ways to get a total based on the coins available
     */

    private static int[][] getWays(int sum, int[] coins) {
        Arrays.sort(coins);
        int[][] dpArray = new int[coins.length][sum + 1];

        // creating 1st Row with min coin denomination
        for (int column = 1; column < dpArray[0].length; column++) {
            dpArray[0][column] = (column % coins[0] == 0) ? 1 : 0;
        }

        for (int row = 1; row < coins.length; row++) {
            for (int column = 0; column < dpArray[0].length; column++) {
                int coin = coins[row];
                if (column == 0) {
                    dpArray[row][column] = 1;
                } else {
                    if (coin > column) {
                        dpArray[row][column] = dpArray[row - 1][column];
                    } else {
                        dpArray[row][column] = dpArray[row - 1][column] + dpArray[row][column - coin];
                    }
                }
            }
        }
        return dpArray;
    }

    private static void printDpArray(int[][] dpArray) {
        for (int[] aDpArray : dpArray) {
            for (int j = 1; j < dpArray[0].length; j++) {
                System.out.print(aDpArray[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDpArray(getWays(8, new int[]{3, 1, 2}));
    }

}
