package recurssion;

public class Problem1 {

    static int[] a;

    public static void main(String[] args) {
        int stairs = 37;
        a = new int[stairs];
        new Problem1().findNumberOfWays(stairs);
        System.out.println(a[stairs - 1]);
    }

    int findNumberOfWays(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (a[n - 1] > 0)
            return a[n - 1];
        a[n - 1] = findNumberOfWays(n - 1) + findNumberOfWays(n - 2) + findNumberOfWays(n - 3);
        return a[n - 1];
    }
}
