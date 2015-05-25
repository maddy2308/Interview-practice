package test;

class Solution {
    public int solution(int[] A) {
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int max = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (Math.abs(A[i] - A[j]) <= 1) {
                    max++;
                }
            }
            globalMax = max > globalMax ? max : globalMax;
        }
        System.out.println(globalMax + 1);
        return globalMax + 1;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.solution(new int[]{6, 10, 6, 9, 7, 8});
    }

}
