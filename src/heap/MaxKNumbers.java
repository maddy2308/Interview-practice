package heap;


import java.util.*;

public class MaxKNumbers {

    public static void main(String[] args) {
        MaxKNumbers obj = new MaxKNumbers();
        PriorityQueueComparator comparator = new PriorityQueueComparator();
        int size = 10;
        Random r = new Random();
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int number : arr) {
            int freq = 1;
            if (map.containsKey(number)) {
                freq = map.get(number) + 1;
            }
            map.put(number, freq);
        }
        obj.createHeap(comparator, map, size);
    }

    private void createHeap(PriorityQueueComparator comparator, Map<Integer, Integer> map, int size) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<Map.Entry<Integer, Integer>>(size, comparator);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pq.size() == size) {
                Map.Entry<Integer, Integer> top = pq.peek();
                if (top.getValue() < e.getValue()) {
                    pq.remove();
                    pq.add(e);
                }
            } else {
                pq.add(e);
            }
        }
        System.out.println(pq);
        System.out.println(pq.size());
    }

    private static class PriorityQueueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
            return entry1.getValue() - entry2.getValue();
        }
    }
}
