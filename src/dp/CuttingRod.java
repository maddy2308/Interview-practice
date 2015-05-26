package dp;

import java.util.SortedMap;
import java.util.TreeMap;

public class CuttingRod {


    /*
        Given Rod of length L and various markings which also tell the amount of profit made if cut at that marking,
        find the max profit that could be earned.
     */

    // key represents the length of the log and the value is profit attached to that cut
    private static SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

    public static void main(String[] args) {
        map.put(1, 2);
        map.put(2, 5);
        map.put(3, 7);
        map.put(4, 8);

        System.out.println("Maximum profit possible " + getMaxProfit(5, map));
    }

    private static int getMaxProfit(int length, SortedMap<Integer, Integer> map) {
        int[][] dpArray = new int[map.size()][length + 1];
        int smallestLog = map.firstKey();
        for (int i = 1; i <= length; i++) {
            if (smallestLog <= i) {
                dpArray[0][i] = (i / smallestLog) * map.get(smallestLog);
            }
        }

        for (int row = 1; row < map.size(); row++) {
            int key = row + 1;
            int value = map.get(key);
            for (int column = 1; column <= length; column++) {
                if (key > column) {
                    dpArray[row][column] = dpArray[row - 1][column];
                } else {
                    dpArray[row][column] = Math.max(dpArray[row - 1][column], dpArray[row][column - key] + value);
                }
            }
        }

        for (int[] aDpArray : dpArray) {
            for (int j = 1; j < dpArray[0].length; j++) {
                System.out.print(aDpArray[j] + " ");
            }
            System.out.println();
        }
        return dpArray[map.size() - 1][length];
    }
}
