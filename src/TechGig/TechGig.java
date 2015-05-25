package TechGig;


import java.util.HashMap;
import java.util.Map;


public class TechGig {
    public static String triplet_sum(int[] input1, int input2, int input3) {
        //Write code here
        Map<Integer, Integer> map = createMap(input1, input2);
        for (int i = 0; i < input2; i++) {
            for (int j = i + 1; j < input2; j++) {
                map.put(input1[i], map.get(input1[i]) - 1);
                map.put(input1[j], map.get(input1[j]) - 1);
                int rem = input3 - (input1[i] + input1[j]);
                if (rem > 0 && map.containsKey(rem) && map.get(rem) > 0) {
                    return "True";
                } else {
                    map.put(input1[i], map.get(input1[i]) + 1);
                    map.put(input1[j], map.get(input1[j]) + 1);
                }
            }
        }
        return "False";
    }

    private static Map<Integer, Integer> createMap(int[] arr, int length) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(length);
        for (int element : arr) {
            if (map.containsKey(element)) {
                int freq = map.get(element);
                map.put(element, freq + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(triplet_sum(new int[]{12, 3, 4, 1, 6, 9}, 6, 24));
        System.out.println(triplet_sum(new int[]{1, 4, 45, 6, 10, 8}, 6, 22));
        System.out.println(triplet_sum(new int[]{1, 3, 12, 4}, 4, 14));
    }
}