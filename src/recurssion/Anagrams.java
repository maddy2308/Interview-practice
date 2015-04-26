package recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {

    public static void main(String[] args) {
        Anagrams obj = new Anagrams();
        List<Character> list = new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));
        obj.getAllPermutations(new StringBuilder(""), list);
    }

    void getAllPermutations(StringBuilder wordSoFar, List<Character> charLeft) {
        String str = wordSoFar.toString();
        if (wordSoFar.length() == 3) {
            System.out.println(wordSoFar);
            return;
        }
        for (int index = 0; index < charLeft.size(); index++) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(charLeft.get(index));
            // print combinations with no repetition
            getAllPermutations(sb, getNewList(index, charLeft));

            // print all possible combinations including repetition of characters
            getAllPermutations(sb, charLeft);
        }
    }

    List<Character> getNewList(int index, List<Character> lst) {
        List<Character> newList = new ArrayList<Character>();
        for (int i = 0; i < lst.size(); i++) {
            if (i != index) newList.add(lst.get(i));
        }
        return newList;
    }
}
