package stacks;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }

    private static void reverse(Stack<Integer> s) {
        if (s.isEmpty())
            return;
        int e = s.pop();
        reverse(s);
        recurssivePush(s, e);
    }

    private static void recurssivePush(Stack<Integer> s, int e) {
        if (s.isEmpty()) {
            s.push(e);
            return;
        }
        int x = s.pop();
        recurssivePush(s, e);
        s.push(x);
    }
}
