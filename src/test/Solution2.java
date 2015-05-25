package test;

import java.util.*;

public class Solution2 {

    private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public int[] solution(int[] T) {
        int root = -1;

        // creating a representation of the Tree Structure for quick access
        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                root = i;
            } else {
                if (map.containsKey(T[i])) {
                    List<Integer> tempList = map.get(T[i]);
                    tempList.add(i);
                    map.put(T[i], tempList);
                } else {
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(i);
                    map.put(T[i], tempList);
                }
            }
        }
        return bfs(root, map, T.length - 1);
    }

    private int[] bfs(int root, Map<Integer, List<Integer>> map, int length) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] arr = new int[length];
        int level = 0;
        int currentLevel = 0, previousLevel = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int nodePopped = q.poll();
            previousLevel--;
            if (map.containsKey(nodePopped)) {
                for (int child : map.get(nodePopped)) {
                    q.add(child);
                    currentLevel++;
                }
            }
            if (previousLevel == 0) {
                arr[level] = currentLevel;
                level++;
                previousLevel = currentLevel;
                currentLevel = 0;

            }
        }
        return arr;
    }


    public static void main(String[] args) {
        Solution2 obj = new Solution2();
        int[] arr = obj.solution(new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1});
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

}
