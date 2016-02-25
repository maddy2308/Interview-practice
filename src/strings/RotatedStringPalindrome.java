package strings;

public class RotatedStringPalindrome {

    public static void main(String[] args) {
        RotatedStringPalindrome obj = new RotatedStringPalindrome();
        System.out.println(obj.isRotatedStringPalindrome("01100110"));
    }

    private boolean isPalindrome(String str){
        int length = str.length();
        for (int left = 0, right = length - 1; left < length/2; left++, right--){
            if (str.charAt(left) != str.charAt(right)) return false;
        }
        return true;
    }

    private boolean isRotatedStringPalindrome(String str){
        for (int i = 1; i< str.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(i)).append(str.substring(0, i));
            if (isPalindrome(sb.toString())) return true;
        }
        return false;
    }
}
