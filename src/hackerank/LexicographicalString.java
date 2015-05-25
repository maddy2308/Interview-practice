package hackerank;

import java.io.IOException;
import java.util.Arrays;

public class LexicographicalString {

    public static void main(String[] args) throws IOException {
        LexicographicalString ls = new LexicographicalString();
        System.out.println(ls.getNextLexicographicalString("dcba"));
    }

    private String getNextLexicographicalString(String str) {
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            if (!(arr[i] <= arr[i - 1])) {
                int index = getBiggerChar(arr[i - 1], arr, i);
                swap(arr, i - 1, index);
                char[] temp = Arrays.copyOfRange(arr, i, arr.length);
                Arrays.sort(temp);
                return getString(Arrays.copyOfRange(arr, 0, i)) + getString(temp);
            }
        }
        return "no answer";
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String getString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private int getBiggerChar(char ch, char[] arr, int j) {
        char max = 256;
        int index = -1;
        for (int i = j; i < arr.length; i++) {
            char c = arr[i];
            if ((c > ch) && (c < max)) {
                max = c;
                index = i;
            }
        }
        return index;
    }
}
