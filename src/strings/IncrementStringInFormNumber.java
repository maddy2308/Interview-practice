package strings;

import java.util.Arrays;

public class IncrementStringInFormNumber {

    public static void main(String[] args) {
        new IncrementStringInFormNumber().increment(new StringBuilder("-10001236234682378462846387"));
    }

    private int add(int a, int b) {
        if (b == 0)
            return a;

        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    private StringBuilder addStringsAsNumbers(StringBuilder str1, StringBuilder str2) {
        StringBuilder sb = new StringBuilder();
        makeEqualLengthStrings(str1, str2);
        int carry = 0;
        for (int index = str1.length() - 1; index >= 0; index--) {
            int digit1 = str1.charAt(index) - '0';
            int digit2 = str2.charAt(index) - '0';
            int sum = carry + digit1 + digit2;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return (carry > 0) ? sb.append(carry) : sb;
    }

    private boolean checkIfCanAdd(StringBuilder str1, StringBuilder str2) {
        return ((str1.charAt(0) == '-') && (str2.charAt(0) == '-')) ||
                ((str1.charAt(0) != '-') && (str2.charAt(0) != '-'));
    }

    private void makeEqualLengthStrings(StringBuilder str1, StringBuilder str2) {
        int length1 = str1.length() - 1;
        int length2 = str2.length() - 1;
        char[] chars = new char[Math.abs(length1 - length2)];
        Arrays.fill(chars, '0');
        String rep = new String(chars);
        if (length1 < length2) {
            str1.reverse().append(rep).reverse();
        } else {
            str2.reverse().append(rep).reverse();
        }
    }

    private void increment(StringBuilder sb) {
        if (sb.charAt(0) == '-') {
            char[] arr = new StringBuilder(sb.substring(1)).reverse().toString().toCharArray();
            System.out.println(incrementHelperWithMinus(0, arr));
        } else {
            System.out.println(this.addStringsAsNumbers(sb, new StringBuilder("1")).reverse().toString());
        }
    }

    private String incrementHelperWithMinus(int index, char[] arr) {
        StringBuilder output = new StringBuilder();
        output.append("-");
        int digit = arr[index] - '0';
        int digit2 = 1;
        if (digit >= digit2) arr[index] -= 1;
        else {
            int i = index + 1;
            while (true) {
                digit = (arr[i] - '0');
                if (digit > 0) {
                    arr[i] = (char) (arr[i] - 1);
                    break;
                } else {
                    arr[i] = '9';
                }
                i++;
            }
            arr[index] = '9';
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output.append(arr[i]);
        }
        return output.toString();
    }
}
