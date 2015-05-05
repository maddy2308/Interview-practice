package practiceProblems;

import java.util.*;
import java.util.regex.Pattern;

public class StringProblems {

    public static void main(String[] args) {
        StringProblems sp = new StringProblems();
        sp.convertToInteger("23.45");
        System.out.println(sp.generateLowestNumber("121198", 4));
        System.out.println(sp.solve("( + + 7 ( * 8 12 ) ( * * 2 ( + 9 4 ) 7 )"));
        System.out.println(sp.findLongestUniqueSubstring("123145"));
        sp.replaceAllWildCharacters("0?1?", 0);
        System.out.println(sp.list);
    }

    private void convertToInteger(String str) {
        if (Pattern.matches("-?\\d*\\.?\\d*", str)) {
            convertStringToNumber(str);
        } else {
            System.out.println("Invalid string representation of Integer");
        }
    }

    private void convertStringToNumber(String str) {
        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
        }
        String[] split = str.split(".");

    }

    private int convertLeftOfDecimal(String left) {
        return 0;
    }

    private float convertRightOfDecimal(String right) {
        return 0f;
    }

    public String generateLowestNumber(String number, int n) {
        if (number == null || number.length() < n) {
            return null;
        } else if (number.length() > n) {
            StringBuilder newNumber = new StringBuilder(generateHelper(number, n));
            int diffInRemovals = number.length() - newNumber.length();
            if (diffInRemovals != n) {
                newNumber = new StringBuilder(generateHelper(newNumber.reverse().toString(), n - diffInRemovals));
                number = newNumber.reverse().toString();
            } else {
                number = newNumber.toString();
            }
        }
        return number;
    }

    private String generateHelper(String number, int n) {
        int removed = 0;
        for (int i = 0, j = 1; removed != n && j != number.length(); ) {
            if (number.charAt(i) > number.charAt(j)) {
                number = number.substring(0, i) + number.substring(j, number.length());
                i = 0;
                j = 1;
                removed++;
            } else {
                i++;
                j++;
            }
        }
        return number;
    }

    private float solveExpression(boolean isPreOrder, String expression) {
        // fix the problem of reversing words only
        StringBuilder sb = new StringBuilder(expression);
        return isPreOrder ? solve(sb.reverse().toString()) : solve(sb.toString());
    }

    private float solve(String expression) {
        Stack<Float> stack = new Stack<Float>();
        String[] arr = expression.split(" ");
        for (int index = arr.length - 1; index >= 0; index--) {
            if (!(arr[index].equals("(") || arr[index].equals(")"))) {
                if (arr[index].equals("+")) {
                    Operands op = Operands.createOperand(stack);
                    stack.push(sum(op.firstOperand, op.secondOperand));
                } else if (arr[index].equals("-")) {
                    Operands op = Operands.createOperand(stack);
                    stack.push(sub(op.firstOperand, op.secondOperand));
                } else if (arr[index].equals("*")) {
                    Operands op = Operands.createOperand(stack);
                    stack.push(multiply(op.firstOperand, op.secondOperand));
                } else if (arr[index].equals("/")) {
                    Operands op = Operands.createOperand(stack);
                    stack.push(divide(op.firstOperand, op.secondOperand));
                } else {
                    stack.push(Float.parseFloat(arr[index]));
                }
            }
        }
        return stack.pop();
    }

    private float sum(float a, float b) {
        return (a + b);
    }

    private float sub(float a, float b) {
        return sum(a, -1 * b);
    }

    private float multiply(float a, float b) {
        return a * b;
    }

    private float divide(float a, float b) {
        if (b == 0)
            throw new IllegalArgumentException("The division by zero is not acceptable");
        else
            return a / b;
    }

    private static class Operands {
        private float firstOperand, secondOperand;

        public Operands(float secondOperand, float firstOperand) {
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
        }

        static Operands createOperand(Stack<Float> st) {
            if (st.size() >= 2) {
                return new Operands(st.pop(), st.pop());
            } else {
                throw new IndexOutOfBoundsException("Not enough parameters to perform operation");
            }
        }
    }


    private String findLongestUniqueSubstring(String str) {
        System.out.println(str);
        int[] indexPosition = new int[256];
        Arrays.fill(indexPosition, -1);
        String maxSoFar = "";
        StringBuilder soFar = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int index = 0; index < arr.length; index++) {
            if (indexPosition[arr[index]] < 0) {
                soFar.append(arr[index]);
                maxSoFar = maxSoFar.length() < soFar.length() ? soFar.toString() : maxSoFar;
                indexPosition[arr[index]] = index;
            } else {
                index = indexPosition[arr[index]];
                soFar = new StringBuilder();
                Arrays.fill(indexPosition, -1);
            }

        }
        return soFar.toString();
    }

    private List<String> list = new ArrayList<String>();

    private void replaceAllWildCharacters(String str, int i) {
        if (!str.contains("?")) {
            list.add(str);
        } else {
            StringBuilder sb = new StringBuilder(str);
            for (; i <= str.indexOf('?'); i++) {
                if (str.charAt(i) == '?') {
                    char[] possibilities = new char[]{'0', '1'};
                    for (char ch : possibilities) {
                        sb.setCharAt(i, ch);
                        replaceAllWildCharacters(sb.toString(), i + 1);
                    }
                }
            }
        }
    }
}
