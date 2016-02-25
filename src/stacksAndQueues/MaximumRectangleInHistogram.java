package stacksAndQueues;

import java.util.Stack;

public class MaximumRectangleInHistogram {


    public static void main(String[] args) {
        int[] histogramsArray = new int[]{2, 1, 3, 2, 1};
        System.out.println(getMaxArea(histogramsArray));
    }

    public static int getMaxArea(int[] histogramsArray) {
        Stack<Integer> st = new Stack<Integer>();
        int area = Integer.MIN_VALUE, globalArea = Integer.MIN_VALUE;
        for (int i = 0; i < histogramsArray.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                globalArea = performPopForArea(histogramsArray, st, globalArea, i);
                st.push(i);
            }
        }
        return emptyStackToGetMaxArea(histogramsArray, st, globalArea, histogramsArray.length);
    }

    private static int performPopForArea(int[] histogramsArray, Stack<Integer> st, int globalArea, int i) {
        while (!st.isEmpty() && histogramsArray[st.peek()] > histogramsArray[i]) {
            globalArea = calculateArea(histogramsArray, st, globalArea, i);
        }
        return globalArea;
    }

    private static int emptyStackToGetMaxArea(int[] histogramsArray, Stack<Integer> st, int globalArea, int i) {
        while (!st.isEmpty()) {
            globalArea = calculateArea(histogramsArray, st, globalArea, i);
        }
        return globalArea;
    }

    private static int calculateArea(int[] histogramsArray, Stack<Integer> st, int globalArea, int i) {
        int area = 0;
        int top = st.pop();
        if (st.isEmpty())
            area = histogramsArray[top] * i;
        else
            area = histogramsArray[top] * (i - st.peek() - 1);

        return area > globalArea ? area : globalArea;
    }
}
