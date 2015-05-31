package strings;

import java.util.HashMap;
import java.util.Map;

class MostOccuring {
    public static void main(String[] args) {
        System.out.println(findMostOccuring("andy Andy andy Andy andy Andy andy Andy Andy"));
    }

    // andy table chair andy
    // ("andy table chair andy", 5) ==> andy,table,chair
    // a a b b c c c c d d h h i i i k k
    // a = 2, b = 2, c = 4, d =2, h = 2, i =3, k= 2

    // a,2

    private static String findMostOccuring(String input) {
        if (input != null && input.trim().length() > 0) {

            String[] split = input.split("\\s"); // {andy, table, chair, andy}
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (String s : split) {
                int frequency = 1;
                if (map.containsKey(s)) {
                    frequency = map.get(s) + 1;
                }
                map.put(s, frequency); // andy = 2, table = 1, chair = 1,
            }
            int globalMax = Integer.MIN_VALUE;
            String maxOccuringString = "";
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (globalMax < e.getValue()) {
                    maxOccuringString = e.getKey(); // andy
                    globalMax = e.getValue();  // 2
                }
            }
            return maxOccuringString;
        } else {
            return "";
        }
    }
}


/*
Test Cases:
(1) empty string
(2) String with only spaces
(3) andy Andy andy Andy andy Andy andy Andy Andy ==> Andy
(4) andy, andy Andy andy, ==> andy,
(5) andy table chair andy ==> andy
(6) null ==> ""
*/

// delimitter is space

//"andy,table chair andy" => "andy"
// "andy Andy" => andy
// "    ".trim() => ""
// null

// hashmap<String, Integer>