package recurssion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintKeyStrokes {

    private Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();

    public PrintKeyStrokes() {
        map.put('0', null);
        map.put('5', null);
        map.put('1', Arrays.asList('a', 'b', 'c'));
        map.put('2', Arrays.asList('d', 'e', 'f'));
        map.put('3', Arrays.asList('g', 'h', 'i'));
    }

    public static void main(String[] args) {
        new PrintKeyStrokes().recurse("120", 0, "");
    }

    /*private void recurse(String str, int i, String resultSoFar) {
        if (i >= str.length()) {
            System.out.println(resultSoFar);
        } else {
            int j = i;
            char ch;
            while (((str.charAt(j) == '0') || (str.charAt(j) == '5')) && (j < str.length())) {
                j++;
            }
            i = j;
            if (i == str.length()){
                recurse(str, i, resultSoFar);
            } else {
                ch = str.charAt(j);
                List<Character> temp = map.get(ch);
                for (char c : temp) {
                    recurse(str, i + 1, resultSoFar + c);
                }
            }

        }
    }*/

    private void recurse(String str, int i, String resultSoFar) {
        if (i >= str.length()) {
            System.out.println(resultSoFar);
        } else {
            char ch = str.charAt(i);
            if (ch == '0' || ch == '5') {
                recurse(str, i + 1, resultSoFar);
            } else {
                List<Character> temp = map.get(ch);
                for (char c : temp) {
                    recurse(str, i + 1, resultSoFar + c);
                }
            }

        }
    }
}
