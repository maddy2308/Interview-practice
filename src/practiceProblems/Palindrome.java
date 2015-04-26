package practiceProblems;

public class Palindrome {
    public static void main(String[] args) {
        int N = 12548;
        boolean flag = true;
        do {
            flag = !isPalindrome(N + "");
            N++;
        } while (flag);
        System.out.println(N - 1);
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
}
