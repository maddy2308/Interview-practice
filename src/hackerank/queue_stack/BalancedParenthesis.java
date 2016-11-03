package hackerank.queue_stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

    private static boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.peek() != getOpeningBracket(ch)) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if (answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static char getOpeningBracket(char closeBracket) {
        switch (closeBracket) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return closeBracket;
        }
    }

    private static boolean isOpeningBracket(char ch) {
        return (ch == '{' || ch == '(' || ch == '[');
    }
}
