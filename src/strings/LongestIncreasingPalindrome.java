package strings;

public class LongestIncreasingPalindrome {
    static int longestStart = 0;
    static int longestEnd = 0;

    public static void main(String[] args) {
        System.out.println(LongestIncreasingPalindrome.lip("76812345654321982"));
    }

    private static String lip(String input){
        char[] str = input.toCharArray();
        for (int mid = 0; mid < str.length; mid++){
            checkPalindrome(str, mid, mid);
            checkPalindrome(str, mid, mid+1);
        }
        return input.substring(longestStart, longestEnd+1);
    }

    private static void checkPalindrome(char[] str, int left, int right){
        while (left >= 0 && right < str.length){
            if (str[left] == str[right]){
                if (right-left > longestEnd-longestStart){
                    longestEnd = right;
                    longestStart = left;
                }
            } else {
                break;
            }
            left--;
            right++;
        }
    }
}
