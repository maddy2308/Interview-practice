package practiceProblems;

public class Palindrome {
    public static void main(String[] args) {
        int N = 12345;
        System.out.println(getNextPalindrome(N + ""));
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder(str);
        int strLength = sb.length();
        if (sb.charAt(0) == sb.charAt(strLength - 1)) {
            sb.deleteCharAt(strLength - 1);
            sb.deleteCharAt(0);
            return isPalindrome(sb.toString());
        }
        return false;
    }

    private static int digit, carry = 0;

    private static String getNextPalindrome(String str) {
        int length = str.length();
        int mid = length / 2;
        String s;
        if (length % 2 == 0) {
            s = getMidString(str.charAt(mid - 1), str.charAt(mid));
            String left = str.substring(0, mid - 1);
            return createPalindrome(left, s);
        } else {
            s = getMidString(str.charAt(mid - 1), str.charAt(mid + 1));
            s = String.valueOf(s.charAt(0)) + str.charAt(mid) + s.charAt(1);
            String left = str.substring(0, mid - 1);
            return createPalindrome(left, s);
        }


    }

    private static String createPalindrome(String left, String mid) {
        if (left.length() <= 0 && carry > 0) {
            left = carry + "";
        } else if (left.length() > 0 && carry > 0) {
            left = (Integer.parseInt(left) + carry) + "";
        }
        StringBuilder sb = new StringBuilder(left);
        String right = sb.reverse().toString();
        return left + mid + right;
    }

    private static String getMidString(char left, char right) {
        // get mid 2 values;
        String s;
        if (left == right) {
            digit = left - '0';
            carry = 0;
            increment();
            s = digit + "" + digit;
        } else if (left < right) {
            s = right + "" + right;
        } else {
            s = left + "" + left;
        }
        return s;
    }

    private static void increment() {
        digit++;
        carry = digit / 10;
        digit = digit % 10;
    }
}
