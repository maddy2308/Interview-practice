package hackerank.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    private PriorityQueue<Integer> maxBucket = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    private PriorityQueue<Integer> minBucket = new PriorityQueue<Integer>();

    private void insertInBucket(int number) throws Exception {
        if (maxBucket.size() == 0) {
            maxBucket.add(number);
        } else if (minBucket.size() == 0 && maxBucket.peek() > number) {
            insertInBucket(maxBucket, minBucket, number);
        } else if (minBucket.size() == 0) {
            minBucket.add(number);
        } else if (number <= maxBucket.peek()) { // if number less than the peek of left bucket
            if (maxBucket.size() > minBucket.size()) {
                insertInBucket(maxBucket, minBucket, number);
            } else if (maxBucket.size() <= minBucket.size()) {
                maxBucket.add(number);
            }
        } else if (number > maxBucket.peek() && number < minBucket.peek()) { // if number lies b/w 2 buckets
            if (maxBucket.size() > minBucket.size()) {
                minBucket.add(number);
            } else if (maxBucket.size() <= minBucket.size()) {
                maxBucket.add(number);
            }
        } else {
            if (maxBucket.size() >= minBucket.size()) { // if number greater than the peek of bucket
                minBucket.add(number);
            } else if (maxBucket.size() < minBucket.size()) {
                insertInBucket(minBucket, maxBucket, number);
            }
        }
    }

    private void insertInBucket(PriorityQueue<Integer> bucket1, PriorityQueue<Integer> bucket2, Integer number) throws Exception {
        if (bucket1.size() - bucket2.size() == 1) {
            int poll = bucket1.poll();
            bucket2.add(poll);
            bucket1.add(number);
        } else {
            throw new Exception("The buckets are breaking the constraint of size difference");
        }
    }

    private float getMedian() {
        if (maxBucket.size() == minBucket.size()) {
            return (float) ((maxBucket.peek() + minBucket.peek()) / 2.0);
        } else if (maxBucket.size() > minBucket.size()) {
            return maxBucket.peek();
        } else {
            return minBucket.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        RunningMedian rm = new RunningMedian();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            array[a_i] = in.nextInt();
        }

        for (int number : array) {
            rm.insertInBucket(number);
            System.out.println(rm.getMedian());
        }
    }
}
