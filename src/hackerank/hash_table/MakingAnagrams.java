package hackerank.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {

    private static int numberNeeded(String first, String second) {
        Map<Character, Integer> mapOfFirstString, mapOfSecondString;
        mapOfFirstString = createMap(first);
        mapOfSecondString = createMap(second);
        int deletionRequired = 0;
        for (Map.Entry<Character, Integer> entry : mapOfFirstString.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();
            if (mapOfSecondString.containsKey(key)) {
                deletionRequired += Math.abs(value - mapOfSecondString.get(key));
                mapOfFirstString.put(key, 0);
                mapOfSecondString.put(key, 0);
            } else {
                deletionRequired += value;
            }
        }

        for (Map.Entry<Character, Integer> entry : mapOfSecondString.entrySet()) {
            int value = entry.getValue();
            deletionRequired += value;
        }

        return deletionRequired;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        System.out.println(numberNeeded(first, second));
    }

    private static Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int freq = map.get(str.charAt(i));
                map.put(str.charAt(i), ++freq);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return map;
    }
}
