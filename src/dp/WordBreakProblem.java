package dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    private static Set<String> dictionary = new HashSet<String>();

    private static boolean[][] isStringCombinationOfWords(String str) {
        boolean[][] dpArray = new boolean[str.length()][str.length()];
        for (int length = 1; length <= str.length(); length++) {
            for (int i = 0; i + length <= str.length(); i++) {
                String s = str.substring(i, i + length);
                if (dictionary.contains(s)) {
                    dpArray[i][i + length - 1] = true;
                } else {
                    int k = 0;
                    for (; k < s.length(); k++) {
                        if (dpArray[i][i + k] && dpArray[i + k + 1][i + s.length() - 1]) {
                            dpArray[i][i + s.length() - 1] = true;
                            break;
                        }
                    }
                    if (k == s.length()) {
                        dpArray[i][i + s.length() - 1] = false;
                    }
                }
            }
        }
        return dpArray;
    }

    private static void printDpArray(boolean[][] dpArray) {
        for (boolean[] aDpArray : dpArray) {
            for (int j = 0; j < dpArray[0].length; j++) {
                if (aDpArray[j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dictionary.add("I");
        dictionary.add("AM");
        dictionary.add("ACE");
        dictionary.add("A");

        printDpArray(isStringCombinationOfWords("IAMAACE"));
    }

}
