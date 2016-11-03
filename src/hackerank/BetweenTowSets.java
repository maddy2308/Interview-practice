package hackerank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BetweenTowSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        BetweenTowSets obj = new BetweenTowSets();
        int lcm = 1;
        for (int anA : a) {
            lcm = obj.calculateLcm(lcm, anA);
        }
        System.out.println(lcm);
        int smallestNumber = Integer.MAX_VALUE;
        for (int number : b) {
            smallestNumber = number < smallestNumber ? number : smallestNumber;
        }
        List<Integer> list = obj.calculateCommonDivisors(b, lcm, smallestNumber);
        System.out.println(list);
    }

    /*
    ending condition is array doesnt contain any number > 1
     */
    private int calculateLcm(int a, int b) {
        int lcm = 1;
        int divisor = 2;
        while (a > 1 || b > 1) {
            boolean flag = true;
            if (a == 1 || b == 1) {
                return lcm * a * b;
            } else {
                while (flag) {
                    if ((a % divisor == 0) || (b % divisor == 0)) {
                        a = checkIfDivisible(a, divisor);
                        b = checkIfDivisible(b, divisor);
                        lcm *= divisor;
                        flag = true;
                    } else {
                        flag = false;
                        divisor++;
                    }
                }
            }
        }
        return lcm;
    }

    private List<Integer> calculateCommonDivisors(int[] b, int lcm, int smallestNumber) {
        List<Integer> divisorLists = new ArrayList<Integer>();
        int divisor = lcm;
        for (int j = 1; divisor <= smallestNumber; ++j, divisor = lcm * j) {
            boolean flag = false;
            for (int aB : b) {
                if (aB % divisor != 0) {
                    divisor = smallestNumber + 1;
                    flag = true;
                }
            }
            if (!flag) {
                divisorLists.add(divisor);
            }
        }
        return divisorLists;
    }

    private int checkIfDivisible(int number, int divisor) {
        if (number % divisor == 0) {
            number /= divisor;
        }
        return number;
    }
}
