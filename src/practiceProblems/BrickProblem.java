package practiceProblems;

import java.util.*;

public class BrickProblem {

    private Set<String> set = new HashSet<String>();
    public static void main(String[] args) {
        BrickProblem obj = new BrickProblem();
        obj.recurse(new int[]{1, 2}, 12, "");
        System.out.println(obj.set);
    }

    private void recurse(int arr[], int sum, String sequence){
        if (sum == 0 && !set.contains(sortedString(sequence))){
            set.add(sequence);
        } else {
            for (int brick : arr) {
                if (sum - brick >= 0) {
                    recurse(arr, sum - brick, sequence + brick);
                }
            }
        }
    }

    private String sortedString(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
