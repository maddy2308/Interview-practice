package stacks;

import java.util.Stack;

public class Problem2 {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public Problem2() {
        int[] arr = {10, 12, 1, 3, 2, 15, 22, 0, 4, 5};
        for (int i : arr) {
            stack.push(i);
            if (!minStack.isEmpty()) {
                if (i < minStack.peek())
                    minStack.push(i);
                else
                    minStack.push(minStack.peek());
            } else {
                minStack.push(i);
            }
        }
    }

    public static void main(String[] args) {
        new Problem2();
    }

    public int min() {
        return minStack.pop();
    }
}
