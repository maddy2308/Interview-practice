package stacks;

import java.util.Stack;

public class Problem6 {

    static Stack<Integer> orderedStack = new Stack<Integer>();
    static Stack<Integer> helperStack = new Stack<Integer>();

    public static void main(String[] args) {
        int array[] = {1, 2, 4, 5, 3, 7, 6};
        for (int index = 0; index < array.length; index++) {
            sortUsingStack(array[index]);
        }
        while (!orderedStack.isEmpty()) {
            System.out.println(orderedStack.pop().intValue());
        }
    }

    public static void sortUsingStack(Integer input) {
        // if the stack is empty
        if (orderedStack.isEmpty()) {
            orderedStack.push(input);
        }
        // if the top of the stack is greater than the input then pop
        // until the stack top is lesser than the input
        else if (orderedStack.peek().intValue() > input.intValue()) {
            do {
                helperStack.push(orderedStack.pop());
            } while (orderedStack.peek().intValue() > input.intValue());

            orderedStack.push(input);
            while (!helperStack.isEmpty()) {
                orderedStack.push(helperStack.pop());
            }
        }
        // if input is greater than top of the stack
        else {
            orderedStack.push(input);
        }
    }
}
