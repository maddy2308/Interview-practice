package dp;

import java.util.*;

public class GenerateI18NCombination {

    private Set<String> set = new HashSet<String>();

    private void recurse(String arr, String strSoFar) {
        if (arr.length() > 0) {
            set.add(strSoFar);
            String replace = replaceNumber(strSoFar, arr.length(), arr.charAt(0), true);
            if (!set.contains(replace)) {
                String s = arr.substring(1);
                recurse(s, replace);
            }
            replace = replaceNumber(strSoFar, arr.length(), arr.charAt(arr.length() - 1), false);
            if (!set.contains(replace)) {
                String s = arr.substring(0, arr.length() - 1);
                recurse(s, replace);
            }
        } else {
            set.add(strSoFar);
        }
    }

    private String replaceNumber(String str, int length, char ch, boolean isInFront) {
        String[] arr = str.split("\\d");
        if (length - 1 == 0) {
            return arr[0] + ch + arr[1];
        } else {
            if (isInFront) {
                return arr[0] + ch + (length - 1) + arr[1];
            } else {
                return arr[0] + (length - 1) + ch + arr[1];
            }
        }
    }

    public static void main(String[] args) {
        GenerateI18NCombination obj = new GenerateI18NCombination();
        obj.recurse("AREERCU", "C7P");
        List<String> sortedList = new ArrayList<String>(obj.set);
        Collections.sort(sortedList);
        System.out.println(sortedList);
    }

}
