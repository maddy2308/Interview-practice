package recurssion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KthLargestElement {

    List<Integer> newList, cloneList;

    public static void main(String[] args){
        List<Integer> lessList = Arrays.asList(-3, 12, 15, -28, -1, 22, 3, -15, 16, 17);
        Arrays.sort(lessList.toArray());
        System.out.println(new KthLargestElement().findKthLargestElement(1, lessList, null));
    }

    private int findKthLargestElement(int pivot, List<Integer> lessThanPivot, List<Integer> moreThanPivot){
        if (pivot <= 1){
            return Math.min(findMin(lessThanPivot), findMin(moreThanPivot));
        }
        int localPivot;
        if (pivot <= lessThanPivot.size()){
            localPivot = findPivot(lessThanPivot);
            int pivotElement = lessThanPivot.get(localPivot);
            separateList(lessThanPivot, pivotElement);
            lessThanPivot = cloneList;
            moreThanPivot = newList;
        } else {
            pivot -= lessThanPivot.size();
            localPivot = findPivot(moreThanPivot);
            int pivotElement = lessThanPivot.get(localPivot);
            separateList(moreThanPivot, pivotElement);
            moreThanPivot = cloneList;
            lessThanPivot = newList;
        }
        return findKthLargestElement(pivot, lessThanPivot, moreThanPivot);
    }

    private void separateList(List<Integer> originalList, int pivotElement){
        newList = new ArrayList<Integer>();
        cloneList = new ArrayList<Integer>();
        for (Integer anOriginalList : originalList) {
            int element = anOriginalList;
            if (element > pivotElement) {
                newList.add(element);
            } else {
                cloneList.add(element);
            }
        }
    }

    private int findPivot(List<Integer> list){
        int i;
        do {
            Random r = new Random();
            i = r.nextInt(list.size());
        }while(i >= list.size());
        return i;
    }

    private int findMin(List<Integer> list){
        int min = Integer.MAX_VALUE;
        if (list != null) {
            for (int element : list) {
                min = element < min ? element : min;
            }
        }
        return min;
    }
}
