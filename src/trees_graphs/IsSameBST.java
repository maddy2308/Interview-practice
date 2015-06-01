package trees_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSameBST {

    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(2, 4, 3, 1, 5);
        List<Integer> second = Arrays.asList(2, 1, 4, 3, 5);
        System.out.println(isSameBST(first, second));

        List<Integer> f = Arrays.asList(8, 3, 6, 1, 4, 7, 10, 14, 13);
        List<Integer> s = Arrays.asList(8, 10, 14, 3, 6, 4, 1, 7, 13);
        System.out.println(isSameBST(f, s));

    }

    private static boolean isSameBST(List<Integer> first, List<Integer> second) {
        if (first.size() != second.size())
            return false;
        if ((first.size() > 0 && second.size() > 0) && (!first.get(0).equals(second.get(0))))
            return false;
        if (first.size() <= 1)
            return true;
        else {
            int indexA = first.get(0);
            List<Integer> leftFirst = new ArrayList<Integer>();
            List<Integer> rightFirst = new ArrayList<Integer>();
            List<Integer> leftSecond = new ArrayList<Integer>();
            List<Integer> rightSecond = new ArrayList<Integer>();
            for (int i = 1; i < first.size(); i++) {
                int element = first.get(i);
                if (indexA > element) {
                    leftFirst.add(element);
                } else {
                    rightFirst.add(element);
                }
            }
            for (int i = 1; i < second.size(); i++) {
                int element = second.get(i);
                if (indexA > element) {
                    leftSecond.add(element);
                } else {
                    rightSecond.add(element);
                }
            }
            return (isSameBST(leftFirst, leftSecond) && isSameBST(rightFirst, rightSecond));
        }
    }
}
