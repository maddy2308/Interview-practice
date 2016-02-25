package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class MedianOfStreamOfIntegers {


    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(20, Collections.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(20);

    private static int findMedian() {
        int i = 0;
        int median = 0;
        Random r = new Random();
        int streamLength = r.nextInt(50);
        int[] arr = new int[streamLength];
        while (i < streamLength) {
            arr[i] = r.nextInt(100);
            maintainHeapDS(arr[i]);
            i++;
        }
        if (maxHeap.size() - minHeap.size() >= 1) {
            median = maxHeap.peek();
        } else {
            median = (maxHeap.peek() + minHeap.peek()) / 2;
        }
        Arrays.sort(arr);
        int medianFromSortedArray = streamLength % 2 == 0 ?
                (arr[streamLength / 2] + arr[streamLength / 2 - 1]) / 2 : arr[streamLength / 2];
        assert medianFromSortedArray == median;
        System.out.println(Arrays.toString(arr));
        return median;
    }

    private static void maintainHeapDS(int number) {
        maxHeap.add(number);
        if (maxHeap.size() - minHeap.size() > 1) {
            int topFromMaxHeap = maxHeap.poll();
            minHeap.add(topFromMaxHeap);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedian());
    }
}
