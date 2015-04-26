package strings;

import Utility.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxKStrings {

    private HeapComparator comparator = new HeapComparator();

    public static void main(String[] args) {
        MaxKStrings obj = new MaxKStrings();
        Heap<Map.Entry<String, Integer>> minHeap = new Heap<Map.Entry<String, Integer>>(6, obj.comparator);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test", 3);
        map.put("hello", 4);
        map.put("a1", 6);
        map.put("hello2", 7);
        map.put("a2", 1);
        map.put("test2", 2);
        for (Map.Entry each : map.entrySet()) {
            minHeap.insertElement(each);
        }
        Map.Entry topEntry = null;
        do {
            topEntry = minHeap.topElement();
            if (topEntry != null) {
                System.out.println(topEntry.getKey() + " ---> " + topEntry.getValue());
            }
        }while(topEntry != null);
    }

    class HeapComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
            return entry1.getValue() - entry2.getValue();
        }
    }
}
