package practiceProblems;

import java.util.Stack;

public class RemoveSameColor {

    int numberOfSameColors = 0;
    private Stack<Character> stack = new Stack<Character>();


    public static void main(String[] args) {
        String str = "RGBBGRY";
        new RemoveSameColor().stackColors(str);

    }

    private void stackColors(String str) {
        for (char ch : str.toCharArray()) {
            if (stack.isEmpty())
                stack.push(ch);
            else {
                char peek = stack.peek();
                if (peek == ch) {
                    numberOfSameColors++;
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        System.out.println(numberOfSameColors);
    }
}
