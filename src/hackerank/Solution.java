package hackerank;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
// An "expression" is either a number, or a list (AKA vector/array) with the first element one of '+', '-', '*', '/' , and then other expressions. Write a function "evaluate" that gets an expression and returns its value.

// ['+', 1, 2] --> 3
// ['*', 3, ['+', 1, 10]] --> 33
// ['+', 1000, 1200] --> 2200
// ['/', 6, ['+', 1, ['*', 1, 1]]] --> 3
// ['+', 1, 2, 3] --> 6
// ['+', ['*', 1, 2], 3] --> 5
// ['-', ['+', 1, 1], 1] --> 1
// Assume - / -- only take two operands
// + * take any number of operands

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE);
        list.add(1);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        /*List<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(1);
        */
        //Expression root = new Expression('+', list, new Expression('*', list2, null));
        //Expression root = new Expression('/', list, new Expression('+', list2, new Expression('*', list3, null)));
        Expression root = new Expression('-', list, new Expression('+', list2, null));
        System.out.println(evaluate(root));

    }

    public static int evaluate(Expression root) throws ArithmeticException {
        if (root.subExpression == null) {
            return evaluateSubExpression(root);
        } else {
            int result = evaluate(root.subExpression);
            root.subExpression = null;
            if (root.operator == '-' || root.operator == '/') {
                for (int i = 0; i < root.numbers.size(); i++) {
                    if (root.numbers.get(i) == Integer.MIN_VALUE) {
                        root.numbers.set(i, result);
                    }
                }
            } else {
                root.numbers.add(result);
            }
            return evaluateSubExpression(root);
        }
    }

    // assuming it return integer values
    private static int evaluateSubExpression(Expression root) throws ArithmeticException {
        int result = 0;
        switch (root.operator) {
            case '+':
                for (int operand : root.numbers) {
                    result += operand;
                }
                break;
            case '-':
                result = subtraction(root.numbers);
                break;
            case '*':
                result = 1;
                for (int operand : root.numbers) {
                    if (operand == 0) {
                        result = 0;
                        break;
                    }
                    result *= operand;
                }
                break;
            case '/':
                result = division(root.numbers);
                break;
        }
        return result;
    }

    private static int subtraction(List<Integer> numbers) {
        return numbers.get(0) - numbers.get(1);
    }

    private static int division(List<Integer> numbers) {
        if (numbers.get(1) == 0)
            throw new ArithmeticException();
        else {
            return numbers.get(0) / numbers.get(1);
        }
    }

    private static class Expression {
        char operator; //-
        List<Integer> numbers; // 1, 2
        Expression subExpression; // null

        public Expression(char operator, List<Integer> numbers, Expression subExpression) {
            this.operator = operator;
            this.numbers = numbers;
            this.subExpression = subExpression;
        }
    }

}





