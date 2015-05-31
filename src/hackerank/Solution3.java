package hackerank;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    public static void main(String args[]) throws Exception {

        System.out.println(similarities("ababaa"));
    }


    private static int similarities(String str) {
        List<String> strSuffixes = getSufixes(str);
        int[] similarityScore = getSimilarityScore(str, strSuffixes);
        int sum = 0;
        for (int aSimilarityScore : similarityScore) {
            sum += aSimilarityScore;
        }
        return sum;
    }

    private static int[] getSimilarityScore(String str, List<String> strSuffixes) {
        int[] similarityScore = new int[strSuffixes.size()];
        char[] strCharArray = str.toCharArray();
        for (int i = 0; i < strSuffixes.size(); i++) {
            char[] suffixCharArray = strSuffixes.get(i).toCharArray();
            boolean shouldContinue = true;
            for (int j = 0; j < suffixCharArray.length && shouldContinue; j++) {
                if (suffixCharArray[j] == strCharArray[j]) {
                    similarityScore[i]++;
                } else {
                    shouldContinue = false;
                }
            }
        }
        return similarityScore;
    }

    private static List<String> getSufixes(String str) {
        List<String> strSuffixes = new LinkedList<String>();
        String[] strSuffixes2 = new String[100000];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            strSuffixes.add(str.substring(i));
        }
        return strSuffixes;
    }

}

