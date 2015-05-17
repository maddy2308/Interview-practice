package practiceProblems;

import java.util.Arrays;

public class ReplaceSpaces {

    public static void main(String[] args) {
        char[] array = new char[21];
        char[] original = "this is a test".toCharArray();
        System.arraycopy(original, 0, array, 0, original.length);
        replaceSpaces(array, original.length);
        System.out.println(Arrays.toString(array));
    }

    private static void replaceSpaces(char[] array, int length) {

        int j = array.length - 1;
        for (int i = length - 1; i >= 0; i--, j--) {
            if (array[i] != ' ') {
                array[j] = array[i];
            } else {
                array[j] = '0';
                array[--j] = '2';
                array[--j] = '%';
            }
        }
    }

}
