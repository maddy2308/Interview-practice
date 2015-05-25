package practiceProblems;

import java.util.*;

public class Solution2 {

    static int longest_chain(String[] w) {
        SortedSet<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Collections.addAll(set, w);
        System.out.println(set);
        return solution(set);
    }

    // define map
    static int solution(SortedSet<String> set) {
        int count, chain = 1, maxChain = -1;
        Set<String> uniqueWords = new HashSet<String>();
        for (String str : set) {
            count = 0;
            for (int i = 0; i < str.length(); i++) {
                String res = str.substring(0, i) + str.substring(i + 1);
                if (!uniqueWords.contains(res) && set.contains(res)) {
                    uniqueWords.add(res);
                    count++;
                }
            }
            if (count > 0) {
                chain++;
            }
            maxChain = maxChain < chain ? chain : maxChain;
        }
        return maxChain;
    }

    static SortedSet<String> hashMap =
            new TreeSet<String>(Collections.reverseOrder());

    public static void main(String[] args) {
        String s[] = {"a", "cx", "abc", "abd", "abcde"};
        System.out.println(longest_chain(s));
    }

}
