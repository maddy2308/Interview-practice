package epic;


import java.util.Arrays;

/*
    You can swap only two consecutive elements. You have to show all steps to convert a string into another string
    (both strings will be anagrams of each other).
    E.g. GUM to MUG
        GUM
        GMU
        MGU
        MUG
 */
public class ConvertAnagramToAnagram {

    public static void main(String[] args) {
        ConvertAnagramToAnagram obj = new ConvertAnagramToAnagram();
        obj.makeAnagram("MADHUR".toCharArray(), "DHAMRU".toCharArray());
    }

    private void makeAnagram(char[] src, char[] dest) {
        System.out.println(Arrays.toString(src));
        for (int i = 0; i < src.length; i++) {
            int k = i;
            while (src[k] != dest[i]) {
                k++;
            }
            if (k != i) {
                continuousSwap(src, i, k);
            } else {
                System.out.println(Arrays.toString(src));
            }
        }
    }

    private void continuousSwap(char[] src, int i, int j) {
        for (; j > i; j--) {
            char temp = src[j];
            src[j] = src[j - 1];
            src[j - 1] = temp;
            System.out.println(Arrays.toString(src));
        }
    }
}
