package TechGig;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CandidateCode {

    private static Set<String> set = new HashSet<String>();
    private static Queue<String> q = new LinkedList<String>();
    private static final int[] BOTTLES = new int[]{10, 7, 5, 1};

    public static void main(String[] args) {
        int bottlesReqd = minimumBottles(23);
        System.out.println(bottlesReqd);
    }

    public static int minimumBottles(int input1) {
        q.add(input1 + ",");
        while (!q.isEmpty()) {
            String str = q.poll();
            set.add(str);
            int index = str.indexOf(',');
            int qtyLeft = Integer.parseInt(str.substring(0, index));
            for (int bottle : BOTTLES) {
                int left = qtyLeft - bottle;
                if (left == 0) {
                    System.out.println(left + "," + str);
                    return str.split(",").length;
                } else if (left > 0) {
                    String s = left + "," + str;
                    if (!set.contains(s)) {
                        q.add(s);
                    }
                }
            }
        }
        return -1;
    }
}
