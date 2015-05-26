package arrays;

import java.util.Stack;

public class NextGreatestElement {

    public static void main(String[] args) {
        findNGE(new int[]{4, 5, 2, 25, 20, 11, 13, 21, 3});
    }

    private static void findNGE(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                System.out.println(stack.pop() + " --> (" + arr[i] + ")");
            }
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> (" + -1 + ")");
        }
    }

}
