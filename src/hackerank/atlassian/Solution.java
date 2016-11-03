package hackerank.atlassian;

public class Solution {
    private static StringBuilder result;

    static String LookAndSay(String start, int n) {
        for (int i = 0; i < n; i++) {
            result = new StringBuilder();
            start = helper(start, "", 0).toString();
        }
        return start;
    }

    static StringBuilder helper(String main, String rem, int count) {
        if (rem == null) {
            return result.append(count).append(main.charAt(0)).append("");
        } else if (rem.equals("")) {
            if (main.length() > 1) {
                return helper(main.charAt(0) + "", main.substring(1), 1);
            } else {
                return helper(main.charAt(0) + "", null, 1);
            }
        } else if (!rem.equals("") && main.charAt(0) == rem.charAt(0)) {
            if (rem.length() > 1) {
                return helper(rem.charAt(0) + "", rem.substring(1), count + 1);
            } else {
                return helper(rem.charAt(0) + "", null, count + 1);
            }
        } else {
            result.append(count).append(main.charAt(0)).append("");
            if (rem.length() > 1) {
                return helper(rem.charAt(0) + "", rem.substring(1), 1);
            } else {
                return helper(rem.charAt(0) + "", null, 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(LookAndSay("1", 5));
//        result = new StringBuilder();
//        System.out.println(helper("111221", "", 0));
    }
}
