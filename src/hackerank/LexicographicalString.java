package hackerank;

import java.io.IOException;
import java.util.Arrays;

public class LexicographicalString {

    public static void main(String[] args) throws IOException {
        LexicographicalString ls = new LexicographicalString();
        System.out.println(ls.getNextLexicographicalString("abcged"));
        /*BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\madhu_000\\Desktop\\testAnswerLexicographicalOrdering.txt"));
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\madhu_000\\Desktop\\testLexicographicalOrdering.txt"));
        int i = 0;
        try {
            String line = br.readLine();
            while (line != null) {
                i++;
                String str = ls.getNextLexicographicalString(line);
                System.out.println(str);
                assert (str).equals(br2.readLine()) : "not matched";
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
            br2.close();
        }
        System.out.println(i);*/
    }

    private String getNextLexicographicalString(String str) {
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i - 1 > 0 && !(arr[i] <= arr[i - 1])) {
                swap(arr, i, i - 1);
                char[] temp = Arrays.copyOfRange(arr, i, arr.length);
                Arrays.sort(temp);
                return getString(Arrays.copyOfRange(arr, 0, i)) + getString(temp);
            } else if (i == 0) {
                int index = getBiggerChar(arr[0], arr);
                if (index > 0) {
                    swap(arr, index, 0);
                    char[] temp = Arrays.copyOfRange(arr, 1, arr.length);
                    Arrays.sort(temp);
                    return arr[0] + getString(temp);
                }
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

    private int getBiggerChar(char ch, char[] arr) {
        char max = 256;
        int index = -1;
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if ((c > ch) && (c < max)) {
                max = c;
                index = i;
            }
        }
        return index;
    }
}
