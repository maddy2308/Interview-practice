package interviewlikecond;

import java.util.Scanner;

public class Solution {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        System.out.println(s.split("[A-Z]").length);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String s = in.next();
            System.out.println(calculateCost(s));
        }
    }

    private static int calculateCost(String s) {
        StringBuilder p = new StringBuilder();
        int dollarCost = 0;
        for (int index = 0; index < s.length(); ) {
            boolean foundFlag = false;
            String subString = s.substring(index);
            for (int j = subString.length(); j >= 0; j--) {
                String match = subString.substring(0, j);
                if (match.length() > 0 && p.indexOf(match) >= 0) {
                    p.append(match);
                    foundFlag = true;
                    index += match.length();
                }
            }
            if (!foundFlag) {
                p.append(s.charAt(index));
                dollarCost++;
                index++;
            }
        }
        return dollarCost;
    }
}

// abcdabde --> 5