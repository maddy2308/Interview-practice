package arrays;

public class StockBuySell {


    /*
        The cost of a stock on each day is given in an array, find the max profit that you can make by buying and
        selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum
        profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given
        array of prices is sorted in decreasing order, then profit cannot be earned at all.
    */

    public static void main(String[] args) {
        System.out.println(getMaxProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
    }

    private static int getMaxProfit(int[] arr) {
        // O(n^2) algorithm is to take one element and see if we can replace the previously found max with elements
        // ahead of it.
        int minELement = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for (int number : arr) {
            if (number < minELement) {
                minELement = number;
            } else {
                if (number - minELement > maxDiff) {
                    maxDiff = number - minELement;
                }
            }
        }
        return maxDiff;
    }
}
